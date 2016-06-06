package com.siriusyang.retrofitdemo.myinterface;

import com.siriusyang.retrofitdemo.modle.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jack on 2016/5/26.
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
