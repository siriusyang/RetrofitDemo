package com.siriusyang.retrofitdemo.myinterface;



import com.siriusyang.retrofitdemo.Api.HttpResult;
import com.siriusyang.retrofitdemo.modle.Subject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jack on 2016/6/16.
 */
public interface Movies {
    //    https://api.douban.com/v2/movie/top250?start=0&count=10
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTop250(@Query("start") int start, @Query("count") int count);
}
