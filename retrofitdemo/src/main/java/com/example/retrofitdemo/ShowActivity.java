package com.example.retrofitdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutManager;
import androidx.appcompat.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowActivity extends AppCompatActivity {

    private RecyclerView showRv;
    private Context mContext;
    private Retrofit mRetrofit;
    private Call<Bean> mCall;
    private OkHttpClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mContext = this;

        showRv = findViewById(R.id.rv_show);

        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("Blues", "Retrofit----" + message);
                    }
                });

                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                mClient = new OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build();

                mRetrofit = new Retrofit.Builder()
                        .baseUrl("http://gank.io/api/data/")
                        .client(mClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                Api api = mRetrofit.create(Api.class);

                mCall = api.getCall(10, 1);
                mCall.enqueue(new Callback<Bean>() {
                    @Override
                    public void onResponse(Call<Bean> call, Response<Bean> response) {
                        Log.i("Blues", "onResponse");
                        Log.i("Blues", response.body().toString());

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                                showRv.setLayoutManager(layoutManager);
                                showRv.setAdapter(new ShowAdapter(response.body()));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Bean> call, Throwable t) {
                        Log.i("Blues", "onFailure");
                        t.printStackTrace();
                    }
                });
            }
        }).start();
    }

    class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

        private Bean mBean;

        public ShowAdapter(Bean mBean) {
            this.mBean = mBean;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_show, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
            holder.descTv.setText(mBean.getResults().get(i).getDesc());
            holder.urlTv.setText(mBean.getResults().get(i).getUrl());
        }

        @Override
        public int getItemCount() {
            return mBean.getResults().size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView descTv;
            TextView urlTv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                descTv = itemView.findViewById(R.id.tv_desc);
                urlTv = itemView.findViewById(R.id.tv_url);
            }
        }
    }
}
