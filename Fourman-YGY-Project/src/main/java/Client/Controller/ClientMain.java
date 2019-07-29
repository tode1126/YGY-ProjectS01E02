package Client.Controller;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientMain {

	@RequestMapping("/client/main/list.do")
	public String form(Model model)
	{
		model.addAttribute("menu", "고객센터");
		return "clientMain.tiles";
	}
	
}
