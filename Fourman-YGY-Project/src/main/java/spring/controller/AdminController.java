package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
import spring.data.UserDto;
import spring.data.UserSearchDto;
import spring.service.AdminService;

@Controller
public class AdminController {
	// 메일 전송
	@Autowired
	private JavaMailSender mailSender;

	// 필요한 관리자서비스 가져오기 위해
	@Autowired
	private AdminService service;

	// 유저관리
	@RequestMapping("/admin/userManagement/{pageName}/userDisable.do")
	public String userDisable(@RequestParam String targetEmail, HttpServletRequest request,
			@RequestParam(defaultValue = "1") String pageNum, @PathVariable("pageName") String pageName) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");

		if (service.adminCheck(dto.getUser_Email()) > 0 && service.userSelectCount(targetEmail) > 0)
			service.userDisable(targetEmail);

		return "redirect:/admin/userManagement/" + pageName + ".do?pageNum=" + pageNum;
	}

	@RequestMapping("/admin/userManagement/{pageName}/userMultiDisable.do")
	public String userMultiDisable(HttpServletRequest request, @RequestParam(defaultValue = "1") String pageNum,
			@PathVariable("pageName") String pageName) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");
		String[] targetEmails = request.getParameterValues("multipleAction");

		if (service.adminCheck(dto.getUser_Email()) > 0 && targetEmails != null) {
			for (String targetEmail : targetEmails) {
				if (service.userSelectCount(targetEmail) > 0) {
					service.userDisable(targetEmail);
				}
			}
		}

		return "redirect:/admin/userManagement/" + pageName + ".do?pageNum=" + pageNum;
	}

	@RequestMapping("/admin/userManagement/{pageName}/userEnable.do")
	public String userEnable(@RequestParam String targetEmail, HttpServletRequest request,
			@RequestParam(defaultValue = "1") String pageNum, @PathVariable("pageName") String pageName) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");
		
		if (service.adminCheck(dto.getUser_Email()) > 0 && service.userSelectCount(targetEmail) > 0)
			service.userEnable(targetEmail);

		return "redirect:/admin/userManagement/" + pageName + ".do?pageNum=" + pageNum;
	}

	@RequestMapping("/admin/userManagement/{pageName}/userMultiEnable.do")
	public String userMultiEnable(HttpServletRequest request, @RequestParam(defaultValue = "1") String pageNum,
			@PathVariable("pageName") String pageName) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");
		String[] targetEmails = request.getParameterValues("multipleAction");

		if (service.adminCheck(dto.getUser_Email()) > 0 && targetEmails != null) {
			for (String targetEmail : targetEmails) {
				if (service.userSelectCount(targetEmail) > 0) {
					service.userEnable(targetEmail);
				}
			}
		}

		return "redirect:/admin/userManagement/" + pageName + ".do?pageNum=" + pageNum;
	}

	// 전체 유저 목록
	@RequestMapping("/admin/userManagement/allUserList.do")
	public ModelAndView allUserList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.allUserTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.allUserTotalCount();
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
			List<UserDto> list = service.allUserList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/allUserList");
		return model;
	}

	// 탈퇴유저 목록
	@RequestMapping("/admin/userManagement/leaveUserList.do")
	public ModelAndView leaveUserList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.leaveUserTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.leaveUserTotalCount();
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
			List<UserDto> list = service.leaveUserList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/leaveUserList");
		return model;
	}

	// 기업회원 목록
	@RequestMapping("/admin/userManagement/allFoodUserList.do")
	public ModelAndView allFoodUserList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.allFoodUserTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.allFoodUserTotalCount();
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
			List<UserDto> list = service.allFoodUserList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/allFoodUserList");
		return model;
	}

	// 탈퇴 기업회원 목록
	@RequestMapping("/admin/userManagement/leaveFoodUserList.do")
	public ModelAndView leaveFoodUserList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.leaveFoodUserTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.leaveFoodUserTotalCount();
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
			List<UserDto> list = service.leaveFoodUserList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/leaveFoodUserList");
		return model;
	}

	// 관리자 회원 목록
	@RequestMapping("/admin/adminManagement/adminList.do")
	public ModelAndView adminList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.adminListTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.adminListTotalCount();
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
			List<UserDto> list = service.adminList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/adminManagement/adminList");
		return model;
	}

	// 관리자 추가
	@RequestMapping("/admin/adminManagement/adminUpdate.do")
	public String adminUpdate(@RequestParam String targetEmail, HttpServletRequest request,
			@RequestParam(defaultValue = "1") String pageNum) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");

		if (service.adminCheck(dto.getUser_Email()) > 0 && service.userSelectCount(targetEmail) > 0)
			service.adminUpdate(targetEmail);

		return "redirect:/admin/adminManagement/adminList.do?pageNum=" + pageNum;
	}

	// 일반회원으로 전환
	@RequestMapping("/admin/adminManagement/userUpdate.do")
	public String userUpdate(@RequestParam String targetEmail, HttpServletRequest request,
			@RequestParam(defaultValue = "1") String pageNum) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");

		if (service.adminCheck(dto.getUser_Email()) > 0 && service.userSelectCount(targetEmail) > 0)
			service.userUpdate(targetEmail);

		return "redirect:/admin/adminManagement/adminList.do?pageNum=" + pageNum;
	}

	@RequestMapping("/admin/mailService/allMailSend.do")
	public String allMailSend() {
		return "/admin/mailService/allMailSend";
	}

	// 일괄메일 서비스
	@RequestMapping("/admin/mailService/allMailSendAction.do")
	public String userSearchAction(@RequestParam int target, @RequestParam String editor, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");
		String go = "redirect:/admin/mailService/allMailSend.do?sendFalse=true";

		if (service.adminCheck(dto.getUser_Email()) > 0) {
			List<UserDto> list = service.mailGetList(target);
			for (UserDto udto : list) {
				MimeMessage message = mailSender.createMimeMessage();
				try {
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
					messageHelper.setSubject("여기요 서비스 입니다");// 메일 제목
					messageHelper.setText("<html><body>" + editor + "</body></html>", true);// 메일내용
					message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(udto.getEmail()));
					mailSender.send(message);
				} catch (Exception e) {
					System.out.println("메일 보내기 오류:" + e.getMessage());
				}

			}
			go = "redirect:/admin/mailService/allMailSend.do?send=true";
		}
		return go;
	}

	// 실시간 유저 카운트
	@RequestMapping("/admin/userCount.do")
	@ResponseBody
	public Map<Object, Object> userCount() {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		LoginManager manager = new LoginManager();

		count = manager.getUserCount();
		map.put("cnt", count);
		return map;
	}

	// 실시간 유저 목록
	@RequestMapping("/admin/userList.do")
	@ResponseBody
	public Map<Object, Object> userList() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		LoginManager manager = new LoginManager();
		List<String> list = manager.getUsersList();

		map.put("userList", list);
		return map;
	}

	// 실시간 유저 목록 접속 해제
	@RequestMapping("/admin/userUnConnection.do")
	@ResponseBody
	public void userUnConnection(@RequestBody String email) {
		LoginManager manager = new LoginManager();
		if (manager.isUsing(email)) {
			manager.removeSession(email);
		}
		return;
	}

	// 유저 목록 검색
	@RequestMapping("/admin/userManagement/searchUser.do")
	public ModelAndView searchUser(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "1") String targetEmail) {
		ModelAndView model = new ModelAndView();
		UserSearchDto USDto = new UserSearchDto();
		if (service.searchUserTotalCount(targetEmail) > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.searchUserTotalCount(targetEmail);
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
			USDto.setTargetEmail(targetEmail);
			USDto.setPerPage(perPage);
			USDto.setNo((currentPage - 1) * perPage);

			List<UserDto> list = service.searchUser(USDto);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/allUserList");
		return model;
	}

	// 기업유저 검색
	@RequestMapping("/admin/userManagement/searchFoodUser.do")
	public ModelAndView searchFoodUserCount(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "1") String targetEmail) {
		ModelAndView model = new ModelAndView();
		UserSearchDto USDto = new UserSearchDto();
		if (service.searchFoodUserTotalCount(targetEmail) > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.searchFoodUserTotalCount(targetEmail);
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
			USDto.setTargetEmail(targetEmail);
			USDto.setPerPage(perPage);
			USDto.setNo((currentPage - 1) * perPage);
			List<UserDto> list = service.searchFoodUser(USDto);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/allFoodUserList");
		return model;
	}

	// 탈퇴기업유저 검색
	@RequestMapping("/admin/userManagement/searchLeaveFoodUser.do")
	public ModelAndView searchLeaveFoodUser(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "1") String targetEmail) {
		ModelAndView model = new ModelAndView();
		UserSearchDto USDto = new UserSearchDto();
		if (service.searchLeaveFoodUserTotalCount(targetEmail) > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.searchLeaveFoodUserTotalCount(targetEmail);
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
			USDto.setTargetEmail(targetEmail);
			USDto.setPerPage(perPage);
			USDto.setNo((currentPage - 1) * perPage);
			List<UserDto> list = service.searchLeaveFoodUser(USDto);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/leaveFoodUserList");
		return model;
	}

	// 탈퇴 유저 검색
	@RequestMapping("/admin/userManagement/searchLeaveUser.do")
	public ModelAndView searchLeaveUser(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "1") String targetEmail) {
		ModelAndView model = new ModelAndView();
		UserSearchDto USDto = new UserSearchDto();
		if (service.searchLeaveUserTotalCount(targetEmail) > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.searchLeaveUserTotalCount(targetEmail);
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
			USDto.setTargetEmail(targetEmail);
			USDto.setPerPage(perPage);
			USDto.setNo((currentPage - 1) * perPage);
			List<UserDto> list = service.searchLeaveUser(USDto);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/userManagement/leaveUserList");
		return model;
	}

	// 식당 리스트
	@RequestMapping("/admin/foodManagement/allFoodList.do")
	public ModelAndView allFoodList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.allFoodTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.allFoodTotalCount();
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
			List<UserDto> list =new ArrayList<UserDto>(); 
			//service.allFoodList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/foodManagement/allFoodList");
		return model;
	}

	@RequestMapping("/admin/foodManagement/leaveFoodList.do")
	public ModelAndView leaveFoodList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		if (service.leaveFoodTotalCount() > 0) {
			int totalCount;// 전체갯수

			int totalPage; // 총페이지
			int startNum;// 각페이지의시작번호
			int endNum;// 각페이지의끝번호
			int startPage; // 블럭의 시작페이지
			int endPage;// 블럭의 끝페이지
			int no;// 출력할 시작번호
			int perPage = 10;// 한페이지당 보여질 글의갯수
			int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

			totalCount = service.leaveFoodTotalCount();
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
			List<UserDto> list =new ArrayList<UserDto>(); 
			//service.allFoodList(perPage, (currentPage - 1) * perPage);

			// 가져온 리스트 model에 저장
			model.addObject("list", list);
			model.addObject("totalCount", totalCount);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);
		}
		model.setViewName("/admin/foodManagement/leaveFoodList");
		return model;
	}
	
	// 식당 상태 변경
	@RequestMapping("/admin/foodManagement/foodStateChange.do")
	public String foodStateChange(@RequestParam int rest_pk, @RequestParam String changeVal,
			HttpServletRequest request, @RequestParam(defaultValue = "1") String pageNum) {
		HttpSession session = request.getSession();
		LoginDto dto = (LoginDto) session.getAttribute("userLoginInfo");
		// food dto 오면 dto 선언해서 값넣기

		if (service.adminCheck(dto.getUser_Email()) > 0 && service.selectRestaurantCount(rest_pk)>0)
		{
			if (changeVal.equals("2")) {
				service.foodLeaveChange();
			} else {
				service.foodStateChange();
			}
		}

		return "redirect:/admin/foodManagement/allFoodList.do?pageNum=" + pageNum;
	}

	//식당 검색기능

		@RequestMapping("/admin/foodManagement/searchAllFoodList.do")
		public ModelAndView searchAllFoodList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage, @RequestParam(defaultValue = "1") String targetEmail) {
			ModelAndView model = new ModelAndView();

			if (service.searchAllFoodTotalCount() > 0) {
				int totalCount;// 전체갯수

				int totalPage; // 총페이지
				int startNum;// 각페이지의시작번호
				int endNum;// 각페이지의끝번호
				int startPage; // 블럭의 시작페이지
				int endPage;// 블럭의 끝페이지
				int no;// 출력할 시작번호
				int perPage = 10;// 한페이지당 보여질 글의갯수
				int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

				totalCount = service.searchAllFoodTotalCount();
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
				List<UserDto> list =new ArrayList<UserDto>(); 
				//service.allFoodList(perPage, (currentPage - 1) * perPage);

				// 가져온 리스트 model에 저장
				model.addObject("list", list);
				model.addObject("totalCount", totalCount);
				model.addObject("currentPage", currentPage);
				model.addObject("startPage", startPage);
				model.addObject("endPage", endPage);
				model.addObject("no", no);
				model.addObject("totalPage", totalPage);
			}
			model.setViewName("/admin/foodManagement/allFoodList");
			return model;
		}

		@RequestMapping("/admin/foodManagement/searchLeaveFoodList.do")
		public ModelAndView searchLeaveFoodList(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage, @RequestParam(defaultValue = "1") String targetEmail) {
			ModelAndView model = new ModelAndView();

			if (service.searchLeaveFoodTotalCount() > 0) {
				int totalCount;// 전체갯수

				int totalPage; // 총페이지
				int startNum;// 각페이지의시작번호
				int endNum;// 각페이지의끝번호
				int startPage; // 블럭의 시작페이지
				int endPage;// 블럭의 끝페이지
				int no;// 출력할 시작번호
				int perPage = 10;// 한페이지당 보여질 글의갯수
				int perBlock = 5;// 한블럭당 보여질 페이지의 갯수

				totalCount = service.searchLeaveFoodTotalCount();
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
				List<UserDto> list =new ArrayList<UserDto>(); 
				//service.allFoodList(perPage, (currentPage - 1) * perPage);

				// 가져온 리스트 model에 저장
				model.addObject("list", list);
				model.addObject("totalCount", totalCount);
				model.addObject("currentPage", currentPage);
				model.addObject("startPage", startPage);
				model.addObject("endPage", endPage);
				model.addObject("no", no);
				model.addObject("totalPage", totalPage);
			}
			model.setViewName("/admin/foodManagement/leaveFoodList");
			return model;
		}
}
