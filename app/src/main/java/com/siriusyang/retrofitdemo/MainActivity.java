package com.siriusyang.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.siriusyang.retrofitdemo.modle.Repo;
import com.siriusyang.retrofitdemo.myinterface.GitHubService;
import com.siriusyang.retrofitdemo.navtivemeath.JniUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("dfdfd", JniUtils.getStringFormC());
//        GitHubService gitHubService = MyApplication.retrofit.create(GitHubService.class);
//        Call<List<Repo>> call = gitHubService.listRepos("siriusyang");
//        try {
//            Response<List<Repo>> list = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
