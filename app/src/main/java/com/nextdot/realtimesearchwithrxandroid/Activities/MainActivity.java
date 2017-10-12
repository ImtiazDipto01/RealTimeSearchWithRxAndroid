package com.nextdot.realtimesearchwithrxandroid.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.nextdot.realtimesearchwithrxandroid.Interface.MainActivityView;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeItem;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;
import com.nextdot.realtimesearchwithrxandroid.Presenter.MainAcitivityPresenter;
import com.nextdot.realtimesearchwithrxandroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sakib on 10/11/2017.
 */

public class MainActivity extends AppCompatActivity implements MainActivityView {

    List<NoticeItem> list;
    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.myrecyler)
    RecyclerView myrecyler;
    MainAcitivityPresenter mainAcitivityPresenter ;
    String end_point = "get_search_result.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainAcitivityPresenter = new MainAcitivityPresenter(this) ;
        list = new ArrayList<>();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mainAcitivityPresenter.getSearchResult(newText, end_point);
                return false;
            }
        });
    }

    @Override
    public void showSearchResult(NoticeRoot noticeroot) {
        list = noticeroot.getNotice();
        if (list != null) {
            for (NoticeItem noticeItem : list) {
                Log.d("result :", noticeItem.getTitle());
            }
        }
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public Context getAppContext() {
        return null;
    }
}
