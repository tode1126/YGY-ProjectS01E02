package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
	
	@RequestMapping("/company/companyIntro.do")
	public String companyIntro()
	{
		return "/main/company/companyIntro";
	}
	
	@RequestMapping("/company/terms.do")
	public String terms()
	{
		return "/main/company/terms";
	}
	
	@RequestMapping("/company/privacy.do")
	public String privacy()
	{
		return "/main/company/privacy";
	}
	
	@RequestMapping("/company/notice.do")
	public String notice()
	{
		return "/main/company/notice";
	}
}
