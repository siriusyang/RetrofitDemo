package com.siriusyang.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siriusyang.retrofitdemo.modle.Repo;
import com.siriusyang.retrofitdemo.myinterface.GitHubService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //    System.loadLibrary("MyJni");//导入生成的链接库文件
    public native String getStringFromNative();//本地方法

    public native String getString_From_c();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitHubService gitHubService = MyApplication.retrofit.create(GitHubService.class);
        Call<List<Repo>> call = gitHubService.listRepos("siriusyang");
        try {
            Response<List<Repo>> list = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
