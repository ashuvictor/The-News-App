package com.example.thekhabriapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    String api="c60df5f474ff41f0b91c4e8649a65b63";
    ArrayList<ModelClass> modelClassArrayList;
Adapter adapter;
String country="in";
private RecyclerView recyclerViewOfHome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.homefragment,null);
recyclerViewOfHome=view.findViewById(R.id.recyclerViewHome);
modelClassArrayList=new ArrayList<>();
recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
adapter=new Adapter(getContext(),modelClassArrayList);
recyclerViewOfHome.setAdapter(adapter);
findNews();






return view;



    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
