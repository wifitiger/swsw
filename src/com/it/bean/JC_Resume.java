package com.it.bean;

public class JC_Resume {
	/**
	 * ºÚ¿˙–≈œ¢
	 */
	private static final long serialVersionUID = 1L;
	private int resume_id;
	private int resume_message_id;
	private String resume_name;
	private String resume_position;
	private String resume_work;
	private String resume_school;
	private String resume_tel;
	private String resume_mail;
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	public int getResume_message_id() {
		return resume_message_id;
	}
	public void setResume_message_id(int resume_message_id) {
		this.resume_message_id = resume_message_id;
	}
	public String getResume_name() {
		return resume_name;
	}
	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}
	public String getResume_position() {
		return resume_position;
	}
	public void setResume_position(String resume_position) {
		this.resume_position = resume_position;
	}
	public String getResume_work() {
		return resume_work;
	}
	public void setResume_work(String resume_work) {
		this.resume_work = resume_work;
	}
	public String getResume_school() {
		return resume_school;
	}
	public void setResume_school(String resume_school) {
		this.resume_school = resume_school;
	}
	public String getResume_tel() {
		return resume_tel;
	}
	public void setResume_tel(String resume_tel) {
		this.resume_tel = resume_tel;
	}
	public String getResume_mail() {
		return resume_mail;
	}
	public void setResume_mail(String resume_mail) {
		this.resume_mail = resume_mail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JC_Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JC_Resume [resume_id=" + resume_id + ", resume_message_id="
				+ resume_message_id + ", resume_name=" + resume_name
				+ ", resume_position=" + resume_position + ", resume_work="
				+ resume_work + ", resume_school=" + resume_school
				+ ", resume_tel=" + resume_tel + ", resume_mail=" + resume_mail
				+ "]";
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
}
