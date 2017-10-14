package com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class NoticeRoot{

	@SerializedName("notice")
	private List<NoticeItem> notice;

	public void setNotice(List<NoticeItem> notice){
		this.notice = notice;
	}

	public List<NoticeItem> getNotice(){
		return notice;
	}

	@Override
 	public String toString(){
		return 
			"NoticeRoot{" + 
			"notice = '" + notice + '\'' + 
			"}";
		}
}