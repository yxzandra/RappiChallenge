package com.rappi.challenge.API.retrofit;

import com.rappi.challenge.API.response.PrincipalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yxzan on 14/02/2017.
 */

public interface ChallengeInterface {

    @GET("topfreeapplications/limit=20/json")
    Call<PrincipalResponse> GetTopFreeApplications();
}
