# Android-Retrofit-Example-Java

This is an example project for begginers to learn Android networking using Retrofit in Java.

## RetrofitClient.java  

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;


    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

}


## API.java

public interface Api {

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
