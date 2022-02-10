package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todoweb")
public class TodoController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��û ������ ���ؼ� �ѱ��� ��쿡 ���ڵ� ó���ϴ� ����
		request.setCharacterEncoding("utf-8");
		// command pattern
		String command = request.getParameter("command");
		
		//?? ���⿡ ���� �� �޼ҵ� �־ ������ ~
		try{
			if(command.equals("login")){
				login(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
