package com.nntk.restplus;


public abstract class RespBodyHandleRule {
    private String httpBody;
    public abstract void init(String httpBody);
    public abstract int getCode();

    public abstract boolean isBusinessSuccess();


    public abstract String getMessage();

    public abstract String getData();

    public void setHttpBody(String httpBody) {
        this.httpBody = httpBody;
    }

    public String getHttpBody() {
        return httpBody;
    }



}
