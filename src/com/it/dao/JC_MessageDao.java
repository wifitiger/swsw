package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.JC_Message;
import com.it.bean.PageBean;

import com.it.utils.JDBCUtils;

public class JC_MessageDao {

		private QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		/**
		 * ��
		 * @return
		 * @throws SQLException
		 */
		public boolean addJC_Message(JC_Message message)  {
			// TODO Auto-generated method stub
			// 1 ��дsql
			String sql="INSERT INTO  shopping . jc_message (message_id ,"
					+ "message_admin_id ,message_name ,message_type ,"
					+ "message_peoplecount ,message_date ,message_txt ) "
					+ "VALUES (?,?,?,?,?,?,?)";
			// 2 ��ӡsql
			System.out.println("sql------>"+sql);
			// 3 �������
			Object param[]={message.getMessage_id(),
										message.getMessage_admin_id(),
										message.getMessage_name(),
										message.getMessage_type(),
										message.getMessage_peoplecount(),
										message.getMessage_date(),
										message.getMessage_txt()};
			// �����־λ
			
			try {
				int rows = queryRunner.update(sql, param);
				return rows > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				throw new RuntimeException("���ʧ��!!");
			} finally {
				// �ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			}
		}
//----------------------------------------------------------------------------------------------------
		
		/**
		 * ɾ
		 * @param cust
		 * @return
		 * @throws SQLException
		 */
		public boolean delJC_Message(JC_Message message) {
			// TODO Auto-generated method stub
			// 1 ��дsql
			String sql="DELETE FROM  shopping . jc_message  WHERE  message_id =?";
			// 2 ��ӡsql
			System.out.println("sql-->" + sql);
			// 3 �������
			Object param[] = { message.getMessage_id()};
			try {
				int rows = queryRunner.update(sql, param);
				return rows > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				throw new RuntimeException("ɾ��ʧ��!!");
			} finally {
				// �ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			}

		}
		/**
		 * ��
		 * @param 
		 * @return
		 * @throws SQLException
		 */
		public boolean updJC_Message(JC_Message message)  {
			// TODO Auto-generated method stub
			// 1 ��дsql
			String sql="UPDATE  shopping . jc_message"
					+ " SET "
					+ " message_admin_id  = ?,"
					+ " message_name  = ?,"
					+ " message_type  = ?,"
					+ " message_peoplecount  = ?,"
					+ " message_date  = ?,"
					+ " message_txt  = ?"
					+ "WHERE  message_id  = ?";
		
			//1, ������2, ��ʦ, 3, 2019-03-21, ��ͨ��˵��д, 2   ����˳������
			
			// 2 ��ӡsql
			System.out.println("sql-->" + sql);
			// 3 �������
			Object param[]={
										
										message.getMessage_admin_id(),
										message.getMessage_name(),
										message.getMessage_type(),
										message.getMessage_peoplecount(),
										message.getMessage_date(),
										message.getMessage_txt(),
			                            message.getMessage_id()};
			// �����־λ

			try {
				int rows = queryRunner.update(sql, param);
				return rows > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				throw new RuntimeException("�޸�ʧ��!!");
			} finally {
				// �ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			}
		}


		/**
		 * ��ѯ����
		 */
		public List<JC_Message> queryAllJC_Message(JC_Message message) {
			 //��дsql
			String sql="SELECT * FROM  jc_message  WHERE 1=1 ";
			if(message!=null){
				//�ж��˻������ı���ĺϷ���
				// "" null�ж�
			if(!"".equals(message.getMessage_name()) && message.getMessage_name()!=null) {
					//ƴ��sql
					sql+="and message_name like '%"+message.getMessage_name()+"%' ";
					
				}
				
				if(!"".equals(new Integer(message.getMessage_id())) && message.getMessage_id()!=0) {
					sql+=" and message_id like '%"+message.getMessage_id()+"%'";
					
				}
/*if(!"".equals(message.getMessage_type()) && message.getMessage_type()!=null) {
					
					
					sql+="and message_type like '%"+message.getMessage_type()+"%' ";
					
				}*/
				
			}
			
			System.out.println("sql-->"+sql);
			//�������Message��Ϣ
			List<JC_Message> listC = null;
			try {
				listC = queryRunner.query(sql, new BeanListHandler<>(JC_Message.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��ѯ����ʧ��!");
			}
			finally {
				//�ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			}
			return listC;
		}

		/**
		 * ģ����ѯ
		 */
		public JC_Message findById(JC_Message message) {
			// ��дsql
			String sql="SELECT * FROM  jc_message  WHERE  message_id  = "+message.getMessage_id()+"";
			
			// 2 ��ӡsql
			System.out.println("sql-->" + sql);
	/*		// 3 �������
			Object param[] = { message.getMessage_id() };*/

			JC_Message message1=null;
			
			try {
			/*	message1 = queryRunner.query(sql, new BeanHandler<JC_Message>(JC_Message.class), param);*/
				message1 = queryRunner.query(sql, new BeanHandler<JC_Message>(JC_Message.class));
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("��ѯ��������ʧ��!");
			} finally {
				// �ͷ���Դ�����ݿ����ӳ�
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("�ر���Դʧ��!");
				}
			}
			return message1;
		}

/*
 * ����ҳ�Ĳ�ѯ����
 */
public List<JC_Message> queryAll(PageBean pageBean,JC_Message message) {
	 //��дsql
	StringBuffer sql = new StringBuffer("select * from jc_message where 1=1 ");
	if(message!=null){
		//�ж��˻������ı���ĺϷ���
		// "" null�ж�
		if(!"".equals(message.getMessage_name()) && message.getMessage_name()!=null) {
			
			//ƴ��sql
			sql.append(" and message_name like '%"+message.getMessage_name()+"%' ");
			
		}
		
		if(!"".equals(new Integer(message.getMessage_id())) && message.getMessage_id()!=0) {
			sql.append("  and message_id like '%"+message.getMessage_id()+"%'");
			
		}
	}
	if (pageBean != null) {
		sql.append(" limit " + pageBean.getStart() + ","
				+ pageBean.getRows());
	}
	
	System.out.println("sql-->"+sql);
	//���������Ϣ
	List<JC_Message> list = null;
	try {
		list = queryRunner.query(sql.toString(), new BeanListHandler<>(JC_Message.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("��ѯ����ʧ��!");
	}
	finally {
		//�ͷ���Դ�����ݿ����ӳ�
		try {
			DbUtils.close(JDBCUtils.getConnections());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�ر���Դʧ��!");
		}
	}
	return list;
	
}
/**
 * ��ѯ��¼����
 * @param messageCount
 * @return
 */
public int Countmessage(JC_Message message){
	StringBuffer sb = new StringBuffer("select count(*) from jc_message where 1=1 ");
	//�������ж�����������ƴ��sql
	
	 Number num;
	try {
		num = (Number)queryRunner.query(sb.toString(),new ScalarHandler<>());
	  System.out.println(num.intValue());
		return num.intValue();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("��ѯ����ʧ��!");
	}finally {
		//�ͷ���Դ�����ݿ����ӳ�
		try {
			DbUtils.close(JDBCUtils.getConnections());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�ر���Դʧ��!");
		}
	}
	
	
	 
}
/**
 * ɾ��������¼
 * @param delIds
 * @return
 */
public int Deletemessage(String delIds) {
	System.out.println(delIds);
	String sql = "delete from  jc_message where message_id in (" + delIds + ")";
	 System.out.println("sql--->"+sql);
	try {
		return queryRunner.update(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}

}