package com.example.satvik.orchestrator.controller;

import com.example.satvik.orchestrator.modal.NoSqlTableRequest;
import com.example.satvik.orchestrator.modal.SqlTableRequest;
import com.example.satvik.orchestrator.modal.SqlTableResponse;
import com.example.satvik.orchestrator.modal.enums.SqlOperation;
import com.example.satvik.orchestrator.service.NoSqlService;
import com.example.satvik.orchestrator.service.SqlService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.satvik.orchestrator.constant.Constants.*;

@RestController
@RequestMapping(BASE_URL)
@AllArgsConstructor
public class TestApiController {

    private final SqlService sqlService;
    private final NoSqlService noSqlService;

    @PostMapping(value = POST_SQL_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SqlTableResponse> operationInSqlDatabase(@RequestBody SqlTableRequest sqlTableRequest,
                                                                   @PathVariable SqlOperation sqlOperation) {
        return ResponseEntity.ok().body(sqlService.operationInSqlDatabase(sqlTableRequest, sqlOperation));
    }

    @GetMapping(value = GET_SQL_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SqlTableResponse> operationFromSqlDatabase(@PathVariable Integer rollNo) {
        return ResponseEntity.ok().body(sqlService.getRecord(rollNo));
    }

    @PostMapping(value = POST_NOSQL_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public void operationInSqlDatabase(@RequestBody NoSqlTableRequest noSqlTableRequest) {
        noSqlService.executeNoSqlOperation(noSqlTableRequest);
    }
}
