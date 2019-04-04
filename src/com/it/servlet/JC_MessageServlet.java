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

import com.it.bean.JC_Message;
import com.it.bean.PageBean;

import com.it.service.IJC_Message;
import com.it.service.IJC_MessageImpI;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class JC_MessageServlet
 */
@WebServlet({ "/JC_MessageServlet", "/message.do", "/JC_Message.do" })
public class JC_MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JC_MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 2 获取页面信息
		String opt = request.getParameter("opt");
		String message_id = request.getParameter("message_id");
		String message_admin_id = request.getParameter("message_admin_id");
		String message_name = request.getParameter("message_name");
		String message_type = request.getParameter("message_type");
		String message_peoplecount = request
				.getParameter("message_peoplecount");
		String message_date = request.getParameter("message_date");
		String message_txt = request.getParameter("message_txt");

		// 3 生成对象
		JC_Message message = new JC_Message();
		// 4 service
		IJC_Message iJC_Message = new IJC_MessageImpI();
		// 5 存放表中所有信息
		List<JC_Message> listC = null;
		JC_Message message1 = new JC_Message();

		// 删除功能
		if ("del".equals(opt)) {
			// 获取前端页面的id集合
			String delIds = request.getParameter("delIds");
			System.out.println("delIds--->" + delIds);
			JSONObject result = new JSONObject();
			int rows = iJC_Message.Deletemessage(delIds);
			System.out.println("rows---" + rows);
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
		// 添加
		if ("add".equals(opt)) {
			// "" null

			if (StringUtil.isNotEmpty(message_id)) {

				message.setMessage_id(Integer.parseInt(message_id));
			}
			if (StringUtil.isNotEmpty(message_admin_id)) {

				message.setMessage_admin_id(message_admin_id);
			}
			if (StringUtil.isNotEmpty(message_name)) {

				message.setMessage_name(message_name);
			}
			if (StringUtil.isNotEmpty(message_type)) {

				message.setMessage_type(message_type);
			}
			if (StringUtil.isNotEmpty(message_peoplecount)) {

				message.setMessage_peoplecount(message_peoplecount);
			}
			if (StringUtil.isNotEmpty(message_date)) {

				message.setMessage_date(message_date);
			}
			if (StringUtil.isNotEmpty(message_txt)) {

				message.setMessage_txt(message_txt);
			}

			JSONObject result = new JSONObject();
			boolean flag = iJC_Message.addJC_Message(message);
			
			
			if (flag) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("errorMsg", "保存失败");
			}
			out.print(result);

			return;

		}

		// 修改
		if ("upd".equals(opt)) {
			// "" null

			if (StringUtil.isNotEmpty(message_id)) {

				message.setMessage_id(Integer.parseInt(message_id));
			}
			if (StringUtil.isNotEmpty(message_admin_id)) {

				message.setMessage_admin_id(message_admin_id);
			}
			if (StringUtil.isNotEmpty(message_name)) {

				message.setMessage_name(message_name);
			}
			if (StringUtil.isNotEmpty(message_type)) {

				message.setMessage_type(message_type);
			}
			if (StringUtil.isNotEmpty(message_peoplecount)) {

				message.setMessage_peoplecount(message_peoplecount);
			}
			if (StringUtil.isNotEmpty(message_date)) {

				message.setMessage_date(message_date);
			}
			if (StringUtil.isNotEmpty(message_txt)) {

				message.setMessage_txt(message_txt);
			}

			JSONObject result = new JSONObject();
			boolean flag = iJC_Message.updJC_Message(message);
			if (flag) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("errorMsg", "修改失败");
			}
			out.print(result);
		
			return;
		}
		// 查询单个

		String flag = "1";// 可用
		if ("findById".equals(opt)) {
			// "" null

			if (StringUtil.isNotEmpty(message_id)) {

				message.setMessage_id(Integer.parseInt(message_id));
			}
			JC_Message message2 = iJC_Message.findJC_MessageById(message1);

			if (message2 != null) {
				flag = "-1";

			}
			System.out.println("flag-->" + flag);
			out.print(flag);

		}
		// 关键字查询
		if ("query".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");

			if (StringUtil.isNotEmpty(message_id)) {

				message.setMessage_id(Integer.parseInt(message_id));
			}
			

			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));

			// 查询所有信息默认分页
			listC = iJC_Message.queryAllJC_Message(pageBean, message);
			// 查询总记录数
			int total = iJC_Message.Countmessage(message);

			JSONObject result = new JSONObject();

			JSONArray jsonArray = JSONArray.fromObject(listC);
			result.put("total", total);
			result.put("rows", jsonArray);
			System.out.println(result.toString());
			out.print(result);
	

			return;
		}

	}
}
