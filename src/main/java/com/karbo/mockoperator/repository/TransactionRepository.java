package com.karbo.mockoperator.repository;

import com.karbo.mockoperator.api.TransferInfo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionRepository extends MongoRepository<TransferInfo, String> {
}
