package com.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.UserPO;
import com.commons.AppStateStore;
import com.controller.UserController;
import com.model.UserModel;
import com.service.UserService;
import com.utils.Msg;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;
	
	@Resource(name = "appStateStore")
	private AppStateStore appStateStore;
	
	
	
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			//employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			//employeeService.deleteEmp(id);
		}
		return Msg.success();
	}

	@RequestMapping("/findAll")
	public List<UserPO> findAll(@RequestBody UserModel userModel) {
		List<UserPO> userList = userService.findAll(userModel);
		return userList;

	}

	@Override
	@RequestMapping(value="/save", method = RequestMethod.POST)  
	public UserPO save(@RequestBody UserPO userPO) {
		UserPO save=userService.save(userPO);
		return save;
	}

	@Override
	@RequestMapping(value="/login", method = RequestMethod.POST)  
	public UserPO login(@RequestBody UserModel userModel) {
		//从sion中获取验证码
	String randomCode=	(String) appStateStore.getAttribute("randomCode");
		
	//userModel.
	
	
		
		return null;
	}

}
