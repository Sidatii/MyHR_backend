package com.myhr.myhr.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Configuration
public class Cloudinary {
    public static String cloudName;
    public static String apiKey;
    public static String apiSecret;

    static {
        ResourceBundle rd = ResourceBundle.getBundle("cloudinary");
        cloudName = rd.getString("cloudinary.CLOUDINARY_CLOUD_NAME");
        apiKey = rd.getString("cloudinary.CLOUDINARY_API_KEY");
        apiSecret = rd.getString("cloudinary.CLOUDINARY_API_SECRET");
    }

    @Bean
    public com.cloudinary.Cloudinary cloudinaryConfig() {
        com.cloudinary.Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        cloudinary = new com.cloudinary.Cloudinary(config);
        return cloudinary;
    }
}
