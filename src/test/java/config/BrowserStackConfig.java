package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties",
        "classpath:samsungS22.properties"
})


public interface BrowserStackConfig extends Config {

    @Key("browserstackApp")
    String app();

    @Key("browserstackDevice")
    String device();

    @Key("browserstackOsVersion")
    String version();

    @Key("browserstackProject")
    String project();

    @Key("browserstackBuild")
    String build();

    @Key("browserstackName")
    String name();

    @Key("browserstackUrl")
    String url();


}