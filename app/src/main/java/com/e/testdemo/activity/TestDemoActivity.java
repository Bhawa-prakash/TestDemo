package com.e.testdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.e.testdemo.R;
import com.e.testdemo.adapter.TestAdapter;
import com.e.testdemo.models.Post;
import com.e.testdemo.models.TestResponse;
import com.e.testdemo.retrofit.ApiClient;
import com.e.testdemo.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_demo);



        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<TestResponse> call = apiService.getTest();
        call.enqueue(new Callback<TestResponse>() {
            @Override
            public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {

                TestResponse testResponse= response.body();
                if (testResponse!=null){
                    List<Post> postListt = testResponse.getPosts();
                    recyclerView.setAdapter(new TestAdapter(postListt, R.layout.recycler_item, getApplicationContext()));
                }

            }

            @Override
            public void onFailure(Call<TestResponse> call, Throwable t) {
                Toast.makeText(TestDemoActivity.this, "failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

