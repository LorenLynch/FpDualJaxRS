package edu.fpdual.webservice.model.manager;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public interface Manager<T, U> {
    /**
     * Finds all the entities in the DB
     *
     * @param con DB connection
     * @return a {@link List} of {@link T}
     */
    List<T> findAll(Connection con);

    /**
     * Finds all the entities in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param id Entities id to search for.
     * @return a {@link T}
     */
    T findById(Connection con, U id);

    /**
     * Finds all the entities in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param ids Entities id set to search for.
     * @return a {@link List} of {@link T}
     */
    List<T> findAllByIds(Connection con, Set<U> ids);

    /**
     * Delete a city using its id.
     *
     * @param con DB connection
     * @param id Entities id to delete.
     * @return a {@link Boolean}
     */
    boolean delete(Connection con, U id);

    /**
     * Creates a city
     *
     * @param con DB connection
     * @param city The city to create
     * @return a {@link Boolean}
     */
    boolean create(Connection con, T city);

    /**
     * updates a city
     *
     * @param con DB connection
     * @param city The city to create
     * @return a {@link Boolean}
     */
    boolean update(Connection con, T city);
}