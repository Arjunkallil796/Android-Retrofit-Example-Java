package com.prototype.retrofitexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private EditText mEdtTtl;
    private EditText mEdtCntnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mEdtTtl = findViewById(R.id.edt_ttl);
        mEdtCntnt = findViewById(R.id.edt_cntnt);
    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }

    public void onSubmitClicked(View view) {

        if (mEdtTtl.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(),"Enter Title",Toast.LENGTH_LONG).show();
        } else if (mEdtCntnt.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(),"Enter Content",Toast.LENGTH_LONG).show();
        } else {
            invokeAPI();
        }

    }

    private void invokeAPI() {

        Call<PostResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createPost(mEdtTtl.getText().toString(),mEdtCntnt.getText().toString(),1);

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                String s = response.body().toString();
                Toast.makeText(getApplicationContext(),response.body().getBody(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
