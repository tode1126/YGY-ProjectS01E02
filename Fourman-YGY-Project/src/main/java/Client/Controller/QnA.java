package Client.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
import spring.data.QnADto;
import spring.service.QnAService;
import spring.service.UserService;

@Controller
public class QnA {
	@Autowired
	private QnAService service;

	@Autowired
	private UserService Uservice;

	@RequestMapping("/question/questionList.do")
	public ModelAndView qna_boardList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");

		if (ldto != null) {
			if (service.qna_boardListSelectTotalCount(ldto.getUser_Email()) > 0) {
				int totalCount;// 전체갯수

				int totalPage; // 총페이지
				int startNum;// 각페이지의시작번호
				int endNum;// 각페이지의끝번호
				int startPage; // 블럭의 시작페이지
				int endPage;// 블럭의 끝페이지
				int no;// 출력할 시작번호
				int perPage = 10;// 한페이지당 보여질 글의갯수
				int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

				totalCount = service.qna_boardListSelectTotalCount(ldto.getUser_Email());
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
				List<QnADto> list = service.qna_boardSelectList(ldto.getUser_Email(), perPage,
						(currentPage - 1) * perPage);

				// 가져온 리스트 model에 저장
				model.addObject("list", list);
				model.addObject("totalCount", totalCount);
				model.addObject("currentPage", currentPage);
				model.addObject("startPage", startPage);
				model.addObject("endPage", endPage);
				model.addObject("no", no);
				model.addObject("totalPage", totalPage);
			}
		}
		model.setViewName("/client/clientQnA/QnAList");
		return model;
	}

	@RequestMapping(value = "/question/questionWrite.do")
	public String questionWrite(Model model, @RequestParam(defaultValue = "1") int pageNum,
			HttpServletRequest request) {
		model.addAttribute("pageNum", pageNum);
		HttpSession session = request.getSession();
		LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
		String go = "main.tiles";
		if (ldto != null) {
			model.addAttribute("qna_writer", ldto.getUser_Email());
			go = "/client/clientQnA/QnAWriteForm";
		}
		return go;
	}

	@RequestMapping(value = "/question/questionWriteAction.do", method = RequestMethod.POST)
	public String questionWriteAction(HttpServletRequest request, @ModelAttribute QnADto qdto,
			@RequestParam(defaultValue = "1") int pageNum) {
		HttpSession session = request.getSession();
		LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
		String go = "main.tiles";
		if (ldto != null) {
			if (Uservice.userSelectCount(ldto.getUser_Email()) > 0) {
				qdto.setQna_writer(ldto.getUser_Email());
				service.qna_boardListInsert(qdto);
				go = "redirect:/question/questionList.do?pageNum=" + pageNum;
			}
		}
		return go;
	}

	@RequestMapping("/question/questionContent.do")
	public ModelAndView qna_boardListContent(HttpServletRequest request, @RequestParam int qna_pk,
			@RequestParam(defaultValue = "1") String pageNum) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
		String go = "main.tiles";
		if (ldto != null) {
			if (Uservice.userSelectCount(ldto.getUser_Email()) > 0 && service.qna_boardListSelectCount(qna_pk) > 0) {
				QnADto dto = service.qna_boardListSelectContent(qna_pk);
				model.addObject("dto", dto);
				go = "/client/clientQnA/QnAContent";
			}
		}
		model.setViewName(go);
		return model;
	}
}
