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
		// 1 ���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 2 ��ȡҳ����Ϣ
		String opt = request.getParameter("opt");
		String message_id = request.getParameter("message_id");
		String message_admin_id = request.getParameter("message_admin_id");
		String message_name = request.getParameter("message_name");
		String message_type = request.getParameter("message_type");
		String message_peoplecount = request
				.getParameter("message_peoplecount");
		String message_date = request.getParameter("message_date");
		String message_txt = request.getParameter("message_txt");

		// 3 ���ɶ���
		JC_Message message = new JC_Message();
		// 4 service
		IJC_Message iJC_Message = new IJC_MessageImpI();
		// 5 ��ű���������Ϣ
		List<JC_Message> listC = null;
		JC_Message message1 = new JC_Message();

		// ɾ������
		if ("del".equals(opt)) {
			// ��ȡǰ��ҳ���id����
			String delIds = request.getParameter("delIds");
			System.out.println("delIds--->" + delIds);
			JSONObject result = new JSONObject();
			int rows = iJC_Message.Deletemessage(delIds);
			System.out.println("rows---" + rows);
			if (rows > 0) {
				result.put("success", true);
				result.put("rows", rows);
			} else {
				result.put("errorMsg", "ɾ��ʧ��");
			}

			out.print(result);
			return;
		}

		// �ж�ִ�еĹ���
		// ���
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
				result.put("errorMsg", "����ʧ��");
			}
			out.print(result);

			return;

		}

		// �޸�
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
				result.put("errorMsg", "�޸�ʧ��");
			}
			out.print(result);
		
			return;
		}
		// ��ѯ����

		String flag = "1";// ����
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
		// �ؼ��ֲ�ѯ
		if ("query".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");

			if (StringUtil.isNotEmpty(message_id)) {

				message.setMessage_id(Integer.parseInt(message_id));
			}
			

			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));

			// ��ѯ������ϢĬ�Ϸ�ҳ
			listC = iJC_Message.queryAllJC_Message(pageBean, message);
			// ��ѯ�ܼ�¼��
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
