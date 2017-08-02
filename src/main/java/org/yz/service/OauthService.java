package org.yz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yz.dao.OauthDao;
import org.yz.domain.Account;
import org.yz.dao.Message;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 张鹏程 on 2017/6/19.
 */
@Service
public class OauthService {

    @Autowired
    private OauthDao oauthDao;

    @Autowired
    private AccountService accountService;

    /**
     * 通过用户名和密码获取token
     * @param username
     * @param password
     * @return
     */
    public Message getTokenByNameAndPassword(String username, String password) {
        String token = oauthDao.getAccessTokenByNameAndPassword(username, password);
        Message message = new Message("10000", "Success", "");
        if (token != null) {
            message.setResult(token);
        } else {
            message.setCode("10004");
            message.setMessage("用户名或密码错误！");
        }

        return message;
    }

    /**
     * 保存access_token
     * @param user_id
     * @param access_token
     * @return
     */
    private Integer saveAccessToken(Long user_id, String access_token) {
        return oauthDao.saveAccessToken(user_id, access_token);
    }
    /**
     * 产生access_token
     * @param username
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    Message generateAccessToken(String username, String password){
        Message message = new Message("10000", "", "");
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            StringBuffer sb = new StringBuffer();
            sb.append(username);
            sb.append(password);
            String access_token = base64Encoder.encode(md5.digest(sb.toString().getBytes("utf-8")));
            message.setCode("10000");
            message.setResult(access_token);
        }catch (NoSuchAlgorithmException e) {
            message.setCode("10002");
            message.setResult(e.getMessage());
        }catch (UnsupportedEncodingException e) {
            message.setCode("10003");
            message.setResult(e.getMessage());
        }
        return message;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param confirm_password
     * @return
     */
    @Transactional
    public Message register(String username, String password, String confirm_password){
        Message message = new Message("10000", "", "");
        if (0 != password.compareTo(confirm_password)) {
            message.setCode("10003");;
            message.setMessage("两次密码输入不一致");
            return message;
        }
        Account account = accountService.findByName(username);
        if (account != null) {
            message.setCode("10002");
            message.setMessage("用户已存在！");
            return message;
        }else {
            Account new_account = new Account();
            new_account.setUsername(username);
            new_account.setPassword(password);
            Long user_id = accountService.saveUser(new_account);
            String access_token = "";
            if (user_id > 0) {
                Message token_message = this.generateAccessToken(username, password);
                if (token_message.getCode() == "10000") {
                    access_token = token_message.getResult();
                    this.saveAccessToken(user_id, access_token);
                }
            }
            message.setCode("10000");
            message.setResult(access_token);
            message.setMessage("注册成功！");
            return message;
        }
    }
}
