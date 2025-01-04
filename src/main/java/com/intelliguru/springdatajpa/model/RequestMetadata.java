package com.intelliguru.springdatajpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMetadata implements Serializable {
    @NotBlank(message = "CorrelationId is required.")
    @JsonProperty("correlation_id")
    private String correlationId;
    @NotBlank(message = "MessageId is required.")
    @JsonProperty("message_id")
    private String messageId;
    @NotNull(message = "Timestamp is required")
    private Long timeStamp;

}
