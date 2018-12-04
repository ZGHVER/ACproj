package com.example.zgh.acproj.UI;

import java.sql.Blob;

public class User {
    private String userID;
    private String userName;
    private String PassWorld;
    private Blob userLog;

    public User(String userID, String passWorld, Blob userLog) {
        this.userID = userID;
        PassWorld = passWorld;
        this.userLog = userLog;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassWorld() {
        return PassWorld;
    }

    public Blob getUserLog() {
        return userLog;
    }
}
