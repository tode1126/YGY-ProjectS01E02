package Client.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Service {

	@RequestMapping("/client/service.do")
	public String form1(Model model)
	{
		model.addAttribute("menu", "취소");
		return "/client/clientService/clientcancle";
	}
	
	@RequestMapping("/client/cancle.do")
	public String form2(Model model)
	{
		model.addAttribute("menu", "취소");
		return "/client/clientService/clientcancle";
	}
	
	@RequestMapping("/client/order.do")
	public String form3(Model model)
	{
		model.addAttribute("menu", "주문/결제");
		return "/client/clientService/clientorder";
	}
	
}
