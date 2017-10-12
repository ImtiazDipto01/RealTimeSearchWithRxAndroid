package com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel;

import java.util.List;

public class NoticeRoot {
	private List<NoticeItem> notice;

	public void setNotice(List<NoticeItem> notice){
		this.notice = notice;
	}

	public List<NoticeItem> getNotice(){
		return notice;
	}
}