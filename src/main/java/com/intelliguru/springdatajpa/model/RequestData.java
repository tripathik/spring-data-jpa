package com.intelliguru.springdatajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestData implements Serializable {
    @NotBlank(message = "userName is required.")
    private String userName;
    @NotBlank(message = "userEmail is required.")
    private String userEmail;
    @NotBlank(message = "entity is required.")
    private String entity;
    @NotBlank(message = "city is required.")
    private String city;
    @NotBlank(message = "zipCode is required.")
    private String zipCode;
    @NotBlank(message = "state is required.")
    private String state;
    @NotBlank(message = "country is required.")
    private String country;
    @NotBlank(message = "department is required.")
    private String department;
    @NotBlank(message = "locale is required.")
    private String locale;
    @NotBlank(message = "itemCount is required.")
    private int itemCount;
    @NotBlank(message = "timestamp is required.")
    private Long timestamp;
    @NotBlank(message = "requestEntity is required.")
    private RequestEntity requestEntity;
    @NotBlank(message = "requestStatus is required.")
    private RequestStatus requestStatus;
}
