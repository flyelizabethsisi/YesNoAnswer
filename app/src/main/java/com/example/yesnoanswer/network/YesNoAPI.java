package com.example.yesnoanswer.network;

import com.example.yesnoanswer.models.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YesNoAPI {
    String PATH="api";

    @GET(PATH)
    Call<Info> getInfoList();
}

