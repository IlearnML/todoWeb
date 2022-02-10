package model;

import java.sql.SQLException;

import exception.MessageException;
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
}
