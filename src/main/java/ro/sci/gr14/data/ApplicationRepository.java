package ro.sci.gr14.data;

/*
 * An application that helps homeowners find handymen/craftsmen suitable for any task at hand
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.sci.gr14.model.City;
import ro.sci.gr14.model.County;
import ro.sci.gr14.model.DBEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Queries the database for city, county and handyman specialty data and retrieves the information
 * Marked as a Data Access Object
 *
 * @author Cristina Lenghel
 * @author Octavian Stefanescu
 * @author Marius-Laurentiu Lorincz
 * @author Cosmin Toma
 * @author Serban Moraru
 * @version 1.0
 * @since 2019-05-08
 */
@Repository
public class ApplicationRepository {
    private JdbcTemplate jdbc;

    /**
     * Autowired constructor
     * used to load location data from the database for register and queries
     *
     * @param jdbc the Spring MVC {@link JdbcTemplate}
     */
    @Autowired
    public ApplicationRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    /**
     * Queries the database for county location data
     *
     * @return {@link County} query
     */
    public List<County> findAllCounty( ){
        return jdbc.query("select id, name from county",
                this::mapRowToCounty);
    }

    /**
     * Retrieves data representing a database county location data result set
     * generated by executing a statement that queries the database
     *
     * @param rs     the result set obtained using {@link ResultSet}
     * @param rowNum row number the {@link County} instances
     * @return the instance of {@link County}
     * @throws SQLException providing information an a database access error
     */
    private County mapRowToCounty(ResultSet rs, int rowNum)
            throws SQLException{
        return new County(rs.getLong("id"), rs.getString("name"));
    }

    /**
     * Queries the database for city location data
     *
     * @return {@link City} query
     */
    public List<City> findAllCity( ){
        return jdbc.query("select id, name from city",
                this::mapRowToCity);
    }

    /**
     * Queries the database for city location data filtered by county
     *
     * @param countyname a String representing the county name
     * @return {@link City} query
     */
    public List<City> findAllCityByCounty(String countyname){
        return jdbc.query("select id, name from city where countyname='" + countyname + "'",
                this::mapRowToCity);
    }

    /**
     * Retrieves data representing a database county location data result set
     * generated by executing a statement that queries the database
     *
     * @param rs     the result set obtained using {@link ResultSet}
     * @param rowNum row number for the {@link City} instances
     * @return the instance of {@link City}
     * @throws SQLException providing information an a database access error
     */
    private City mapRowToCity(ResultSet rs, int rowNum)
            throws SQLException{
        return new City(rs.getLong("id"), rs.getString("name"));
    }


    /**
     * Queries the database for handyman specialty data
     *
     * @return {@link DBEntity} query
     */
    public List<DBEntity> findAllHandicraft( ){
        return jdbc.query("select id, name from handicraft",
                this::mapRowToDBEntity);
    }

    /**
     * Retrieves data representing a database handyman specialty data result set
     * generated by executing a statement that queries the database
     *
     * @param rs     the result set obtained using {@link ResultSet}
     * @param rowNum row number for the {@link DBEntity} instances
     * @return the instance of {@link DBEntity}
     * @throws SQLException providing information an a database access error
     */
    private DBEntity mapRowToDBEntity(ResultSet rs, int rowNum)
            throws SQLException{
        return new DBEntity(rs.getLong("id"), rs.getString("name"));
    }
}
