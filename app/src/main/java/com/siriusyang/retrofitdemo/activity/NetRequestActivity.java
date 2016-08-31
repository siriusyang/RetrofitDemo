package com.siriusyang.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.siriusyang.retrofitdemo.Api.HttpMethods;
import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.modle.NewsFlag;
import com.siriusyang.retrofitdemo.weigets.RainbowTextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class NetRequestActivity extends AppCompatActivity {

    @Bind(R.id.tvResult) RainbowTextView tvResult;
//    private SubscriberOnNextListener getTopMovieOnNext;


    //进行网络请求
    private void getMovie() {
//        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(getTopMovieOnNext, this), 0, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_request_activity);
        ButterKnife.bind(this);

//        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
//            @Override
//            public void onNext(List<Subject> subjects) {
//                tvResult.setText(subjects.toString());
//            }
//        };
//        getMovie();

        Subscriber<List<NewsFlag>> subscriber = new Subscriber<List<NewsFlag>>() {
            @Override public void onCompleted() {
                Log.i("sss", "Completed");
            }

            @Override public void onError(Throwable e) {
                Log.i("sss", "error", e);
            }

            @Override public void onNext(List<NewsFlag> newsFlag) {
                Log.i("sss", newsFlag.toString());
            }
        };
        HttpMethods.getInstance().getCats(subscriber);
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
