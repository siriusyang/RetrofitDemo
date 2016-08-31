package com.siriusyang.retrofitdemo.Api;

import com.siriusyang.retrofitdemo.modle.NewsFlag;
import com.siriusyang.retrofitdemo.myinterface.IGetCats;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jack on 2016/6/16.
 */
public class HttpMethods {
    /**
     * 域名
     */
    public static final String BASE_URL = "http://client.api.iguxuan.com/v1/";
    /**
     * 读取超时
     */
    public static final int READ_TIME_OUT = 5;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIME_OUT = 5;

    private Retrofit retrofit;

    private HttpMethods() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS).connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public void getCats(Subscriber<List<NewsFlag>> subscriber) {
        IGetCats iGetCats = getInstance().retrofit.create(IGetCats.class);
        iGetCats.getCats()
                .map(new HttpResultFunc<List<NewsFlag>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
        private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getResultCode() != 0) {
                throw new ApiException(httpResult.getResultCode());
            }
            return httpResult.getData();
        }
    }
}
