package com.example.satvik.orchestrator.client;

import com.example.satvik.orchestrator.modal.SqlTableRequest;
import com.example.satvik.orchestrator.modal.SqlTableResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@AllArgsConstructor
public class SqlClient {

    private final RestClient restClient;

    public SqlTableResponse insertInSqlDB(SqlTableRequest sqlTableRequest) {
        return restClient.post()
                .uri("http://localhost:8081/sql/insert")
                .body(sqlTableRequest)
                .retrieve()
                .body(SqlTableResponse.class);
    }

    public SqlTableResponse updateInSqlDB(SqlTableRequest sqlTableRequest) {
        return restClient.put()
                .uri("http://localhost:8081/sql/update")
                .body(sqlTableRequest)
                .retrieve()
                .body(SqlTableResponse.class);
    }

    public SqlTableResponse deleteInSqlDB(SqlTableRequest sqlTableRequest) {
        return restClient.delete()
                .uri("http://localhost:8081/sql/delete/{rollNo}", sqlTableRequest.getRollNo())
                .retrieve()
                .body(SqlTableResponse.class);
    }

    public SqlTableResponse getRecord(Integer rollNo) {
        return restClient.get()
                .uri("http://localhost:8082/sql/get/{rollNo}", rollNo)
                .retrieve()
                .body(SqlTableResponse.class);
    }
}
