package com.it.service;

import java.util.List;


import com.it.bean.JC_Resume;
import com.it.bean.PageBean;

public interface IJC_Resume {
	//增
	public boolean addJC_Resume(JC_Resume resume);
	//删
	public boolean delJC_Resume(JC_Resume resume);
	//改
	public boolean updJC_Resume(JC_Resume resume);
	//查询全部
	public List<JC_Resume> queryAllJC_Resume(JC_Resume resume);
	//模糊查询
	public JC_Resume findJC_ResumeById(JC_Resume resume);
	// 删除多条
	public int Deleteresume(String delIds);
	// 查询总记录
		public int Countresume(JC_Resume resume);
		// 分页查询所有
		public List<JC_Resume > queryAllJC_Resume(PageBean pageBean,
				JC_Resume resume);



}
