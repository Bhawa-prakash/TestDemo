package com.e.testdemo.retrofit;


import com.e.testdemo.models.Post;
import com.e.testdemo.models.TestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("https://my-json-server.typicode.com/typicode/demo/db")
    Call<TestResponse>getTest();


}
