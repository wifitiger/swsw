package com.it.service;

import java.util.List;
import com.it.bean.JC_Resume;
import com.it.bean.PageBean;
import com.it.dao.JC_ResumeDao;

public class IJC_ResumeImpl implements IJC_Resume {
	
	JC_ResumeDao jC_ResumeDao  = new JC_ResumeDao();

	@Override
	public boolean addJC_Resume(JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.addJC_Resume(resume);
	}

	@Override
	public boolean delJC_Resume(JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.delJC_Resume(resume);
	}

	@Override
	public boolean updJC_Resume(JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.updJC_Resume(resume);
	}

	@Override
	public List<JC_Resume> queryAllJC_Resume(JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.queryAll(resume);
	}

	@Override
	public JC_Resume findJC_ResumeById(JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.findById(resume);
	}

	@Override
	public int Deleteresume(String delIds) {
		// TODO Auto-generated method stub
		return  jC_ResumeDao.Deleteresume(delIds);
	}
	@Override
	public List<JC_Resume> queryAllJC_Resume(PageBean pageBean, JC_Resume resume) {
		// TODO Auto-generated method stub
		return jC_ResumeDao.queryAllJC_Resume(pageBean, resume);
	}
	@Override
	public int Countresume(JC_Resume resume) {
		// TODO Auto-generated method stub
		return  jC_ResumeDao.Countresume(resume);
	}

	


}