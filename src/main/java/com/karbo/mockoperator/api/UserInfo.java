package com.karbo.mockoperator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    @NotBlank
    private String sessionId;

    @NotBlank
    private String userId;


    public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }
}
