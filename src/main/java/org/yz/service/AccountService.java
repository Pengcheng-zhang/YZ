package org.yz.service;


import org.yz.domain.Account;

import java.util.Optional;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
public interface AccountService {
    Optional<Account> getUserById(Long id);
    Long saveUser(Account account);
    Integer modifyUserOnPasswordById(Long id);
    boolean deleteUserById(Long id);
    Account findByName(String name);
    Integer updateArtLevel();
    Integer updatePieceLevel();
    Integer updateMockLevel();
}
