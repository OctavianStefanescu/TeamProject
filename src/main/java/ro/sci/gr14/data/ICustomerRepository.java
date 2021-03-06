package ro.sci.gr14.data;

/*
 * An application that helps homeowners find handymen/craftsmen suitable for any task at hand
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.gr14.model.Customer;

/**
 * Repository interface to manage {@link Customer} instances
 * Provides basic CRUD operations due to the extension of {@link CrudRepository}
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
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Returns the Customer with the given username
     *
     * @param username a String representing the account name of the user
     */
    Customer findByUsername(String username);

}