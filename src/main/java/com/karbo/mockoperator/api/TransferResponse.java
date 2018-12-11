package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferResponse extends PaymentResponse{

    private String txId;
    private int merchantTxId;


    public TransferResponse() {
    }


    public String getTxId() {
        return txId;
    }


    public void setTxId(String txId) {
        this.txId = txId;
    }


    public TransferResponse txId(String txId) {
        this.txId = txId;
        return this;
    }


    public int getMerchantTxId() {
        return merchantTxId;
    }


    public void setMerchantTxId(int merchantTxId) {
        this.merchantTxId = merchantTxId;
    }


    public TransferResponse merchantTxId(int merchantTxId) {
        this.merchantTxId = merchantTxId;
        return this;
    }


    @Override
    public TransferResponse userId(String userId) {
        super.setUserId(userId);
        return this;
    }


    @Override
    public TransferResponse success(boolean success) {
        super.setSuccess(success);
        return this;
    }


    @Override
    public TransferResponse errCode(String errCode) {
        super.setErrCode(errCode);
        return this;
    }


    @Override
    public TransferResponse errMsg(String errMsg) {
        super.setErrMsg(errMsg);
        return this;
    }
}
