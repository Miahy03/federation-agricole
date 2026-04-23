package org.openapitools.client;

import java.util.HashSet;
import jakarta.annotation.Generated;

@Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2026-04-22T10:10:31.626359200+03:00[Africa/Nairobi]",
        comments = "Generator version: 7.7.0"
)
public class ServerVariable {

    public String description;
    public String defaultValue;
    public HashSet<String> enumValues = null;

    public ServerVariable(String description, String defaultValue, HashSet<String> enumValues) {
        this.description = description;
        this.defaultValue = defaultValue;
        this.enumValues = enumValues;
    }
}