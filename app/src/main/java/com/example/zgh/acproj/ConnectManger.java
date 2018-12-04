package com.example.zgh.acproj;

import com.example.zgh.acproj.UI.User;

import java.sql.*;

public class ConnectManger {
    private static ConnectManger connectManger;
    private Connection SQLConnect;
    private PreparedStatement LogIn;

    public ConnectManger() throws SQLException {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SQLConnect = DriverManager.getConnection("" +
                "jdbc:sqlserver://tests.database.chinacloudapi.cn:1433;" +
                "database=TestDataBase;" +
                "user=zghver@tests;" +
                "password=ZGH!18099462097!;" +
                "encrypt=true;" +
                "trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.chinacloudapi.cn;" +
                "loginTimeout=30;"+
                "usSSL=rue"
        );
           // LogIn = SQLConnect.prepareStatement("select passworld from login where userID=?;");
    }

    public static void setConnectManger(ConnectManger manger) {
        connectManger = manger;
    }

    public static ConnectManger getConnectManger() {
        return connectManger;
    }

    public User getUser(String userID) throws SQLException, NoSuchUserException {
        //ogIn.setString(1, "'" + userID + "'");
        Statement statement = SQLConnect.createStatement();
        ResultSet result = statement.executeQuery("select * from login where userid='"+userID+"'");
        if (!result.next())
            throw new NoSuchUserException();
        String passworld = result.getString(2);
        result.close();
        return new User(userID, passworld, null);
    }
}
