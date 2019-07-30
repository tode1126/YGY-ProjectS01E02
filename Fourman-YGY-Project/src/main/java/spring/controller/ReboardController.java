package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.data.ReboardDto;
import spring.data.Reboard_AnswerDto;
import spring.service.ReboardService;
import spring.service.Reboard_AnswerService;

@Controller
public class ReboardController {

	@Autowired
	private ReboardService service;

	@Autowired
	private Reboard_AnswerService raservice;

	@RequestMapping("/reboard/reboardList.do")
	public ModelAndView reboardList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.reboardListTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.reboardListTotalCount();
			// 총페이지의 갯수
			totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);

			// 존재하지않는페이지인경우
			if (totalPage < currentPage)
				currentPage = totalPage;

			// 각 블럭의 시작페이지와 끝 페이지를 구한다
			startPage = ((currentPage - 1) / perBlock) * perBlock + 1;
			endPage = startPage + perBlock - 1;
			// ex)13페이지있을경우 15까지 불러와버리므로
			if (endPage > totalPage)
				endPage = totalPage;

			// 각페이지의 시작번호와 끝번호를 구한다
			// perpage가 5일경우
			// 1페이지 1, 5 3페이지 11, 15
			startNum = (currentPage - 1) * perPage + 1;
			endNum = startNum + perPage - 1;
			if (endNum > totalCount)
				endNum = totalCount;

			// 각 페이지마다 출력할 시작번호
			// 총페이지가 30일경우 1페이지는 30 2페이지는 25...
			no = totalCount - (currentPage - 1) * perPage;

			// 리스트 가져오기
			List<ReboardDto> list = service.reboardList(perPage, (currentPage - 1) * perPage);
			
			for(ReboardDto dto : list)
			{
				dto.setAnswerCount(raservice.boardAnswerGetCount(dto.getReboard_pk()));
			}

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/main/reboard/reboardList");
		return model;
	}

	@RequestMapping("/reboard/reboardInsert.do")
	public String reboardListInsert(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum) {

		int reboard_pk, groupno, restep, relevel;
		try {
			reboard_pk = Integer.parseInt(request.getParameter("reboard_pk"));
			groupno = Integer.parseInt(request.getParameter("groupno"));
			restep = Integer.parseInt(request.getParameter("restep"));
			relevel = Integer.parseInt(request.getParameter("relevel"));
		} catch (NumberFormatException e) {
			reboard_pk = groupno = restep = relevel = 0;
		}

		ReboardDto dto = new ReboardDto();
		dto.setReboard_pk(reboard_pk);
		dto.setGroupno(groupno);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		dto.setUser_info_email(request.getParameter("user_info_email"));
		dto.setUser_info_nickname(request.getParameter("user_info_nickname"));
		dto.setReboard_subject(request.getParameter("reboard_subject"));
		dto.setReboard_content(request.getParameter("reboard_content"));
		dto.setReboard_rating(Float.parseFloat(request.getParameter("reboard_rating")));

		service.reboardListInsert(dto);

		return "redirect:/reboard/reboardList.do?pageNum=" + pageNum;
	}

	@RequestMapping("/reboard/reboardform.do")
	public ModelAndView reboardform(@RequestParam(defaultValue = "1") int pageNum, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();

		String reboard_pk = request.getParameter("reboard_pk");
		String groupno = request.getParameter("groupno");
		String restep = request.getParameter("restep");
		String relevel = request.getParameter("relevel");

		if (reboard_pk == null) {// 답글인경우
			reboard_pk = "0";
		}

		model.addObject("groupno", groupno);
		model.addObject("restep", restep);
		model.addObject("relevel", relevel);
		model.addObject("reboard_pk", reboard_pk);
		model.addObject("pageNum", pageNum);
		model.setViewName("/main/reboard/reboardform");
		return model;
	}

	@RequestMapping("/reboard/reboardListSelectContent.do")
	public ModelAndView reboardListSelectContent(@RequestParam int reboard_pk,
			@RequestParam(defaultValue = "1") String pageNum) {
		ModelAndView model = new ModelAndView();
		String go = "main.tiles";
		ReboardDto dto = new ReboardDto();
		List<Reboard_AnswerDto> ralist = new ArrayList<Reboard_AnswerDto>();

		if (service.reboardListSelectCount(reboard_pk) > 0) {
			service.reboardListUpdateReadCount(reboard_pk);
			dto = service.reboardListSelectContent(reboard_pk);
			ralist = raservice.boardAnswerGetData(reboard_pk);
			model.addObject("dto", dto);
			model.addObject("ralist", ralist);
			if(dto.getState() != 1)
				go = "/main/reboard/reboardcontent";
		}

		model.setViewName(go);
		return model;
	}
	
	@RequestMapping("/reboard/reboardListUpdateform.do")
	public String reboardListUpdateForm(Model model, @RequestParam(defaultValue="1") int pageNum, @RequestParam int reboard_pk) {
		
		ReboardDto dto = service.reboardListSelectContent(reboard_pk);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		
		return "/main/reboard/reboardupdate";
	}

	
	@RequestMapping("/reboard/reboardListUpdate.do")
	public String reboardListUpdate(HttpServletRequest request) {
		ReboardDto dto = new ReboardDto();
		//입력자료 읽기
		int reboard_pk=0;
		try {
			reboard_pk=Integer.parseInt(request.getParameter("reboard_pk"));
		}catch(NumberFormatException e) {
			System.out.println("num에러"+e.getMessage());
		}
		String reboard_subject=request.getParameter("reboard_subject");
		String reboard_content=request.getParameter("reboard_content");
		float reboard_rating=Float.parseFloat(request.getParameter("reboard_rating"));

		
		if(reboard_pk>0)
			dto = service.reboardListSelectContent(reboard_pk);
		
		dto.setReboard_subject(reboard_subject);
		dto.setReboard_content(reboard_content);
		dto.setReboard_rating(reboard_rating);

		//update
		service.reboardListUpdate(dto);
		
		String pageNum=request.getParameter("pageNum");
		return "redirect:/reboard/reboardListSelectContent.do?reboard_pk="+dto.getReboard_pk()+"&pageNum="+pageNum;
	}

	@RequestMapping("/reboard/reboardListDelete.do")
	public String reboardListDelete(@RequestParam int reboard_pk,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		if (service.reboardListDeleteCount(service.reboardListSelectContent(reboard_pk).getGroupno()) == 1) {
			service.reboardListDelete(reboard_pk);
		} else {
			service.reboardListDeleteUpdate(reboard_pk);
		}
		return "redirect:/reboard/reboardList.do?pageNum=" + pageNum;
	}

	@RequestMapping("/reboard/happy.do")
	@ResponseBody
	public Map<Object, Object> reboard_happy(@RequestBody String reboard_pk) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		service.reboardListHappyUpdate(Integer.parseInt(reboard_pk));
		count = service.reboardListHappySelect(Integer.parseInt(reboard_pk));
		map.put("cnt", count);
		return map;
	}

	@RequestMapping("/reboard/unhappy.do")
	@ResponseBody
	public Map<Object, Object> reboard_unhappy(@RequestBody String reboard_pk) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		service.reboardListUnHappyUpdate(Integer.parseInt(reboard_pk));
		count = service.reboardListUnHappySelect(Integer.parseInt(reboard_pk));
		map.put("cnt", count);
		return map;
	}

}
