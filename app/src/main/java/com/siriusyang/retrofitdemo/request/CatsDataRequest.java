package com.siriusyang.retrofitdemo.request;

import com.siriusyang.retrofitdemo.BaseApi.HttpMethods;
import com.siriusyang.retrofitdemo.BaseApi.HttpResultFunc;
import com.siriusyang.retrofitdemo.modle.NewsFlag;
import com.siriusyang.retrofitdemo.modle.NewsFlagList;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jack on 2016/8/31.
 */
public class CatsDataRequest {

    public static void getCats(Subscriber<List<NewsFlag>> subscriber) {
        CatsDataInterface iGetCats = HttpMethods.getInstance().retrofit.create(CatsDataInterface.class);
        iGetCats.getCats()
                .map(new HttpResultFunc<NewsFlagList>()).map(new Func1<NewsFlagList, List<NewsFlag>>() {
            @Override public List<NewsFlag> call(NewsFlagList s) {
                return s.getList();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
}
