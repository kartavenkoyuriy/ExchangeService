package com.exchangeService.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    Connection getConnection() throws SQLException;//throws?

    AccountDao getAccountDao(Connection connection);

    WalletDao getWalletDao(Connection connection);
}
