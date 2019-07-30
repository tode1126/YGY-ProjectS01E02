package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.data.Reboard_AnswerDto;
import spring.service.Reboard_AnswerService;

@Controller
public class Reboard_AnswerController {

	@Autowired
	private Reboard_AnswerService service;
	
	@RequestMapping("/reboard/boardAnswerInsert.do")
	public String boardAnswerInsert(@ModelAttribute Reboard_AnswerDto dto, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		service.boardAnswerInsert(dto);
		return "redirect:/reboard/reboardListSelectContent.do?reboard_pk="+dto.getReboard_reboard_pk()+"&pageNum="+pageNum;
	}
	
	@RequestMapping("/reboard/boardAnswerDelete.do")
	public String boardAnswerDelete(@ModelAttribute Reboard_AnswerDto dto, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		service.boardAnswerDelete(dto.getAnswer_pk());
		return "redirect:/reboard/reboardListSelectContent.do?reboard_pk="+dto.getReboard_reboard_pk()+"&pageNum="+pageNum;
	}
}
