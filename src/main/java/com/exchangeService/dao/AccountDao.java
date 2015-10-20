package com.exchangeService.dao;

import com.exchangeService.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    Account create();

    Account read(int id) throws SQLException;

    void update(Account account);

    void delete(Account account);

    List<Account> getAllAccounts() throws SQLException;//throws?

}
