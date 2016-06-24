package com.xu.service;

import com.xu.model.User;

public interface UserService {
	User getUserByOpenId(String openId);

	Integer addUser(User user);

	Integer editUser(User bean);
}
