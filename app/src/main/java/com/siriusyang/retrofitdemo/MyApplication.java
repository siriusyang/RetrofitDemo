package com.siriusyang.retrofitdemo;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;

import retrofit2.Retrofit;

/**
 * Created by jack on 2016/5/26.
 */
public class MyApplication extends Application {
    public static Retrofit retrofit;
    String sToken = "";
    private PatchManager mPatchManager;
    private static final String TAG = "euler";

    private static final String APATCH_PATH = "/out.apatch";
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
        mPatchManager = new PatchManager(this);
        mPatchManager.init("aaa");//current version

        Log.d(TAG, "inited.");

        // load patch
        mPatchManager.loadPatch();
        Log.d(TAG, "apatch loaded.");

        // add patch at runtime
        try {
            // .apatch file path
            String patchFileString = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + APATCH_PATH;
            File file=new File(patchFileString);
            if(file.exists()) {
                mPatchManager.addPatch(patchFileString);
                Log.d(TAG, "apatch:" + patchFileString + " added.");
                file.delete();
            }else{
                Log.d(TAG, "apatch:"+ " 文件不存在，不需要加载.");
            }

        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }
}
