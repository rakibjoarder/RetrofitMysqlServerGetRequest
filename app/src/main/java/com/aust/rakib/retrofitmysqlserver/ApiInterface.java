package com.aust.rakib.retrofitmysqlserver;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Personal on 7/26/2017.
 */

public interface ApiInterface {


    @GET("index.php")                 //https://pastebin.com/yW7hFQm9
    Call<ArrayList<ApiResponse>>response();


    @GET("Get.php")                  //https://pastebin.com/0EMgsdhx    //https://pastebin.com/g0Dd9JYZ
    Call<ArrayList<ApiResponse>>responseparmeters(@Query("item_types") String item_types);
}
