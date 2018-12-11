package com.karbo.mockoperator.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


public abstract class PaymentResponse {

    @Id
    private String userId;
    @Transient
    private boolean success;
    private String errCode;
    private String errMsg;


    public PaymentResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    abstract PaymentResponse userId(String userId);

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    abstract PaymentResponse success(boolean success);

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    abstract PaymentResponse errCode(String errCode);

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    abstract PaymentResponse errMsg(String errMsg);

}
