package com.liu.community.provider;

import com.alibaba.fastjson.JSON;
import com.liu.community.dto.AccessTokenDTO;
import com.liu.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

   public String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

       OkHttpClient client = new OkHttpClient();

       String url = "https://github.com/login/oauth/access_token";

       RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
       Request request = new Request.Builder()
               .url(url)
               .post(body)
               .build();
       try (Response response = client.newCall(request).execute()) {

           String string  = response.body().string();
           String[] tokens = string.split("&");
           String result = tokens[0].split("=")[1];

           System.out.println(result);
           return  result;
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;

   }

   public GithubUser getUser(String accessToken){
       OkHttpClient client = new OkHttpClient();
       String url = "https://api.github.com/user?access_token="+accessToken;
       Request request = new Request.Builder()
               .url(url)
               .build();
       try {
           Response response = client.newCall(request).execute();
           String string = response.body().string();
           GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
           return githubUser;
       } catch (IOException e) {
           e.printStackTrace();
       };
        return null;
   }
}
