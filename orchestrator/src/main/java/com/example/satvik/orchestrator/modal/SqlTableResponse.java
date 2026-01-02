package com.example.satvik.orchestrator.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class SqlTableResponse {

    private String name;
    private Integer rollNo;
    private BigDecimal salary;
    private Boolean executed;
}
