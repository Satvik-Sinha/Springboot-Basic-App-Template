package com.example.satvik.orchestrator.service.impl;

import com.example.satvik.orchestrator.modal.NoSqlTableRequest;
import com.example.satvik.orchestrator.service.MessagePublisherService;
import com.example.satvik.orchestrator.service.NoSqlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoSqlServiceImpl implements NoSqlService {

    private final MessagePublisherService messagePublisherService;

    public void executeNoSqlOperation(NoSqlTableRequest noSqlTableRequest) {
        messagePublisherService.publishOdsEvent(noSqlTableRequest, "ods-event");
    }
}
