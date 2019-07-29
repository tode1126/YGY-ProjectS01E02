package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main.do")
	public String mainGo()
	{
		return "main.tiles";//tiles name 반환
	}
	
	@RequestMapping("/admin/admin.do")
	public String adminGo()
	{
		return "admin.tiles";//tiles name 반환
	}
	@RequestMapping("/restaurant/restraunt.do")
	public String restrauntGo()
	{
		return "restaurant.tiles";//tiles name 반환
	}
}
