package edu.fpdual.webservice.model.manager;

import edu.fpdual.webservice.model.dao.City;

import java.sql.Connection;
import java.util.Set;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Cities data.
 *
 * @author loren.lynch.mcrae
 *
 */
public interface CityManager extends Manager<City, Integer>{

    /**
     * Finds all the entities in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param countryCode Country code to use for the search
     * @return a {@link Set} of {@link City}
     */
    Set<City> findByCountryCode(Connection con, String countryCode);

}