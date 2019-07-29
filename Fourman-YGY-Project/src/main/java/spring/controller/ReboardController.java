package spring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.data.ReboardDto;
import spring.service.ReboardService;


@Controller
public class ReboardController {
	
	@Autowired
	private ReboardService service;
	
	@RequestMapping("/reboard/reboardlist.do")
	public ModelAndView list(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage)
	{
		ModelAndView model=new ModelAndView();
		int totalCount;
		totalCount=service.getTotalCount();
		//페이징 복사한거
		//페이징처리에 필요한 변수들 선언
		int totalPage; //총 페이지수
		int startNum; //각페이지의시작번호
		int endNum; //각페이지의끝번호
		int startPage; //블럭의 시작페이지
		int endPage; //블럭의 끝페이지
		int no;//출력할 시작번호
		int perPage=10;//한페이지당 보여질 글의갯수
		int perBlock=10;//한블럭당 보여질 페이지의 갯수

		//총페이수를 구한다
		totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);

		//존재하지 않는 페이지일경우 마지막 페이지로 가기
		if(currentPage>totalPage)
			currentPage=totalPage;

		//각 블럭의 시작페이지와 끝페이지를 구한다
		//perBlock 이 5일경우
		//예) 현재페이지가 3 일경우 시작페이지:1,끝페이지:5
		//예) 현재페이지가 7 일경우 시작페이지:6,끝페이지:10
		//예) 현재페이지가 11 일경우 시작페이지:11,끝페이지:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		//마지막 블럭은 끝페이지가 총 페이지수와 같아야함
		if(endPage>totalPage)
			endPage=totalPage;

		//각 페이지의 시작번호와 끝번호를 구한다
		//perPage 가 5일경우
		//예) 1페이지 : 시작번호 : 1, 끝번호:5
		//    3페이지 :           11        15
		//startNum=(currentPage-1)*perPage+1;
		startNum=(currentPage-1)*perPage;
		endNum=startNum+perPage-1;
		//마지막 페이지의 글번호 체크하기
		if(endNum>totalCount)
			endNum=totalCount;

		//각 페이지마다 출력할 시작번호
		//총갯수가 30일경우 1페이지는 30,2페이지는 25....
		no=totalCount-(currentPage-1)*perPage;		

		//2. 리스트 가져오기
		List<ReboardDto> list=service.getList(startNum, perBlock);
		
		//3. 페이징에 필요한 변수들 request에 저장		
		model.addObject("list", list);
		model.addObject("currentPage", currentPage);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("no", no);
		model.addObject("totalPage", totalPage);
		
		model.addObject("totalCount",totalCount);
		model.setViewName("/main/reboard/reboardlist");	
		return model;
	}
	
	@RequestMapping("/reboard/reboardform.do")
	public String form()
	{
		return "/main/reboard/reboardform";
	}
	
	@RequestMapping(value="/reboard/write.do",method=RequestMethod.POST)
	public String readData(@ModelAttribute ReboardDto dto )
	{
		service.insertReboard(dto);
		return "redirect:/reboard/reboardlist.do";
	}
	
	@RequestMapping("/reboard/content.do")
	public String content(Model model, @RequestParam int num,
			@RequestParam int pageNum)
	{
		//조회 1 증가
		service.updateReadCount(num);
		ReboardDto dto=service.getData(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		return "/main/reboard/reboardcontent";
	}
	
	@RequestMapping("/reboard/reboardupdate.do")
	public ModelAndView updateForm(@RequestParam int num,
			@RequestParam int pageNum)
	{
		ModelAndView model=new ModelAndView();
		ReboardDto dto=service.getData(num);
		model.addObject("dto",dto);
		model.addObject("pageNum",pageNum);
		model.setViewName("/main/reboard/reboardupdate");
		return model;
	}
	
	@RequestMapping(value="/reboard/update.do",method=RequestMethod.POST)
	public String update(@ModelAttribute ReboardDto dto,
			@RequestParam String pageNum)
	{
		service.reboardUpdate(dto);
		return "redirect:content.do?num="+dto.getReboard_pk()+"&pageNum="+pageNum;
	}
	
	@RequestMapping("/reboard/delete.do")
	public String delete(@RequestParam int num,
			@RequestParam String pageNum)
	{
		service.reboardDelete(num);
		return "redirect:reboardlist.do?pageNum="+pageNum;
	}
	
	@RequestMapping("/reboard/happy.aj")
	public @ResponseBody String reboard_happy(@RequestParam int num,Model model)
	{
		//System.out.println("happy num="+num);
		service.reboardHappyUpdate(num);
		int reboard_happy=service.getSelectHappy(num);
		System.out.println("reboard_happy: "+reboard_happy);
		
//		ModelAndView model=new ModelAndView();
//		model.addObject("reboard_happy",reboard_happy);
//		model.setViewName("/main/reboard/happydata");
		//model.addAttribute("reboard_happy", reboard_happy);
		//return "/main/reboard/happydata";
		//HashMap<String, Integer> map=new HashMap<String, Integer>();
		//map.put("reboard_happy", reboard_happy);
		return "{\"reboard_happy\":"+reboard_happy+"}";
	}
}
