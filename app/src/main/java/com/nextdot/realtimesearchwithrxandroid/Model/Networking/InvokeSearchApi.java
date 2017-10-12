package com.nextdot.realtimesearchwithrxandroid.Model.Networking;

import android.content.Context;
import android.util.Log;

import com.nextdot.realtimesearchwithrxandroid.Interface.OnRequestComplete;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Dipto on 10/12/2017.
 */

public class InvokeSearchApi {

    OnRequestComplete onRequestComplete ;
    RetrofitInterface retrofitInterface ;
    PublishSubject publishSubject ;

    public InvokeSearchApi(final Context context, String end_point, String key_value, final OnRequestComplete onRequestComplete){
        this.onRequestComplete = onRequestComplete ;
        retrofitInterface = RetrofitClient.getRetrofitClient().create(RetrofitInterface.class) ;
        String url = RetrofitClient.BASE_URL+end_point ;
        Log.d("++URL++", url) ;

        if(publishSubject == null){

            publishSubject = PublishSubject.create() ;
            publishSubject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .distinctUntilChanged()
                    .switchMap(searchValue -> retrofitInterface.getSearchData(url, key_value))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<NoticeRoot>() {

                        @Override
                        public void onNext(NoticeRoot noticeRoot) {
                            onRequestComplete.onRequestComplete(noticeRoot);
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
    }
}
