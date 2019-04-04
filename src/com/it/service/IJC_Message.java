package com.it.service;

import java.util.List;

import com.it.bean.JC_Message;
import com.it.bean.PageBean;

public interface IJC_Message {
	// ��
	public boolean addJC_Message(JC_Message message);

	// ɾ
	public boolean delJC_Message(JC_Message message);

	// ��
	public boolean updJC_Message(JC_Message message);

	// ��
	public List<JC_Message> queryAllJC_Message(JC_Message message);

	// ��
	public JC_Message findJC_MessageById(JC_Message message);

	// ɾ��������¼
	public int Deletemessage(String delIds);

	// ��ѯ�ܼ�¼
	public int Countmessage(JC_Message message);

	// ��ҳ��ѯ����
	public List<JC_Message> queryAllJC_Message(PageBean pageBean,
			JC_Message message);

}
