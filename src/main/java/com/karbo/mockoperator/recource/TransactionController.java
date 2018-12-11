package com.karbo.mockoperator.recource;

import com.karbo.mockoperator.api.AuthorizeInfo;
import com.karbo.mockoperator.api.PaymentResponse;
import com.karbo.mockoperator.api.TransferInfo;
import com.karbo.mockoperator.api.UserInfo;
import com.karbo.mockoperator.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TransactionController {

    private static final String APIV1 = "/api/v1/paymentiq";

    private final PaymentService paymentService;


    @Autowired
    public TransactionController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping(value = APIV1 + "/verifyuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse verifyUser(@RequestBody @Valid UserInfo userInfo) {
        return paymentService.getUser(userInfo.getUserId());
    }


    @PostMapping(value = APIV1 + "/authorize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse authorize(@RequestBody @Valid AuthorizeInfo authorizeInfo) {
        return paymentService.authorize(authorizeInfo);
    }


    @PostMapping(value = APIV1 + "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse transfer(@RequestBody @Valid TransferInfo transferInfo) {
        return paymentService.transfer(transferInfo);
    }


    @GetMapping(value = APIV1 + "/transaction")
    public List<TransferInfo> getTransaction() {
        return paymentService.getAllTransactions();
    }

}
