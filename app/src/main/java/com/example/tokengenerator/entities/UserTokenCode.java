package com.example.tokengenerator.entities;

public class UserTokenCode {
    private String tokenCodeNameId;
    private String tokenCode;

    public UserTokenCode() {
    }

    public UserTokenCode(String tokenCodeNameId, String tokenCode) {
        this.tokenCodeNameId = tokenCodeNameId;
        this.tokenCode = tokenCode;
    }

    public String getTokenCodeNameId() {
        return tokenCodeNameId;
    }

    public void setTokenCodeNameId(String tokenCodeNameId) {
        this.tokenCodeNameId = tokenCodeNameId;
    }

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }
}
