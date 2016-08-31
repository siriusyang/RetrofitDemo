package com.siriusyang.retrofitdemo.request;

import com.siriusyang.retrofitdemo.BaseApi.HttpResult;
import com.siriusyang.retrofitdemo.modle.NewsFlagList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jack on 2016/7/1.
 */
public interface CatsDataInterface {
    @GET("news/get_cats")
    Observable<HttpResult<NewsFlagList>> getCats();
}
