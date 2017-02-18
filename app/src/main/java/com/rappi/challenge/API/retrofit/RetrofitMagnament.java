package com.rappi.challenge.API.retrofit;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rappi.challenge.API.response.PrincipalResponse;
import com.rappi.challenge.Interface.OnResponseInterface;
import com.rappi.challenge.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yxzan on 14/02/2017.
 */

public class RetrofitMagnament implements Callback<PrincipalResponse> {
    private OnResponseInterface onResponseInterface = null;

    public RetrofitMagnament(OnResponseInterface ml) {
        this.onResponseInterface = ml;
    }

    public void start(Context context) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.URL))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ChallengeInterface gerritAPI = retrofit.create(ChallengeInterface.class);

        Call<PrincipalResponse> call = gerritAPI.GetTopFreeApplications();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<PrincipalResponse> call, Response<PrincipalResponse> response) {
        if(response.isSuccessful()) {
            onResponseInterface.onResponseMethod(response.body());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<PrincipalResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
