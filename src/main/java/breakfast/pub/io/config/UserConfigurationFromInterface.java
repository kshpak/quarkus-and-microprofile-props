package breakfast.pub.io.config;

import javax.inject.Inject;
import javax.inject.Singleton;

import breakfast.pub.io.config.interfaces.UserConfigurationInterface;

@Singleton
public class UserConfigurationFromInterface {

    @Inject
    UserConfigurationInterface userConfigurationInterface;

    public String getResidence() {
        return userConfigurationInterface.residence();
    }

    public String getStatus() {
        return userConfigurationInterface.status();
    }

    public String getPostsMin() {
        return userConfigurationInterface.posts().min();
    }

    public String getPostsMax() {
        return userConfigurationInterface.posts().max();
    }

}
