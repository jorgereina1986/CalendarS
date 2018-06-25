package com.jorgereina.calendars;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jorgereina on 6/22/18.
 */

public interface CalendarApi {

    @GET("airlines")
    Call<ResponseBody> response();
}
