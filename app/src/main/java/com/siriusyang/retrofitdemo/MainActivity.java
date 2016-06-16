package com.siriusyang.retrofitdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.siriusyang.retrofitdemo.Api.HttpMethods;
import com.siriusyang.retrofitdemo.Api.HttpResult;
import com.siriusyang.retrofitdemo.modle.Repo;
import com.siriusyang.retrofitdemo.modle.Subject;
import com.siriusyang.retrofitdemo.myinterface.GitHubService;
import com.siriusyang.retrofitdemo.myinterface.MovieEntity;
import com.siriusyang.retrofitdemo.myinterface.Movies;
import com.siriusyang.retrofitdemo.navtivemeath.JniUtils;
import com.siriusyang.retrofitdemo.service.SDCardListenSer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SDCardListenSer.class);
        startService(intent);
        Log.i("dfdfd", JniUtils.getStringFormC());
        Log.i("dfdfd", "" + JniUtils.getAddNumberFormC(1, 2));
//        GitHubService gitHubService = MyApplication.retrofit.create(GitHubService.class);
//        Call<List<Repo>> call = gitHubService.listRepos("siriusyang");
//        try {
//            Response<List<Repo>> list = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();

//        }

        Subscriber<List<Subject>> subscriber = new Subscriber<List<Subject>>() {
            @Override public void onCompleted() {

            }

            @Override public void onError(Throwable e) {

            }

            @Override public void onNext(List<Subject> movieEntity) {

            }
        };
        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);

    }

}
