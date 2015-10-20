package com.exchangeService.dao;

import com.exchangeService.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostrgesAccountDao implements AccountDao {

    private final Connection connection;

    public PostrgesAccountDao(Connection connection) {
        this.connection = connection;
    }

    public Account create() {
        return null;
    }

    public Account read(int id) throws SQLException {
        String query = "SELECT * FROM account WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Account resultAccount = new Account();
        resultAccount.setId(resultSet.getInt("id"));
        resultAccount.setFullName(resultSet.getString("fullName"));
        resultAccount.setLogin(resultSet.getString("login"));
        resultAccount.setPassword(resultSet.getString("password"));

        return resultAccount;
    }

    public void update(Account account) {

    }

    public void delete(Account account) {

    }

    public List<Account> getAllAccounts() throws SQLException {
        String query = "SELECT * FROM account";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Account> resultAccounts = new ArrayList<>();
        while(resultSet.next()){
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setFullName(resultSet.getString("fullName"));
            account.setLogin(resultSet.getString("login"));
            account.setPassword(resultSet.getString("password"));
            resultAccounts.add(account);
        }
        return resultAccounts;
    }
}
