package Client.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.data.noticeDto;
import spring.service.noticeservice;

@Controller
public class notice {
	@Autowired
	private noticeservice service;
	
	@RequestMapping("/notice/noticemain.do")
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView();
		int totalCount;
		
		totalCount = service.getTotalNoticeCount();
		
		model.addObject("totalCount",totalCount);
		model.addObject("menu","공지사항");
		model.setViewName("/client/clientnotice/noticemain");
		return model;		
	}
	
	@RequestMapping("/notice/noticeWriteForm.do")
	public String noticeform(Model model)
	{
		model.addAttribute("admin", "관리자");
		return "/client/clientnotice/noticewriteform";
	}
   
	@RequestMapping(value="/notice/noticeWrite.do",method=RequestMethod.POST)
	public String readData(@ModelAttribute noticeDto ndto)
	{
		service.insertNotice(ndto);
		//목록으로 이동
		return "redirect:noticemain.do";
	}
}
