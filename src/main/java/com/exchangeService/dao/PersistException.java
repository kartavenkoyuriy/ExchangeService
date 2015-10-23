package com.exchangeService.dao;

import java.sql.SQLException;

public class PersistException extends Exception {
    public PersistException(SQLException e) {

    }

    public PersistException(String s) {

    }
}
