package demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.dao.UserMapper;
import demo.entity.User;
import demo.service.UserI;

@Controller
public class ShowUser {
	@Inject
	private UserI ui;
	@Inject
	UserMapper um;
	
	Map<String, Object> map= new HashMap<String, Object>();
	
	@RequestMapping(value="/Use", method = RequestMethod.GET)
	public String show(Model ml) {
		User u = ui.getUser(1);
		User u1 = ui.getUser(5);
		User u2 = ui.getUser(52);
		System.out.println(u1.getName());
		map.put("User", u);
		map.put("Us", u1);
		map.put("User2", u2);
		ml.addAttribute("Users", map);
		return "index01";
	}
	@RequestMapping({"/User", "/"})
	public String showU() {
//		User u = ui.getUser(1);
//		ml.addAttribute("User", 5);
		System.out.println("skdfjlsakj");
		return "NewFile";
	}
	@RequestMapping({"/index", "/"})
	public @ResponseBody Map<String, Object> showName(Map<String, Object> map) {
		map.put("name", "hell");
		return map;
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model ml) {
		ml.addAttribute(new User());
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(User user) {
		um.insertSelective(user);
		map.put(user.getName(), user);
		return "redirect:Use";
	}
}
