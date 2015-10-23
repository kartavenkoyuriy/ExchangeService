package com.exchangeService.dao;

import com.exchangeService.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostrgesAccountDao extends AbstractJDBCDao<Account, Integer> {

    private final Connection connection;//is needed

    public PostrgesAccountDao(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    private class PersistAccount extends Account {
        public void setId(int id) {
            super.setId(id);
        }
    }



    public Account create() {
        return null;
    }

    @Override
    protected String getCreateQuery() {
        return "SELECT id, fullName, login, password FROM account;";
    }

    @Override
    public String getSelectQuery() {
        return "INSERT INTO account (fullName, login, password) VALUES (?, ?, ?);";
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected List<Account> parseResultSet(ResultSet resultSet) {
        return null;
    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement preparedStatement, Account object) {

    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Account object) {

    }

    public void update(Account account) {

    }

    public void delete(Account account) {

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
