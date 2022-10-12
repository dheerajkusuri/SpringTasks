package com.jwt.jwtAuthentication.model;

public class TokenValidation {
    String sessionExpired;
    String validToken;
    String invalidToken;

    public TokenValidation() {
    }

    public TokenValidation(String sessionExpired, String validToken, String invalidToken) {
        this.sessionExpired = sessionExpired;
        this.validToken = validToken;
        this.invalidToken = invalidToken;
    }

    public String getSessionExpired() {
        return sessionExpired;
    }

    public void setSessionExpired(String sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public String getValidToken() {
        return validToken;
    }

    public void setValidToken(String validToken) {
        this.validToken = validToken;
    }

    public String getInvalidToken() {
        return invalidToken;
    }

    public void setInvalidToken(String invalidToken) {
        this.invalidToken = invalidToken;
    }

    @Override
    public String toString() {
        return "TokenValidation{" +
                "sessionExpired='" + sessionExpired + '\'' +
                ", validToken='" + validToken + '\'' +
                ", invalidToken='" + invalidToken + '\'' +
                '}';
    }
}
