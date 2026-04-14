package com.hospital.medicalsystem.V2.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Problem {

    private String title;
    private String detail;
    private String userMessage;
    private String type;
    private List<Field> fields;
    private Integer status;

    @Getter
    @Builder
    public static class Field {

        private String name;
        private String userMessage;

    }

}
