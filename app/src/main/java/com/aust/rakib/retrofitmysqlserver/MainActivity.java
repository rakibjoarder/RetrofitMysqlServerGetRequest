package com.aust.rakib.retrofitmysqlserver;





import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    public static String BASEURL="http://10.0.3.2/Android/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
////for log/////
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor =new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        ////for log/////

        if(BuildConfig.DEBUG)
        {
            builder.addInterceptor(httpLoggingInterceptor);  //only for debugging mode
        }

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build()) ////for log/////
                .build();
        textView= (TextView) findViewById(R.id.text);
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);


        /*Call<ArrayList<ApiResponse>>arrayListCall=apiInterface.response();                     //Simple Get Request
        arrayListCall.enqueue(new Callback<ArrayList<ApiResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiResponse>> call, Response<ArrayList<ApiResponse>> response) {

                textView.setText(response.body().get(1).getName());
            }
            @Override
            public void onFailure(Call<ArrayList<ApiResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });*/

        Call<ArrayList<ApiResponse>>arrayListCall=apiInterface.responseparmeters("vegitable");    //Get Request With Parameters
        arrayListCall.enqueue(new Callback<ArrayList<ApiResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiResponse>> call, Response<ArrayList<ApiResponse>> response) {
                textView.setText(response.body().get(1).getName());
            }

            @Override
            public void onFailure(Call<ArrayList<ApiResponse>> call, Throwable t) {

            }
        });


    }
}
