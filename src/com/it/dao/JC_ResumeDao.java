package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.JC_Resume;
import com.it.bean.PageBean;
import com.it.utils.JDBCUtils;

public class JC_ResumeDao {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	// ��
	public boolean addJC_Resume(JC_Resume resume) {
		// 1 ��дsql
		String sql = "insert into jc_resume(resume_id,resume_message_id,"
				+ "resume_name,resume_position,resume_work,"
				+ "resume_school,resume_tel,resume_mail)values(?,?,?,?,?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		
		// 3 �������
		Object params[] = { resume.getResume_id(),
										resume.getResume_message_id(),
										resume.getResume_name(),
										resume.getResume_position(),
										resume.getResume_work(),
										resume.getResume_school(),
										resume.getResume_tel(),
										resume.getResume_mail()};
		// �����־λ
		
					try {
						int rows = queryRunner.update(sql, params);
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
	
	// ɾ
	public boolean delJC_Resume(JC_Resume resume) {
		// 1 ��дsql
				String sql = "delete from jc_resume where resume_id=?";
				// 2 ��ӡsql
				System.out.println("sql-->" + sql);
				// 3 �������
				Object params[] = { resume.getResume_id()};
				// �����־λ

				try {
					int rows = queryRunner.update(sql, params);
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

	// ��
	public boolean updJC_Resume(JC_Resume resume)  {
		// TODO Auto-generated method stub
		String sql="UPDATE  shopping . jc_resume  SET "
				+ "resume_message_id  = ?, "
				+ "resume_name  = ?, "
				+ "resume_position  = ?,"
				+ " resume_work = ?,"
				+ "resume_school  = ?,"
				+ " resume_tel  = ? ,"
				+ "resume_mail  = ? "
				+ " WHERE  resume_id  = ? ";
				// 2 ��ӡsql
				System.out.println("sql-->" + sql);
				System.out.println(resume);
				// 3 �������
				Object param[] = { 
						resume.getResume_message_id(),
						resume.getResume_name(),
						resume.getResume_position(),
						resume.getResume_work(),
						resume.getResume_school(),
						resume.getResume_tel(),
						resume.getResume_mail(),
						resume.getResume_id()};
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

	// ��
	public List<JC_Resume> queryAll(JC_Resume resume){
		//��дsql
		String sql="SELECT * FROM  jc_resume  WHERE 1=1 ";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
	
		if(resume!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(resume.getResume_name()) && resume.getResume_name()!=null) {
				
				//ƴ��sql
				sql+="and resume_name like '%"+resume.getResume_name()+"%' ";
				
			}
			
			if(!"".equals(new Integer(resume.getResume_id())) && resume.getResume_id()!=0) {
				sql+=" and resume_id like '%"+resume.getResume_id()+"%'";
				
			}
		}
		
		System.out.println("sql-->"+sql);
		//�������resume��Ϣ
		List<JC_Resume> listD = null;
		try {
			listD = queryRunner.query(sql, new BeanListHandler<>(JC_Resume.class));
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
		return listD;
	}

	
	// ��
	public JC_Resume findById(JC_Resume resume) {
		 //��дsql
		String sql = "select * from jc_resume where resume_id=?";
		//2 ��ӡsql
		 System.out.println("sql-->"+sql);
		 //3 �������
		 Object params[] = {resume.getResume_id()};
		 
		 JC_Resume resume1 = null;
		 try {
			 resume1 =  queryRunner.query(sql, new BeanHandler< JC_Resume>( JC_Resume.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
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
		return resume1;
	}


	
	/*
	 * ����ҳ�Ĳ�ѯ����
	 */
	public List<JC_Resume> queryAllJC_Resume(PageBean pageBean, JC_Resume resume) {
		 //��дsql
		StringBuffer sql = new StringBuffer("select * from jc_resume where 1=1 ");
		if(resume!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(resume.getResume_name()) && resume.getResume_name()!=null) {
				
				//ƴ��sql
				sql.append("and resume_name like '%"+resume.getResume_name()+"%' ");
				
			}
			
			if(!"".equals(new Integer(resume.getResume_id())) && resume.getResume_id()!=0) {
				
				sql.append(" and resume_id like '%"+resume.getResume_id()+"%'");
				
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		
		System.out.println("sql-->"+sql);
		//�������Users��Ϣ
		List<JC_Resume> listD = null;
		try {
			listD = queryRunner.query(sql.toString(), new BeanListHandler<>(JC_Resume.class));
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
		return listD;
		
	}
	/**
	 * ��ѯ��¼����
	 * @param user
	 * @return
	 */
	public int Countresume(JC_Resume resume){
		StringBuffer sb = new StringBuffer("select count(*) from jc_resume where 1=1 ");
		//�������ж�����������ƴ��sql
		
		 Number num;
		try {
			num = (Number)queryRunner.query(sb.toString(),new ScalarHandler<>());
		
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
	public int Deleteresume(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  jc_resume where resume_id in (" + delIds + ")";
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



