package com.nextdot.realtimesearchwithrxandroid.Model.Networking;


import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by sakib on 10/11/2017.
 */

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST()
    Observable<NoticeRoot> getSearchData(@Url String url,
                                         @Field("key") String key);
}
