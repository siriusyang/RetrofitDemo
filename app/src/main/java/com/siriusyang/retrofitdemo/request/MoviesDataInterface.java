package com.siriusyang.retrofitdemo.request;


import com.siriusyang.retrofitdemo.modle.MovieEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jack on 2016/6/16.
 */
public interface MoviesDataInterface {
    //    https://api.douban.com/v2/movie/top250?start=0&count=10
    @GET("top250")
    Observable<MovieEntity> getTop250(@Query("start") int start, @Query("count") int count);
}
