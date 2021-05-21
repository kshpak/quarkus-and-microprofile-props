package breakfast.pub.io.config.interfaces;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "user")
public interface UserConfigurationInterface extends IUserBiography{

    @ConfigProperty(name = "status")
    String status();

    Post posts();

    interface Post {
        @ConfigProperty(name = "min")
        String min();
        @ConfigProperty(name = "max")
        String max();
    }
}
