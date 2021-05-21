package breakfast.pub.io.config.interfaces;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public interface IUserBiography {

    @ConfigProperty(name = "residence")
    String residence();
}
