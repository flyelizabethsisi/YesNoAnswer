package com.example.yesnoanswer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yesnoanswer.models.Info;
import com.example.yesnoanswer.network.RetrofitSingleton;
import com.example.yesnoanswer.network.YesNoAPI;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AnswerActivity extends AppCompatActivity {
    private static Info info;
    private static Info infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        TextView answerQuestion = findViewById(R.id.answer_questionr);

        Intent intent = getIntent();
        String userQuestion = intent.getStringExtra(MainActivity.QUESTION_INPUT);
        answerQuestion.setText(userQuestion);

        TextView answerText;
        ImageView answerImage;

        answerImage = findViewById(R.id.info_photo);
        answerText = findViewById(R.id.info_answer);

        Retrofit retrofit = RetrofitSingleton.getInstance();

        YesNoAPI yesNoAPI = retrofit.create(YesNoAPI.class);
        Call<Info> infoCall = yesNoAPI.getInfoList();
        infoCall.enqueue(new Callback<Info>() {

            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Log.d("elizabeth", response.body().getAnswer());
                String answerQuestion = response.body().getAnswer().toUpperCase();
                answerText.setText(answerQuestion);
                String imageQuestion = response.body().getImage();
                Picasso.get().load(imageQuestion).into(answerImage);

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });
    }
}