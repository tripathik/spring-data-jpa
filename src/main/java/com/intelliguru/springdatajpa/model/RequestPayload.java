package com.intelliguru.springdatajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Valid
public class RequestPayload {
    @Valid
    @JsonProperty("data")
    @NotNull(message = "Data value is required")
    private RequestData data;

    @Valid
    @JsonProperty("metadata")
    @NotNull(message = "Metadata filed is required")
    private RequestMetadata metadata;
}
