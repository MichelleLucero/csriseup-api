package com.csriseupapi.csriseupapi.model.Response;

public class LoginResponse {
    private String jwt;


    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
