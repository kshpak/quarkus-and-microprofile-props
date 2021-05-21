package breakfast.pub.io.config;


import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "user")
public class UserConfiguration {
    public String status;  //wired with user.status property
    public UserPosts posts;

    public static class UserPosts {
        public String min;   //wired with user.posts.min property
        public String max;   //wired with user.posts.max property
    }
}
