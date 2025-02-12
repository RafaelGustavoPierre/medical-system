package com.hospital.medicalsystem.core.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
@Component
@ConfigurationProperties("medicalsystem.email")
public class EmailProperties {

//    @NotNull
    private String sender;

}
