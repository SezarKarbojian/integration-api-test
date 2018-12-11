package com.karbo.mockoperator.service.impl;

import com.karbo.mockoperator.api.AuthorizeInfo;
import com.karbo.mockoperator.api.AuthorizeResponse;
import com.karbo.mockoperator.api.TransferInfo;
import com.karbo.mockoperator.api.TransferResponse;
import com.karbo.mockoperator.api.User;
import com.karbo.mockoperator.repository.TransactionRepository;
import com.karbo.mockoperator.repository.UserRepository;
import com.karbo.mockoperator.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService {

    private final UserRepository userRepo;
    private final TransactionRepository transactionRepo;


    @Autowired
    public PaymentServiceImpl(UserRepository userRepo, TransactionRepository transactionRepo) {
        this.userRepo = userRepo;
        this.transactionRepo = transactionRepo;
    }


    @Override
    public User getUser(String userId) {
        User user = userRepo.findByUserId(userId);
        if (user != null) {
            return user.success(true);
        } else {
            return new User().userId(userId).success(false).errCode("1234").errMsg("Verification failed: User not found");
        }
    }


    @Override
    public AuthorizeResponse authorize(AuthorizeInfo authorizeInfo) {
        //verify that the user is allowed to process
        User user = userRepo.findByUserId(authorizeInfo.getUserId());
        if (user == null) {
            return new AuthorizeResponse()
                    .userId(authorizeInfo.getUserId())
                    .success(false)
                    .errCode("1234")
                    .errMsg("Authorize failed: User not found");
        }

        //check if transaction is debit and that the user account will not be over debited
        if (authorizeInfo.getTxAmount().compareTo(BigDecimal.ZERO) < 0) {
            if (userAccountOverDebited(authorizeInfo, user)) {
                return new AuthorizeResponse()
                        .userId(authorizeInfo.getUserId())
                        .success(false).errCode("2233")
                        .errMsg("Authorize failed: User account over debited");
            }
        //reserve amount for future debit
        return reserveAmount(authorizeInfo, user);
        } else {
            return new AuthorizeResponse().success(true).merchantTxId(1111).authCode(UUID.randomUUID());
        }

    }


    @Override
    public TransferResponse transfer(TransferInfo transferInfo) {
        User user = userRepo.findByUserId(transferInfo.getUserId());
        if (user == null) {
            return new TransferResponse()
                    .userId(transferInfo.getUserId())
                    .success(false)
                    .errCode("1234")
                    .errMsg("Transfer failed: User not found");
        }

        TransferResponse response;
        //debit or credit user account
        if (transferInfo.getTxPspAmount().compareTo(BigDecimal.ZERO) < 0) {
            response = debitAccount(transferInfo, user);
        } else if (transferInfo.getTxPspAmount().compareTo(BigDecimal.ZERO) > 0) {
            response = creditAccount(transferInfo, user);
        } else {
            response = new TransferResponse().success(true).merchantTxId(1111).txId("25A0324");
        }

        //update transaction repository
        transactionRepo.insert(transferInfo);

        return response;
    }


    @Override
    public List<TransferInfo> getAllTransactions() {
        return transactionRepo.findAll();
    }


    private boolean userAccountOverDebited(AuthorizeInfo authorizeInfo, User user) {
        //balance - (reservedAmount + txAmount) < 0
        BigDecimal amountToSubtract = user.getReservedAmount().add(authorizeInfo.getTxAmount().abs());
        return (user.getBalance().subtract(amountToSubtract).compareTo(BigDecimal.ZERO) < 0);
    }


    private AuthorizeResponse reserveAmount(AuthorizeInfo authorizeInfo, User user) {
        user.setReservedAmount(user.getReservedAmount().add(authorizeInfo.getTxAmount().abs()));
        AuthorizeResponse authResponse = new AuthorizeResponse().userId(user.getUserId());
        try {
            userRepo.save(user);
            authResponse.success(true).merchantTxId(1111).authCode(UUID.randomUUID());
        }
        catch (Exception e) {
            e.printStackTrace();
            authResponse.success(false).errCode("3344").errMsg("Authorize failed: could not reserve amount");
        }
        finally {
            return authResponse;
        }

    }


    private TransferResponse debitAccount(TransferInfo transferInfo, User user) {
        user.setBalance(user.getBalance().subtract(transferInfo.getTxPspAmount().abs()));
        user.setReservedAmount(user.getReservedAmount().subtract(transferInfo.getTxPspAmount().abs()));
        if (user.getReservedAmount().compareTo(BigDecimal.ZERO) < 0) {
            user.setReservedAmount(BigDecimal.ZERO);
        }
        TransferResponse transferResponse = new TransferResponse().userId(user.getUserId());
        return saveTransaction(user, transferResponse);
    }


    private TransferResponse creditAccount(TransferInfo transferInfo, User user) {
        user.setBalance(user.getBalance().add(transferInfo.getTxPspAmount()));
        TransferResponse transferResponse = new TransferResponse().userId(user.getUserId());
        return saveTransaction(user, transferResponse);
    }


    private TransferResponse saveTransaction(User user, TransferResponse transferResponse) {
        try {
            userRepo.save(user);
            transferResponse.success(true).merchantTxId(1111).txId("25A0324");
        }
        catch (Exception e) {
            e.printStackTrace();
            transferResponse.success(false).errCode("4455").errMsg("Transfer failed:: could not transfer amount");
        }
        finally {
            return transferResponse;
        }
    }
}
