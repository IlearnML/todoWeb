package model;

import java.sql.SQLException;

import exception.MessageException;
import model.DTO.UserDTO;

public class TodoService {
	//User - CRUD
	public static boolean addUser(UserDTO user) throws MessageException{
		boolean result = false;
		try {
			System.out.println("����");
			result = UserDAO.addUser(user);
			
		} catch (SQLException e) {
			throw new MessageException("�ùٸ��� �Է����� �ʾҽ��ϴ�.");
		}
		return result;
	}
}
