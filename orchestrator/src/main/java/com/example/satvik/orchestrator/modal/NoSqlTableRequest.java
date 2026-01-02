package com.example.satvik.orchestrator.modal;

import com.example.satvik.orchestrator.modal.enums.NoSqlOperation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class NoSqlTableRequest {

    private NoSqlOperation noSqlOperation;
    private String name;
    private Integer rollNo;
    private BigDecimal salary;
}
