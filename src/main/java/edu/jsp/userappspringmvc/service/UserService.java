package edu.jsp.userappspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jsp.userappspringmvc.dao.UserDao;
import edu.jsp.userappspringmvc.dto.User;

@Component
public class UserService {
	@Autowired
	UserDao dao;

	public boolean saveUser(User user) {
		if (user != null) {
			dao.saveUser(user);
			return true;
		}
		return false;
	}

	public boolean updateUser(User user) {
		User exsitingUser = findUsersById(user.getUserId());
		if (exsitingUser != null) {
			dao.updateUser(user);
			return true;
		}
		return false;
	}

	public List<User> findAllUsers() {
		return dao.findAllUser();
	}

	public User findUsersById(long id) {
		return dao.findUserById(id);
	}

	public boolean deleteUser(long id) {
		User user = dao.findUserById(id);
		if (user != null) {
			dao.deletUser(user);
			return true;
		}
		return false;
	}
}
