package com.exchangeService.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractJDBCDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Connection connection;

    protected abstract String getCreateQuery();

    public abstract String getSelectQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getUpdateQuery();

    protected abstract List<T> parseResultSet(ResultSet resultSet);

    protected abstract void preparedStatementForDelete(PreparedStatement preparedStatement, T object);

    protected abstract void preparedStatementForInsert(PreparedStatement preparedStatement, T object);

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T getByPK(int id) throws PersistException {
//        int id_key = (int)id;
        List<T> resultList;
        String query = getSelectQuery();
        query += " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultList = parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (resultList == null || resultList.size() == 0) {
            return null;
        }
        if (resultList.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return resultList.iterator().next();
    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> resultList;
        String query = getSelectQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultList = parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return resultList;
    }

    @Override
    public void update(T object) throws PersistException {
        String query = getUpdateQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatementForInsert(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(T object) throws PersistException {
        String query = getDeleteQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatementForDelete(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public T persist(T object) throws PersistException {
//        if (object.getId() != null) {
//            throw new PersistException("Object is already persist.");
//        }
//        T persistInstance;
//        String query = getCreateQuery();
//        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
//            preparedStatementForInsert(preparedStatement, object);
//            int count = preparedStatement.executeUpdate();
//            if(count != 1){
//                throw new PersistException("On persist modify more then 1 record: " + count);
//            }
//        } catch (SQLException e) {
//            throw new PersistException(e);
//        }
//
//        query = getSelectQuery() + " WHERE id = last_insert_id();";//where can i find this method | LASTVAL();
//        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<T> resultSetList = parseResultSet(resultSet);
//            if(resultSetList == null || resultSetList.size() != 1){
//                throw new PersistException("Exception on findByPK new persist data.");
//            }
//            persistInstance = resultSetList.iterator().next();
//        } catch (SQLException e) {
//            throw new PersistException(e);
//        }
//        return persistInstance;
        return null;
    }
}
