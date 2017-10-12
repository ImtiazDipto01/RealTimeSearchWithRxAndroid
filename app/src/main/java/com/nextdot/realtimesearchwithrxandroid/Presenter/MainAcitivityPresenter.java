package com.nextdot.realtimesearchwithrxandroid.Presenter;

import com.nextdot.realtimesearchwithrxandroid.Activities.MainActivity;
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

    public void getSearchResult(String key_value, String end_point){
        this.key_value = key_value ;
        this.end_point = end_point ;
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
