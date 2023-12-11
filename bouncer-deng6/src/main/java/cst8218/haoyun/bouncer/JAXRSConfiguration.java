package cst8218.haoyun.bouncer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class implements data security, links to the database through annotations, and uses the browser's own methods to log in.
 *
 * @author Juneau
 */
@ApplicationScoped
@Named
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:comp/DefaultDataSource'}",
        callerQuery = "#{'select password from app.AppUser2 where username = ?'}",
        groupsQuery = "select groupname from app.AppUser2 where username = ?",
        hashAlgorithm = PasswordHash.class,
        priority = 10
)
@BasicAuthenticationMechanismDefinition
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

}
