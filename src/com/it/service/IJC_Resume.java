package com.it.service;

import java.util.List;


import com.it.bean.JC_Resume;
import com.it.bean.PageBean;

public interface IJC_Resume {
	//��
	public boolean addJC_Resume(JC_Resume resume);
	//ɾ
	public boolean delJC_Resume(JC_Resume resume);
	//��
	public boolean updJC_Resume(JC_Resume resume);
	//��ѯȫ��
	public List<JC_Resume> queryAllJC_Resume(JC_Resume resume);
	//ģ����ѯ
	public JC_Resume findJC_ResumeById(JC_Resume resume);
	// ɾ������
	public int Deleteresume(String delIds);
	// ��ѯ�ܼ�¼
		public int Countresume(JC_Resume resume);
		// ��ҳ��ѯ����
		public List<JC_Resume > queryAllJC_Resume(PageBean pageBean,
				JC_Resume resume);



}
