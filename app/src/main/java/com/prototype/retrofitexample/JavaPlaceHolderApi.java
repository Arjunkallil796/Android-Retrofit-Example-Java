package com.prototype.retrofitexample;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JavaPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();


    @FormUrlEncoded
    @POST("posts")
    Call<PostResponse> createPost(
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") int userId
    );
}
