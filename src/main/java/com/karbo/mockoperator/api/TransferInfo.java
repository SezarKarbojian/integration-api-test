package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "transactions")
public class TransferInfo {

    @NotBlank
    private String userId;
    @NotBlank
    private String txAmount;
    @NotBlank
    private String txAmountCy;
    @NotNull
    private BigDecimal txPspAmount;
    @NotBlank
    private String txPspAmountCy;
    @NotBlank
    private String fee;
    @NotBlank
    private String feeCy;
    @NotBlank
    private String txId;
    @NotNull
    private int txTypeId;
    @NotBlank
    private String txName;
    @NotBlank
    private String provider;
    @NotBlank
    private String txRefId;


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getTxAmount() {
        return txAmount;
    }


    public void setTxAmount(String txAmount) {
        this.txAmount = txAmount;
    }


    public String getTxAmountCy() {
        return txAmountCy;
    }


    public void setTxAmountCy(String txAmountCy) {
        this.txAmountCy = txAmountCy;
    }


    public BigDecimal getTxPspAmount() {
        return txPspAmount;
    }


    public void setTxPspAmount(BigDecimal txPspAmount) {
        this.txPspAmount = txPspAmount;
    }


    public String getTxPspAmountCy() {
        return txPspAmountCy;
    }


    public void setTxPspAmountCy(String txPspAmountCy) {
        this.txPspAmountCy = txPspAmountCy;
    }


    public String getFee() {
        return fee;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }


    public String getFeeCy() {
        return feeCy;
    }


    public void setFeeCy(String feeCy) {
        this.feeCy = feeCy;
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


    public String getTxRefId() {
        return txRefId;
    }


    public void setTxRefId(String txRefId) {
        this.txRefId = txRefId;
    }
}
