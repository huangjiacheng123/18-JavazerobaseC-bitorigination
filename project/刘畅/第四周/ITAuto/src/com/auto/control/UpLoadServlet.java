package com.auto.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpLoadServlet
 */
@WebServlet("/upload")
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpLoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取DiskFileItemFactory对象
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		FileItemFactory factory = new DiskFileItemFactory();
		// 使用factory创建一个ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// item.getName()获取的是文件名
				System.out.println("name:" + item.getName());
				// 获取到的是页面控件的名字
				System.out.println("FieldName:" + item.getFieldName());
				// 判断是否是普通的列表类型，如若返回值是false则表示该类型是file文件
				System.out.println("FormField:" + item.isFormField());
				// String path = this.getServletContext().getRealPath("/upload");
				String path = "D:\\AD\\temp";
				//String name = "" + System.currentTimeMillis();
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
				System.out.println(simpleDateFormat.format(date));
				System.out.println(date.getTime());
				//System.out.println("name:" + name);
				// 获取后缀名
				String ext = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());
				System.out.println(ext);
				// System.out.println(System.getProperty("java.io.tmpdir"));
				item.write(new File(path + "/" + "ITAuto" + ext));
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/ITAuto/es");;
		
		
		

	}

}
