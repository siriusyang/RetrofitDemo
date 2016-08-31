package com.siriusyang.retrofitdemo.request;

import com.siriusyang.retrofitdemo.BaseApi.DouBanHttpMethods;
import com.siriusyang.retrofitdemo.modle.MovieEntity;
import com.siriusyang.retrofitdemo.modle.Subject;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jack on 2016/8/31.
 */
public class MoviesDataRequest {

    public static void getTop250(int start, int count, Subscriber<List<Subject>> subscriber) {
        MoviesDataInterface moviesDataInterface = DouBanHttpMethods.getInstance().retrofit.create(MoviesDataInterface.class);
        moviesDataInterface.getTop250(start, count).map(new Func1<MovieEntity, List<Subject>>() {
            @Override public List<Subject> call(MovieEntity s) {
                return s.getSubjects();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
}
