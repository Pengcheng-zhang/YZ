package org.yz.dao;

import org.springframework.stereotype.Repository;
import org.yz.domain.Account;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
@Repository
public interface AccountDao {
    Account selectUserById(Long id);
    Account selectUserByUsername( String username);
    List<Account> selectAllUsers();
    Long insertUser(Account account);
    Integer updateUserOnPasswordById(Long id);
    boolean deleteUserById(Long id);
}
