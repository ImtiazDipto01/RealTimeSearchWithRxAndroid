package com.nextdot.realtimesearchwithrxandroid.Presenter;

import com.nextdot.realtimesearchwithrxandroid.Interface.MainActivityView;
import com.nextdot.realtimesearchwithrxandroid.Interface.OnRequestComplete;
import com.nextdot.realtimesearchwithrxandroid.Model.Networking.InvokeSearchApi;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;

/**
 * Created by sakib on 10/11/2017.
 */

public class MainAcitivityPresenter {

    MainActivityView mainActivityView ;
    String key_value, end_point ;

    public MainAcitivityPresenter(MainActivityView view){
        this.mainActivityView = view ;

    }

    public void getSearchResult(String end_point, String key_value){

        new InvokeSearchApi(mainActivityView.getAppContext(), end_point, key_value, new OnRequestComplete() {
            @Override
            public void onRequestComplete(NoticeRoot noticeRoot) {
                mainActivityView.showSearchResult(noticeRoot);
            }

            @Override
            public void onRequestError(String msg) {

            }
        });

    }
}
