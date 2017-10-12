package com.nextdot.realtimesearchwithrxandroid.Interface;

import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeItem;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

/**
 * Created by sakib on 10/11/2017.
 */

public interface OnRequestComplete {
    public void onRequestComplete(NoticeRoot noticeRoot) ;

    public void onRequestError(String msg) ;
}
