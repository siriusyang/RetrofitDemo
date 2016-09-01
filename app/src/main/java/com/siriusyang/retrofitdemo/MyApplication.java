package com.siriusyang.retrofitdemo;

import android.app.Application;

import com.alipay.euler.andfix.patch.PatchManager;
import com.siriusyang.retrofitdemo.utils.AppUtils;

import retrofit2.Retrofit;

/**
 * Created by jack on 2016/5/26.
 */
public class MyApplication extends Application {
    public static Retrofit retrofit;
    String sToken = "";
    private PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initAndFix();
        addPatch();
//        Interceptor mTokenInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Request originalRequest = chain.request();
//                if (sToken == null /*|| alreadyHasAuthorizationHeader(originalRequest)*/) {
//                    return chain.proceed(originalRequest);
//                }
//                Request authorised = originalRequest.newBuilder()
//                        .header("Authorization", sToken)
//                        .build();
//                return chain.proceed(authorised);
//            }
//        };
//        Authenticator mAuthenticator = new Authenticator() {
//            @Override
//            public Request authenticate(Route route, Response response)
//                    throws IOException {
//
//                return response.request().newBuilder()
//                        .addHeader("Authorization", sToken)
//                        .build();
//            }
//        };
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//               /* .authenticator(mAuthenticator)
//                .addNetworkInterceptor(mTokenInterceptor)*/
//                .retryOnConnectionFailure(true)
//                .connectTimeout(15, TimeUnit.SECONDS)
//                .build();
//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .client(client)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

    }

    private void addPatch() {
//        patchManager.addPatch(path);//path of the patch file that was downloaded
    }

    private void initAndFix() {
        patchManager = new PatchManager(this);
        patchManager.init(AppUtils.getAppInfo(this).getVersionName());//current version
    }
}
