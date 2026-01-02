package com.example.satvik.orchestrator.service;

import com.example.satvik.orchestrator.modal.SqlTableRequest;
import com.example.satvik.orchestrator.modal.SqlTableResponse;
import com.example.satvik.orchestrator.modal.enums.SqlOperation;

public interface SqlService {

    SqlTableResponse operationInSqlDatabase(SqlTableRequest sqlTableRequest, SqlOperation sqlOperation);

    SqlTableResponse getRecord(Integer rollNo);
}
