package cst8218.haoyun.bouncer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationScoped
@Named
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:comp/DefaultDataSource'}",
        callerQuery = "#{'select password from app.appuser where username = ?'}",
        groupsQuery = "select groupname from app.appuser where username = ?",
        hashAlgorithm = PasswordHash.class,
        priority = 10
)
@BasicAuthenticationMechanismDefinition
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

}
