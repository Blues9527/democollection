package com.blues.demo1;

import android.content.Context;
import androidx.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private VerticalRecyclerView rv_outside;
    private List<Integer> iList;
    private List<String> sList;
    private Context mContext;
    private String baseUrl = "http://gank.io/api/data/福利/10/";
    private NewsEntity newsEntity = new NewsEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        new Thread(() -> {
            iList = new ArrayList<>();
            sList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                iList.add(i);
            }

            Request request = new Request.Builder()
                    .url(baseUrl + "1")
                    .get()
                    .build();
            Call call = new OkHttpClient().newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i("Blues", "请求失败");
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    newsEntity = gson.fromJson(response.body().string(), NewsEntity.class);
                    for (int i = 0; i < newsEntity.getResults().size(); i++) {
                        sList.add(newsEntity.getResults().get(i).getUrl());
                        Log.i("Blues", newsEntity.getResults().get(i).getUrl());
                    }
                }
            });
        }).start();

        rv_outside = findViewById(R.id.rv_outside);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_outside.setLayoutManager(linearLayoutManager);
        rv_outside.setOnFlingListener(null);
        pagerSnapHelper.attachToRecyclerView(rv_outside);
        rv_outside.setAdapter(new OutsideAdapter(iList));
    }

    public class OutsideAdapter extends RecyclerView.Adapter<OutsideAdapter.OutsideAdapterViewHolder> {

        private List<Integer> mList;

        OutsideAdapter(List<Integer> list) {
            this.mList = list;
        }

        @NonNull
        @Override
        public OutsideAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new OutsideAdapterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_inside_view, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull OutsideAdapterViewHolder holder, int i) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.rv_inside.setLayoutManager(layoutManager);
            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            holder.rv_inside.setOnFlingListener(null);//解决多个snaphelper报错的问题
            pagerSnapHelper.attachToRecyclerView(holder.rv_inside);
            holder.rv_inside.setAdapter(new InsideAdapter(sList));

            holder.tvPage.setText(String.format("%s/%s", i + 1, mList.size()));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class OutsideAdapterViewHolder extends RecyclerView.ViewHolder {

            RecyclerView rv_inside;
            TextView tvPage;

            OutsideAdapterViewHolder(@NonNull View itemView) {
                super(itemView);
                rv_inside = itemView.findViewById(R.id.rv_inside);
                tvPage = itemView.findViewById(R.id.tv_page);
            }
        }
    }

    public class InsideAdapter extends RecyclerView.Adapter<InsideAdapter.InsideadapterViewHolder> {

        private List<String> mList;

        public InsideAdapter(List<String> list) {
            this.mList = list;
        }

        @NonNull
        @Override
        public InsideadapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new InsideadapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_inside_imageview, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull InsideadapterViewHolder holder, int i) {
            Glide.with(mContext).load(mList.get(i)).into(holder.ivImage);
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class InsideadapterViewHolder extends RecyclerView.ViewHolder {

            ImageView ivImage;

            InsideadapterViewHolder(@NonNull View itemView) {
                super(itemView);
                ivImage = itemView.findViewById(R.id.tv_tv);
            }
        }


    }


}


