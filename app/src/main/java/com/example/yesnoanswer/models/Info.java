package com.example.yesnoanswer.models;

import java.io.Serializable;

public class Info  {
   private String answer;
   private String image;

    public Info(String answer, String image) {
        this.answer = answer;
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public String getImage() {
        return image;
    }
}
