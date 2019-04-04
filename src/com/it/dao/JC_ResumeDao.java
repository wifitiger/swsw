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
	// 增
	public boolean addJC_Resume(JC_Resume resume) {
		// 1 编写sql
		String sql = "insert into jc_resume(resume_id,resume_message_id,"
				+ "resume_name,resume_position,resume_work,"
				+ "resume_school,resume_tel,resume_mail)values(?,?,?,?,?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		
		// 3 处理参数
		Object params[] = { resume.getResume_id(),
										resume.getResume_message_id(),
										resume.getResume_name(),
										resume.getResume_position(),
										resume.getResume_work(),
										resume.getResume_school(),
										resume.getResume_tel(),
										resume.getResume_mail()};
		// 定义标志位
		
					try {
						int rows = queryRunner.update(sql, params);
						return rows > 0;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

						throw new RuntimeException("添加失败!!");
					} finally {
						// 释放资源到数据库连接池
						try {
							DbUtils.close(JDBCUtils.getConnections());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new RuntimeException("关闭资源失败!");
						}
					}
				}
	
	// 删
	public boolean delJC_Resume(JC_Resume resume) {
		// 1 编写sql
				String sql = "delete from jc_resume where resume_id=?";
				// 2 打印sql
				System.out.println("sql-->" + sql);
				// 3 处理参数
				Object params[] = { resume.getResume_id()};
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("删除失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}

	}

	// 改
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
				// 2 打印sql
				System.out.println("sql-->" + sql);
				System.out.println(resume);
				// 3 处理参数
				Object param[] = { 
						resume.getResume_message_id(),
						resume.getResume_name(),
						resume.getResume_position(),
						resume.getResume_work(),
						resume.getResume_school(),
						resume.getResume_tel(),
						resume.getResume_mail(),
						resume.getResume_id()};
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, param);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("修改失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}
			}

	// 查
	public List<JC_Resume> queryAll(JC_Resume resume){
		//编写sql
		String sql="SELECT * FROM  jc_resume  WHERE 1=1 ";
		// 2 打印sql
		System.out.println("sql-->" + sql);
	
		if(resume!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(resume.getResume_name()) && resume.getResume_name()!=null) {
				
				//拼接sql
				sql+="and resume_name like '%"+resume.getResume_name()+"%' ";
				
			}
			
			if(!"".equals(new Integer(resume.getResume_id())) && resume.getResume_id()!=0) {
				sql+=" and resume_id like '%"+resume.getResume_id()+"%'";
				
			}
		}
		
		System.out.println("sql-->"+sql);
		//存放所有resume信息
		List<JC_Resume> listD = null;
		try {
			listD = queryRunner.query(sql, new BeanListHandler<>(JC_Resume.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listD;
	}

	
	// 查
	public JC_Resume findById(JC_Resume resume) {
		 //编写sql
		String sql = "select * from jc_resume where resume_id=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {resume.getResume_id()};
		 
		 JC_Resume resume1 = null;
		 try {
			 resume1 =  queryRunner.query(sql, new BeanHandler< JC_Resume>( JC_Resume.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return resume1;
	}


	
	/*
	 * 带分页的查询所有
	 */
	public List<JC_Resume> queryAllJC_Resume(PageBean pageBean, JC_Resume resume) {
		 //编写sql
		StringBuffer sql = new StringBuffer("select * from jc_resume where 1=1 ");
		if(resume!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(resume.getResume_name()) && resume.getResume_name()!=null) {
				
				//拼接sql
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
		//存放所有Users信息
		List<JC_Resume> listD = null;
		try {
			listD = queryRunner.query(sql.toString(), new BeanListHandler<>(JC_Resume.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listD;
		
	}
	/**
	 * 查询记录总数
	 * @param user
	 * @return
	 */
	public int Countresume(JC_Resume resume){
		StringBuffer sb = new StringBuffer("select count(*) from jc_resume where 1=1 ");
		//有条件判断条件，重新拼接sql
		
		 Number num;
		try {
			num = (Number)queryRunner.query(sb.toString(),new ScalarHandler<>());
		
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		
		
		 
	}
	/**
	 * 删除多条记录
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



