package com.it.service;

import java.util.List;

import com.it.bean.JC_Message;
import com.it.bean.PageBean;

public interface IJC_Message {
	// 增
	public boolean addJC_Message(JC_Message message);

	// 删
	public boolean delJC_Message(JC_Message message);

	// 改
	public boolean updJC_Message(JC_Message message);

	// 查
	public List<JC_Message> queryAllJC_Message(JC_Message message);

	// 查
	public JC_Message findJC_MessageById(JC_Message message);

	// 删除多条记录
	public int Deletemessage(String delIds);

	// 查询总记录
	public int Countmessage(JC_Message message);

	// 分页查询所有
	public List<JC_Message> queryAllJC_Message(PageBean pageBean,
			JC_Message message);

}
