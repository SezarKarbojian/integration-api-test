package com.karbo.mockoperator.service;

import com.karbo.mockoperator.api.AuthorizeInfo;
import com.karbo.mockoperator.api.AuthorizeResponse;
import com.karbo.mockoperator.api.TransferInfo;
import com.karbo.mockoperator.api.TransferResponse;
import com.karbo.mockoperator.api.User;

import java.util.List;


public interface PaymentService {

    User getUser(String userId);


    AuthorizeResponse authorize(AuthorizeInfo userId);


    TransferResponse transfer(TransferInfo transferInfo);


    List<TransferInfo> getAllTransactions();
}
