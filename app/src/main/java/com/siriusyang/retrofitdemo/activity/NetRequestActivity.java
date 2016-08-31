package com.siriusyang.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.modle.NewsFlag;
import com.siriusyang.retrofitdemo.modle.Subject;
import com.siriusyang.retrofitdemo.request.CatsDataRequest;
import com.siriusyang.retrofitdemo.request.MoviesDataRequest;
import com.siriusyang.retrofitdemo.weigets.RainbowTextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class NetRequestActivity extends AppCompatActivity {

    @Bind(R.id.tvResult) RainbowTextView tvResult;
    @Bind(R.id.tvResultM) RainbowTextView tvResultM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_request_activity);
        ButterKnife.bind(this);


        Subscriber<List<NewsFlag>> subscriber = new Subscriber<List<NewsFlag>>() {
            @Override public void onCompleted() {
                Log.i("newsFlag", "Completed");
            }

            @Override public void onError(Throwable e) {
                Log.i("newsFlag", "error", e);
            }

            @Override public void onNext(List<NewsFlag> newsFlag) {
                Log.i("newsFlag", newsFlag.toString());
                tvResult.setText(newsFlag.toString());
            }
        };
        Subscriber<List<Subject>> subscriber2 = new Subscriber<List<Subject>>() {
            @Override public void onCompleted() {
                Log.i("subjectList", "Completed");
            }

            @Override public void onError(Throwable e) {
                Log.i("subjectList", "error", e);
            }

            @Override public void onNext(List<Subject> subjectList) {
                Log.i("subjectList", subjectList.toString());
                tvResultM.setText(subjectList.toString());
            }
        };
        CatsDataRequest.getCats(subscriber);
        MoviesDataRequest.getTop250(0, 2, subscriber2);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
