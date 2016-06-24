package com.xu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.model.User;
import com.xu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService service = null;

	public UserService getService() {
		return service;
	}

	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * 通过微信的openId获取用户信息
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/{openId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User getUser(String openId){
		return service.getUserByOpenId(openId);
	}
	
	 /**
     * 新增, 成功反馈201 created状态
     *
     * @param user 
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addUser(User user) {
        return this.service.addUser(user);
    }
    
    /**
     * 编辑模型实体,修改成功反馈204 NO CONTENT状态
     *
     * @param bean 编辑后的模型实体
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer editUser(User bean) {
        return service.editUser(bean);
    }
    
}
