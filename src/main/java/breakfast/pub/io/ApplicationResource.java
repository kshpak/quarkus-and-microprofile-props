package breakfast.pub.io;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import breakfast.pub.io.config.UserConfigurationFromInterface;
import breakfast.pub.io.config.interfaces.UserConfigurationInterface;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import breakfast.pub.io.config.UserConfiguration;

@Path("/myapp")
public class ApplicationResource {

    @Inject
    UserConfiguration userConfiguration;

    @Inject
    UserConfigurationInterface userConfigurationInterface;

    @Inject
    UserConfigurationFromInterface userConfigurationClassWithInterface;

    @ConfigProperty(name = "myapp.title")
    String applicationTitle;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printAppTitle() {
        return applicationTitle;
    } //curl http://localhost:8081/myapp -> Breakfast Pub

    @GET
    @Path("/config-class")
    @Produces(MediaType.TEXT_PLAIN)
    public String printClass() {
        return "Status: " + userConfiguration.status
                + " Minimum allowed posts: " + userConfiguration.posts.min
                + " Maximum allowed posts: " + userConfiguration.posts.max;
    }

    @GET
    @Path("/config-interface")
    @Produces(MediaType.TEXT_PLAIN)
    public String printInterface() {
        return "Status: " + userConfigurationInterface.status()
                + " Minimum allowed posts: " + userConfigurationInterface.posts().min()
                + " Maximum allowed posts: " + userConfigurationInterface.posts().max();
    }

    @GET
    @Path("/config-interface-with-class")
    @Produces(MediaType.TEXT_PLAIN)
    public String printClassWithInterface() {
        return "Status: " + userConfigurationClassWithInterface.getStatus()
                + " Residence: " + userConfigurationClassWithInterface.getResidence()
                + " Minimum allowed posts: " + userConfigurationClassWithInterface.getPostsMin()
                + " Maximum allowed posts: " + userConfigurationClassWithInterface.getPostsMax();
    }
}
