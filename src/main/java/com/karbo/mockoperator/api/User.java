package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "users")
public class User extends PaymentResponse {

    private String userCat;
    private String kycStatus;
    private String sex;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String dob;
    private String mobile;
    private BigDecimal balance;
    @JsonIgnore
    private BigDecimal reservedAmount;
    private String balanceCy;
    private String locale;


    public User() {
    }


    public String getUserCat() {
        return userCat;
    }


    public void setUserCat(String userCat) {
        this.userCat = userCat;
    }


    public User userCat(String userCat) {
        this.userCat = userCat;
        return this;
    }


    public String getKycStatus() {
        return kycStatus;
    }


    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }


    public User kycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
        return this;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public User sex(String sex) {
        this.sex = sex;
        return this;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public User street(String street) {
        this.street = street;
        return this;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public User city(String city) {
        this.city = city;
        return this;
    }


    public String getZip() {
        return zip;
    }


    public void setZip(String zip) {
        this.zip = zip;
    }


    public User zip(String zip) {
        this.zip = zip;
        return this;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public User country(String country) {
        this.country = country;
        return this;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public User email(String email) {
        this.email = email;
        return this;
    }


    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }


    public User dob(String dob) {
        this.dob = dob;
        return this;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public User mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }


    public BigDecimal getBalance() {
        return this.balance;
    }


    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public User balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }


    public BigDecimal getReservedAmount() {
        if (null == reservedAmount) {
            return BigDecimal.ZERO;
        }
        return reservedAmount;
    }


    public void setReservedAmount(BigDecimal reservedAmount) {
        this.reservedAmount = reservedAmount;
    }


    public User reservedAmount(BigDecimal reservedAmount) {
        this.reservedAmount = reservedAmount;
        return this;
    }


    public String getBalanceCy() {
        return balanceCy;
    }


    public void setBalanceCy(String balanceCy) {
        this.balanceCy = balanceCy;
    }


    public User balanceCy(String balanceCy) {
        this.balanceCy = balanceCy;
        return this;
    }


    public String getLocale() {
        return locale;
    }


    public void setLocale(String locale) {
        this.locale = locale;
    }


    public User locale(String locale) {
        this.locale = locale;
        return this;
    }


    @Override
    public User success(boolean success) {
        super.setSuccess(success);
        return this;
    }


    @Override
    public User userId(String userId) {
        super.setUserId(userId);
        return this;
    }


    @Override
    public User errCode(String errCode) {
        super.setErrCode(errCode);
        return this;
    }


    @Override
    public User errMsg(String errMsg) {
        super.setErrMsg(errMsg);
        return this;
    }

}