package com.example.satvik.orchestrator.service;

import com.example.satvik.orchestrator.modal.NoSqlTableRequest;

public interface MessagePublisherService {

    void publishOdsEvent(NoSqlTableRequest noSqlTableRequest, String topicName);
}
