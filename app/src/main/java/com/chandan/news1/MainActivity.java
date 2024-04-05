package com.chandan.news1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.chandan.news1.adapter.RecyclerAdapter;
import com.chandan.news1.apiclient.API;
import com.chandan.news1.apiclient.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getRetrofit();
        API api = retrofit.create(API.class);

        Call<News> newsCall = api.getData("in","4979e7f46b174ceebbf1e2b9c55b4855");

        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.e("response",response.toString());
                if(response.isSuccessful()){
                    RecyclerView recyclerView = findViewById(R.id.vertical_headline_recycler);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),response.body()));
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("failure",t.toString());
            }
        });

    }
}