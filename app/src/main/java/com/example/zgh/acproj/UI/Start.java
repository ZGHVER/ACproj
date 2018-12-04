package com.example.zgh.acproj.UI;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.zgh.acproj.ConnectManger;
import com.example.zgh.acproj.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.net.MalformedURLException;
import java.sql.SQLException;

public class Start extends AppCompatActivity {
    private MobileServiceClient mClient;
    private Bac bac= new Bac();
    private class Bac extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            ConnectManger a = null;
            try {
                a = new ConnectManger();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectManger.setConnectManger(a);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(Start.this,LoginActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        bac.execute();
        try {
            mClient = new MobileServiceClient(
                    "https://nnn.chinacloudsites.cn",
                    this
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
