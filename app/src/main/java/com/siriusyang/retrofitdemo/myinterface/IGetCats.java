package com.siriusyang.retrofitdemo.myinterface;

import com.siriusyang.retrofitdemo.Api.HttpResult;
import com.siriusyang.retrofitdemo.modle.NewsFlag;
import com.siriusyang.retrofitdemo.modle.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jack on 2016/7/1.
 */
public interface IGetCats {
    @GET("news/get_cats")
    Observable<HttpResult<List<NewsFlag>>> getCats();
}
