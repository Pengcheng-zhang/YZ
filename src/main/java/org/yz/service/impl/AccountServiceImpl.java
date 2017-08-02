package org.yz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yz.dao.AccountDao;
import org.yz.domain.Account;
import org.yz.service.AccountService;

import java.util.Optional;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public Optional<Account> getUserById(Long id) {
        return Optional.ofNullable(accountDao.selectUserById(id));
    }

    public Long saveUser(Account account) {
        return accountDao.insertUser(account);
    }

    public boolean deleteUserById(Long id) {
        return accountDao.deleteUserById(id);
    }

    public Integer modifyUserOnPasswordById(Long id) {
        return accountDao.updateUserOnPasswordById(id);
    }

    public Account findByName(String username) {
        return accountDao.selectUserByUsername(username);
    }

    public Integer updateArtLevel() {
        return 0;
    }
    public Integer updatePieceLevel(){
        return 0;
    }
    public Integer updateMockLevel(){
        return 0;
    }
}
