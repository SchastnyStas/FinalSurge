package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:config/config.properties"
})
public interface EnvConfig extends Config {
    @Key("email")
    String email();

    @Key("password")
    String password();
}