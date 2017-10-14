package com.nextdot.realtimesearchwithrxandroid.Model.Networking;

import android.content.Context;
import android.util.Log;

import com.nextdot.realtimesearchwithrxandroid.Interface.OnRequestComplete;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Dipto on 10/12/2017.
 */

public class InvokeSearchApi {

    OnRequestComplete requestComplete ;
    RetrofitInterface retrofitInterface ;
    PublishSubject publishSubject ;

    public InvokeSearchApi(final Context context, final String end_point, final String key_value, final OnRequestComplete onRequestComplete){
        this.requestComplete = onRequestComplete ;
        retrofitInterface = RetrofitClient.getRetrofitClient().create(RetrofitInterface.class) ;
        String url = RetrofitClient.BASE_URL;

        Log.d("++URL++", key_value) ;

        if(publishSubject == null){

            publishSubject = PublishSubject.create() ;
            publishSubject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .distinctUntilChanged()
                    .switchMap(searchValue -> retrofitInterface.getSearchData(end_point, key_value).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()))
                    .subscribeWith(new DisposableObserver<NoticeRoot>() {

                        @Override
                        public void onNext(NoticeRoot noticeRoot) {
                            Log.d("++stage++", "on Next") ;
                            requestComplete.onRequestComplete(noticeRoot);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.d("++exception++", String.valueOf(e)) ;
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        publishSubject.onNext(key_value);
    }
}
