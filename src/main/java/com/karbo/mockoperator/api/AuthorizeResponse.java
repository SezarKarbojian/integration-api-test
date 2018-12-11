package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorizeResponse extends PaymentResponse{

    private int merchantTxId;
    private UUID authCode;

    public AuthorizeResponse(int merchantTxId, UUID authCode) {
        this.merchantTxId = merchantTxId;
        this.authCode = authCode;
    }


    public AuthorizeResponse() {
    }


    public int getMerchantTxId() {
        return merchantTxId;
    }


    public void setMerchantTxId(int merchantTxId) {
        this.merchantTxId = merchantTxId;
    }


    public AuthorizeResponse merchantTxId(int merchantTxId) {
        this.merchantTxId = merchantTxId;
        return this;
    }


    public UUID getAuthCode() {
        return authCode;
    }


    public void setAuthCode(UUID authCode) {
        this.authCode = authCode;
    }


    public AuthorizeResponse authCode(UUID authCode) {
        this.authCode = authCode;
        return this;
    }


    @Override
    public AuthorizeResponse userId(String userId) {
        super.setUserId(userId);
        return this;
    }


    @Override
    public AuthorizeResponse success(boolean success) {
        super.setSuccess(success);
        return this;
    }


    @Override
    public AuthorizeResponse errCode(String errCode) {
        super.setErrCode(errCode);
        return this;
    }


    @Override
    public AuthorizeResponse errMsg(String errMsg) {
        super.setErrMsg(errMsg);
        return this;
    }
}
