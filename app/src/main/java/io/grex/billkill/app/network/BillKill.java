package io.grex.billkill.app.network;

import com.google.gson.JsonObject;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.POST;

public interface BillKill {
    final String BASE_URL = "";
    final String REGISTER_URL = "/api/register/";


    @POST(REGISTER_URL)
    public Response registerUser(@Body JsonObject jsonObject);

}
