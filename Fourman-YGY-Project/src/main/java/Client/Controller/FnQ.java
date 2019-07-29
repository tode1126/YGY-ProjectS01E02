package Client.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FnQ {

	@RequestMapping("/answer/main.do")
	public String form(Model model)
	{
		model.addAttribute("menu", "자주 묻는 질문");
		return "/client/clientFnQ/FnQMain";
	}
	
	@RequestMapping("/li1/main.do")
	public String form()
	{
		
		return "/client/clientFnQ/clientLi/FnQli1";
	}
	
}
