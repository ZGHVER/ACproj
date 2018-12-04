package com.example.zgh.acproj;

import java.sql.DriverManager;
import java.sql.SQLException;

public class gcfgcgfh {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DriverManager.getConnection("" +
                "jdbc:sqlserver://tests.database.chinacloudapi.cn:1433;" +
                "database=TestDataBase;" +
                "user=zghver@tests;" +
                "password=ZGH!18099462097!;" +
                 "encrypt=true;" +
                "trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.chinacloudapi.cn;" +
                "loginTimeout=30;"
        );
    }
}
