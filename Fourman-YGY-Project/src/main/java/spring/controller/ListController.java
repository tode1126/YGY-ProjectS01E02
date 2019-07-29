package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	
	@RequestMapping("/company/outline.do")
	public String outline()
	{
		return "/main/company/outline";
	}
	
	@RequestMapping("/company/vision.do")
	public String vision()
	{
		return "/main/company/vision";
	}
	
	@RequestMapping("/company/benefit.do")
	public String benefit()
	{
		return "/main/company/benefit";
	}
	
	@RequestMapping("/company/place.do")
	public String place()
	{
		return "/main/company/place";
	}
}
