package com.exchangeService.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostrgesDaoFactory implements DaoFactory {

    private String login = "postgres";
    private String password = "root";
    private String url = "jdbc:postgresql://localhost:5432/ExchangeDB";
    private String driver = "org.postgresql.Driver";//is correct?

    public PostrgesDaoFactory() {
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//write something
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    public AccountDao getAccountDao(Connection connection) {
        return new PostrgesAccountDao(connection);
    }

    public WalletDao getWalletDao(Connection connection) {
        return null;
    }
}
