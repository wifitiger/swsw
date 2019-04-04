package com.it.bean;

public class JC_Message {
		/**
		 * 信息发布
		 */
		private static final long serialVersionUID = 1L;
		private int message_id;
		private String message_admin_id;
		private String message_name;
		private String message_type;
		private String message_peoplecount;
		private String message_date;
		private String message_txt;
		public int getMessage_id() {
			return message_id;
		}
		public void setMessage_id(int message_id) {
			this.message_id = message_id;
		}
		public String getMessage_admin_id() {
			return message_admin_id;
		}
		public void setMessage_admin_id(String message_admin_id) {
			this.message_admin_id = message_admin_id;
		}
		public String getMessage_name() {
			return message_name;
		}
		public void setMessage_name(String message_name) {
			this.message_name = message_name;
		}
		public String getMessage_type() {
			return message_type;
		}
		public void setMessage_type(String message_type) {
			this.message_type = message_type;
		}
		public String getMessage_peoplecount() {
			return message_peoplecount;
		}
		public void setMessage_peoplecount(String message_peoplecount) {
			this.message_peoplecount = message_peoplecount;
		}
		public String getMessage_date() {
			return message_date;
		}
		public void setMessage_date(String message_date) {
			this.message_date = message_date;
		}
		public String getMessage_txt() {
			return message_txt;
		}
		public void setMessage_txt(String message_txt) {
			this.message_txt = message_txt;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public JC_Message() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "JC_Message [message_id=" + message_id
					+ ", message_admin_id=" + message_admin_id
					+ ", message_name=" + message_name + ", message_type="
					+ message_type + ", message_peoplecount="
					+ message_peoplecount + ", message_date=" + message_date
					+ ", message_txt=" + message_txt + "]";
		}
		
}