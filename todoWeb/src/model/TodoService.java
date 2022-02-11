package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.MessageException;
import exception.NotExistException;
import model.DTO.TodoDTO;
import model.DTO.UserDTO;

public class TodoService {
	//User - CRUD
	public static boolean addUser(UserDTO user) throws MessageException{
		boolean result = false;
		try {
			result = UserDAO.addUser(user);
			
		} catch (SQLException e) {
			throw new MessageException("�ùٸ��� �Է����� �ʾҽ��ϴ�.");
		}
		return result;
	}
	public static UserDTO login(String userEmail, String userPw) throws MessageException {
		UserDTO result = null;
		
		try {
			result = UserDAO.login(userEmail, userPw);
		} catch (SQLException e) {
			throw new MessageException("�̸��� Ȥ�� ��й�ȣ�� �߸� �ԷµǾ����ϴ�.");
		}
		
		return result;
	}
	
	public static void notExistTodo(String todoId) throws NotExistException, SQLException{
		TodoDTO todo = TodoDAO.getTodo(todoId);
		if(todo == null){
			throw new NotExistException("�߸��� todoId �Դϴ�.");
		}
	}
	
	public static ArrayList<TodoDTO> getAlltodo() throws SQLException{
		return TodoDAO.getAlltodo();
	}
	
		
	
	public static boolean deleteTodo(String todoId) throws SQLException, NotExistException{
		notExistTodo(todoId);
		boolean result = TodoDAO.deleteTodo(todoId);
		if(!result){
			throw new NotExistException("�� �� ���� ����");
		}
		return result;
	}
}
