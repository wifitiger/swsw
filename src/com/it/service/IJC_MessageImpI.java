package com.it.service;

import java.util.List;

import com.it.bean.JC_Message;
import com.it.bean.PageBean;
import com.it.dao.JC_MessageDao;

public class IJC_MessageImpI implements IJC_Message {
	
	JC_MessageDao jC_MessageDao  = new JC_MessageDao();

	@Override
	public boolean addJC_Message(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.addJC_Message(message);
	}

	@Override
	public boolean delJC_Message(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.delJC_Message(message);
	}

	@Override
	public boolean updJC_Message(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.updJC_Message(message);
	}



	@Override
	public JC_Message findJC_MessageById(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.findById(message);
	}


	@Override
	public int Deletemessage(String delIds) {
		// TODO Auto-generated method stub
		return jC_MessageDao.Deletemessage(delIds);
	}

	@Override
	public List<JC_Message> queryAllJC_Message(PageBean pageBean,
			JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.queryAll(pageBean, message);
	}

	@Override
	public int Countmessage(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.Countmessage(message);
	}

	@Override
	public List<JC_Message> queryAllJC_Message(JC_Message message) {
		// TODO Auto-generated method stub
		return jC_MessageDao.queryAllJC_Message(message) ;
	}

	}


	


