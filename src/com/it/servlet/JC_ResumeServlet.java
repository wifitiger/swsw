package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.it.bean.JC_Resume;
import com.it.bean.PageBean;
import com.it.service.IJC_ResumeImpl;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class JC_ResumeServlet
 */
@WebServlet({ "/JC_ResumeServlet", "/Resume.do", "/resume.do" })
public class JC_ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JC_ResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		// 2 获取页面信息
		String opt = request.getParameter("opt");
		String resume_id = request.getParameter("resume_id");
		String resume_message_id = request.getParameter("resume_message_id");
		String resume_name = request.getParameter("resume_name");
		String resume_position = request.getParameter("resume_position");
		String resume_work = request.getParameter("resume_work");
		String resume_school = request.getParameter("resume_school");
		String resume_tel= request.getParameter("resume_tel");
		String resume_mail= request.getParameter("resume_mail");
		
		// 3 生成对象
		JC_Resume resume = new JC_Resume();
				// 4 service
				IJC_ResumeImpl iJC_Resume =new IJC_ResumeImpl();
				// 5 存放表中所有信息
				List<JC_Resume> listD = null;
				JC_Resume resume1 = null;
				
				//删除功能
				if("del".equals(opt)){
					//获取前端页面的id集合
					String delIds = request.getParameter("delIds");
                      System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					int rows = iJC_Resume.Deleteresume(delIds);
					System.out.println("rows---------->"+rows);
					if (rows > 0) {
						result.put("success", true);
						result.put("rows", rows);
					} else {
						result.put("errorMsg", "删除失败");
					}
					
					out.print(result);
					return;
				}
					
					
				
		// 判断执行的功能
		//add
				if("add".equals(opt)){
					// "" null 
					
					if (StringUtil.isNotEmpty(resume_message_id)) {

						resume.setResume_message_id(Integer.parseInt(resume_message_id));

					}
					if (StringUtil.isNotEmpty(resume_name)) {

						resume.setResume_name(resume_name);

					}
					if (StringUtil.isNotEmpty(resume_position)) {

						resume.setResume_position(resume_position);

					}
					if (StringUtil.isNotEmpty(resume_work)) {

						resume.setResume_work(resume_work);

					}
					if (StringUtil.isNotEmpty(resume_school)) {

						resume.setResume_school(resume_school);

					}
					if (StringUtil.isNotEmpty(resume_tel)) {

						resume.setResume_tel(resume_tel);

					}
					if (StringUtil.isNotEmpty(resume_mail)) {

						resume.setResume_mail(resume_mail);

					}
		
					JSONObject result = new JSONObject();
					boolean flag = iJC_Resume.addJC_Resume(resume);
				
					
					if(flag){
						result.put("success", true);
					}else{
						result.put("success", false);
						result.put("errorMsg", "保存失败");
					}
					out.print(result);
					
					return;
					
					
				}
				
		//修改
		if("upd".equals(opt)){
			// "" null
			
			if (StringUtil.isNotEmpty(resume_id)) {

				resume.setResume_id(Integer.parseInt(resume_id));
               System.out.println("resume888888888"+resume);
			}
			if (StringUtil.isNotEmpty(resume_message_id)) {

				resume.setResume_message_id(Integer.parseInt(resume_message_id));

			}
			if (StringUtil.isNotEmpty(resume_name)) {

				resume.setResume_name(resume_name);

			}
			if (StringUtil.isNotEmpty(resume_position)) {

				resume.setResume_position(resume_position);

			}
			if (StringUtil.isNotEmpty(resume_work)) {

				resume.setResume_work(resume_work);

			}
			if (StringUtil.isNotEmpty(resume_school)) {

				resume.setResume_school(resume_school);

			}
			if (StringUtil.isNotEmpty(resume_tel)) {

				resume.setResume_tel(resume_tel);

			}
			if (StringUtil.isNotEmpty(resume_mail)) {

				resume.setResume_mail(resume_mail);

			}
			System.out.println("resume"+resume);
			JSONObject result = new JSONObject();
			boolean flag = iJC_Resume.updJC_Resume(resume);
			if(flag){
				result.put("success", true);
			}else{
				result.put("success", false);
				result.put("errorMsg", "修改失败");
			}
			out.print(result);

			return;
		}
//查询单个
		String flag = "1";//可用
		if("findById".equals(opt)){
			// "" null
			
			if (StringUtil.isNotEmpty(resume_id)) {

			resume.setResume_id(Integer.parseInt(resume_id));

			}
			JC_Resume resume2 = iJC_Resume.findJC_ResumeById(resume1);
			
			if(resume2!=null){
				flag = "-1";
						
			}
			System.out.println("flag-->"+flag);
			out.print(flag);
			
			
		}
		//查询所有
		if("query".equals(opt)){
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			if (StringUtil.isNotEmpty(resume_id)) {

				resume.setResume_id(Integer.parseInt(resume_id));

			}
		
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			
			//查询所有信息默认分页
			listD = iJC_Resume.queryAllJC_Resume(pageBean, resume);
			//查询总记录数
			int total = iJC_Resume.Countresume(resume);
			
			JSONObject result = new JSONObject();
			
			JSONArray jsonArray = JSONArray.fromObject(listD);
			result.put("total", total);
			result.put("rows", jsonArray);
			System.out.println(result.toString());
			 out.print(result);

			
			return;
		}
	}
}
