package com.hospital.medicalsystem.core.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("medicalsystem.utils")
public class UtilsProperties {

    private String profileImage;

}
