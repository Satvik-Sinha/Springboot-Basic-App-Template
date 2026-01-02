package com.example.satvik.orchestrator.service;

import com.example.satvik.orchestrator.modal.NoSqlTableRequest;

public interface NoSqlService {

    public void executeNoSqlOperation(NoSqlTableRequest noSqlTableRequest);
}
