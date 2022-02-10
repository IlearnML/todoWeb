package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MessageException;
import model.TodoService;
import model.DTO.UserDTO;

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
		System.out.println(command);
		
		//?? ���⿡ ���� �� �޼ҵ� �־ ������ ~
		try{
			if(command.equals("logIn")){
				login(request, response);
			}
			else if(command.equals("signUp")) {
				signUp(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userPw = request.getParameter("user_pw");
		
		UserDTO user = new UserDTO(userEmail, userName, userPw);
		try {
			boolean result = TodoService.addUser(user);
			if(result) {
				request.setAttribute("successMsg", "���� �Ϸ�");
				url = "index.html";
			}
		} catch (MessageException e) {
			request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
