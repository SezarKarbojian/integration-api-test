package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizeInfo {

    @NotBlank
    private String userId;
    @NotNull
    private BigDecimal txAmount;
    @NotBlank
    private String txAmountCy;
    @NotBlank
    private String txId;
    @NotNull
    private int txTypeId;
    @NotBlank
    private String txName;
    @NotBlank
    private String provider;


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public BigDecimal getTxAmount() {
        return txAmount;
    }


    public void setTxAmount(BigDecimal txAmount) {
        this.txAmount = txAmount;
    }


    public String getTxAmountCy() {
        return txAmountCy;
    }


    public void setTxAmountCy(String txAmountCy) {
        this.txAmountCy = txAmountCy;
    }


    public String getTxId() {
        return txId;
    }


    public void setTxId(String txId) {
        this.txId = txId;
    }


    public int getTxTypeId() {
        return txTypeId;
    }


    public void setTxTypeId(int txTypeId) {
        this.txTypeId = txTypeId;
    }


    public String getTxName() {
        return txName;
    }


    public void setTxName(String txName) {
        this.txName = txName;
    }


    public String getProvider() {
        return provider;
    }


    public void setProvider(String provider) {
        this.provider = provider;
    }
}
