package com.example.satvik.orchestrator.service.impl;

import com.example.satvik.orchestrator.client.SqlClient;
import com.example.satvik.orchestrator.modal.SqlTableRequest;
import com.example.satvik.orchestrator.modal.SqlTableResponse;
import com.example.satvik.orchestrator.modal.enums.SqlOperation;
import com.example.satvik.orchestrator.service.SqlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SqlServiceImpl implements SqlService {

    private final SqlClient sqlClient;

    public SqlTableResponse operationInSqlDatabase(SqlTableRequest sqlTableRequest, SqlOperation sqlOperation) {

        if(SqlOperation.INSERT.equals(sqlOperation)) {
            return sqlClient.insertInSqlDB(sqlTableRequest);
        } else if(SqlOperation.UPDATE.equals(sqlOperation)) {
            return sqlClient.updateInSqlDB(sqlTableRequest);
        } else if(SqlOperation.DELETE.equals(sqlOperation)) {
            return sqlClient.deleteInSqlDB(sqlTableRequest);
        } else {
            System.out.println("Wrong Input");
            return new SqlTableResponse();
        }
    }

    public SqlTableResponse getRecord(Integer rollNo) {
        return sqlClient.getRecord(rollNo);
    }
}
