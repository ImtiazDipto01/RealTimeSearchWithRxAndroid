package com.nextdot.realtimesearchwithrxandroid.Interface;

import android.content.Context;

import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeItem;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

import okhttp3.Response;

/**
 * Created by sakib on 10/11/2017.
 */

public interface MainActivityView {

    public void showSearchResult(NoticeRoot noticeroot) ;

    public void startLoading() ;

    public void stopLoading() ;

    public void showMessage(String msg) ;

    Context getAppContext() ;
}
