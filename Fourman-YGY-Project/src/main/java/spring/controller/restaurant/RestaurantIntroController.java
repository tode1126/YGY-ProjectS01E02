package spring.controller.restaurant;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.data.restaurant.RestaurantIntroDto;
import spring.data.restaurant.RestaurantIntroImageDto;
import spring.data.restaurant.RestaurantMenuDto;
import spring.service.restaurant.RestaurantService;
import upload.util.SpringFileWriter;

@Controller
public class RestaurantIntroController {
	
	@Autowired
	public RestaurantService service;
	
	/*** 식당 소개 관련 컨트롤러*/
	@RequestMapping(value="/restaurant/introFront.do")
	public ModelAndView introFront(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		int restaurant_rest_pk = -1;
		int isRestaurantIntro = -1;
		int isRestaurantIntroImage = -1;
		String intro_text = "";
		List<RestaurantIntroImageDto> imageList = null;
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introFront.do: "+restaurant_rest_pk);
			isRestaurantIntro = service.selectIsRestaurantIntro(restaurant_rest_pk);
			System.out.println(isRestaurantIntro);
			if(isRestaurantIntro!=0) {
				intro_text = service.selectOneRestaurantIntro(restaurant_rest_pk).getIntro_text();
				intro_text = intro_text.replace("\n", "<br>");
			}
			isRestaurantIntroImage = service.selectIsRestaurantIntroImage(restaurant_rest_pk);
			System.out.println("isRestaurantIntroImage: "+isRestaurantIntroImage);
			if(isRestaurantIntroImage!=0) {
				imageList = service.selectListRestaurantIntroImage(restaurant_rest_pk);
				for (RestaurantIntroImageDto dto : imageList) {
					System.out.println("dto rest_pk:"+dto.getRestaurant_rest_pk());
					System.out.println("dto image:"+dto.getRestaurant_intro_image());
				}
			}
		} else {
			model.setViewName("redirect:/restaurant/main.do");
			return model;
		}
		model.addObject("isRestaurantIntro", isRestaurantIntro);
		model.addObject("intro_text", intro_text);
		model.addObject("imageList", imageList);
		model.setViewName("/restaurant/intro/introFront");
		return model;
	}
	
	@RequestMapping("/restaurant/introAddForm.do")
	public ModelAndView introAddForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		if(isRest_pk) {
			int restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introAddForm.do: "+restaurant_rest_pk);
			model.addObject("restaurant_rest_pk", restaurant_rest_pk);
		}
		model.setViewName("/restaurant/intro/introInsertForm");
		return model;
	}
	@RequestMapping(value="/restaurant/introAdd.do", method=RequestMethod.POST)
	public String introAdd(
			@ModelAttribute RestaurantIntroDto ridto, 
			@ModelAttribute RestaurantIntroImageDto riimgdto, 
			HttpServletRequest request)
	{
		//일단 파일명이 어떻게 넣어오는지부터 확인-입력안했을시: 빈 문자열이 들어간다
		/*for (MultipartFile f : rmdto.getUpfile()) {
			System.out.println("파일명: " + f.getOriginalFilename());
		}*/
		System.out.println("ridto rest_pk: "+ridto.getRestaurant_rest_pk());
		System.out.println("ridto intro_text: "+ridto.getIntro_text());
		System.out.println("riimgdto : "+riimgdto.getRestaurant_rest_pk());
		
		// 텍스트문 먼저 처리
		service.insertRestaurantIntro(ridto);
		
		// 식당 고유값 가져오기
		HttpSession session = request.getSession();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		int restaurant_rest_pk= -1;
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("menuAddForm.do: "+restaurant_rest_pk);
		}
		
		//String Path="/home/hosting_users/tjdrn4765/tomcat/webapps/ROOT/save/restaurant/intro/"+restaurant_rest_pk
		String path = request.getSession().getServletContext().getRealPath("/save/restaurant/intro/"+restaurant_rest_pk);
		//이미지 업로드 경로 확인하기
		//식당 메뉴 업로드 경로 : /save/restaurant/menu/[식당고유값]/(이미지)
		File folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!folder.exists()) {
			try{
			    folder.mkdirs(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
	        } catch(Exception e) {
	        	e.getStackTrace();
			}        
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//이미지 업로드 경로
		System.out.println(path);
		SpringFileWriter fileWriter = new SpringFileWriter();
		
		String imagename = "";
		String realname = "";
		int size=0;
		int priority = 0;
		for (MultipartFile f : riimgdto.getUpfile()) {
			if(f.getOriginalFilename().length()==0) {
				//System.out.println("파일 등록 안함");
				imagename = "noimage";
				riimgdto.setRestaurant_intro_image(imagename);
				riimgdto.setRestaurant_intro_image_realname("");
				riimgdto.setRestaurant_intro_image_realpath("");
				riimgdto.setRestaurant_intro_image_size(0);
			} else if (f.getOriginalFilename().length()>0) {//빈문자열이 아닐 경우에만 저장
				priority++;
				imagename = f.getOriginalFilename();
				int pos = imagename.lastIndexOf( "." );
				String fileExtension = imagename.substring( pos + 1 );
				//fileExtension = fileExtension.substring(0, fileExtension.length());
				realname = UUID.randomUUID().toString()+"."+fileExtension;
				size = (int) f.getSize();
				fileWriter.writeFile(f, path, realname);
				riimgdto.setRestaurant_intro_image(imagename);
				riimgdto.setRestaurant_intro_image_realname(realname);
				riimgdto.setRestaurant_intro_image_realpath(path);
				riimgdto.setRestaurant_intro_image_size(size);
				riimgdto.setRestaurant_intro_priority(priority);
			}
			if(riimgdto.getRestaurant_intro_image().equals("noimage")) {
				imagename = "";
				riimgdto.setRestaurant_intro_image(imagename);
			} else {
				service.insertRestaurantIntroImage(riimgdto);
			}
		}
		
		return "redirect:/restaurant/introFront.do";
	}
	
	@RequestMapping("/restaurant/introTextUpdateForm.do")
	public ModelAndView introTextUpdateForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		if(isRest_pk) {
			int restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introTextUpdateForm.do: "+restaurant_rest_pk);
			RestaurantIntroDto ridto = service.selectOneRestaurantIntro(restaurant_rest_pk);
			model.addObject("ridto", ridto);
		}
		model.setViewName("/restaurant/intro/introTextUpdateForm");
		return model;
	}
	
	@RequestMapping(value="/restaurant/introTextUpdate.do", method=RequestMethod.POST)
	public String introTextUpdate(@ModelAttribute RestaurantIntroDto ridto)
	{
		System.out.println("ridto rest_pk: "+ridto.getRestaurant_rest_pk());
		System.out.println("ridto intro_text: "+ridto.getIntro_text());
		
		service.updateRestaurantIntro(ridto);
		
		return "redirect:/restaurant/introFront.do";
	}
	
	@RequestMapping("/restaurant/introImageAppendForm.do")
	public ModelAndView introImageAppendForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		if(isRest_pk) {
			int restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introImageAppendForm: "+restaurant_rest_pk);
			
			model.addObject("restaurant_rest_pk", restaurant_rest_pk);
		}
		model.setViewName("/restaurant/intro/introImageAppendForm");
		return model;
	}
	
	@RequestMapping(value="/restaurant/introImageAppend.do", method=RequestMethod.POST)
	public String introImageAppend(
			@ModelAttribute RestaurantIntroImageDto riimgdto, 
			HttpServletRequest request)
	{
		//일단 파일명이 어떻게 넣어오는지부터 확인-입력안했을시: 빈 문자열이 들어간다
		/*for (MultipartFile f : rmdto.getUpfile()) {
			System.out.println("파일명: " + f.getOriginalFilename());
		}*/
		System.out.println("riimgdto : "+riimgdto.getRestaurant_rest_pk());
		
		// 식당 고유값 가져오기
		HttpSession session = request.getSession();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		int restaurant_rest_pk= -1;
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introImageAppend.do: "+restaurant_rest_pk);
		}
		
		//String Path="/home/hosting_users/tjdrn4765/tomcat/webapps/ROOT/save/restaurant/intro/"+restaurant_rest_pk
		String path = request.getSession().getServletContext().getRealPath("/save/restaurant/intro/"+restaurant_rest_pk);
		//이미지 업로드 경로 확인하기
		//식당 메뉴 업로드 경로 : /save/restaurant/menu/[식당고유값]/(이미지)
		File folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!folder.exists()) {
			try{
			    folder.mkdirs(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
	        } catch(Exception e) {
	        	e.getStackTrace();
			}        
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//이미지 업로드 경로
		System.out.println(path);
		SpringFileWriter fileWriter = new SpringFileWriter();
		
		String imagename = "";
		String realname = "";
		int size=0;
		int priority = service.selectRestaurantIntroImageMaxPriority(restaurant_rest_pk);
		for (MultipartFile f : riimgdto.getUpfile()) {
			if(f.getOriginalFilename().length()==0) {
				//System.out.println("파일 등록 안함");
				imagename = "noimage";
				riimgdto.setRestaurant_intro_image(imagename);
				riimgdto.setRestaurant_intro_image_realname("");
				riimgdto.setRestaurant_intro_image_realpath("");
				riimgdto.setRestaurant_intro_image_size(0);
			} else if (f.getOriginalFilename().length()>0) {//빈문자열이 아닐 경우에만 저장
				priority++;
				imagename = f.getOriginalFilename();
				int pos = imagename.lastIndexOf( "." );
				String fileExtension = imagename.substring( pos + 1 );
				//fileExtension = fileExtension.substring(0, fileExtension.length());
				realname = UUID.randomUUID().toString()+"."+fileExtension;
				size = (int) f.getSize();
				fileWriter.writeFile(f, path, realname);
				riimgdto.setRestaurant_intro_image(imagename);
				riimgdto.setRestaurant_intro_image_realname(realname);
				riimgdto.setRestaurant_intro_image_realpath(path);
				riimgdto.setRestaurant_intro_image_size(size);
				riimgdto.setRestaurant_intro_priority(priority);
			}
			if(riimgdto.getRestaurant_intro_image().equals("noimage")) {
				imagename = "";
				riimgdto.setRestaurant_intro_image(imagename);
			} else {
				service.insertRestaurantIntroImage(riimgdto);
			}
		}
		
		return "redirect:/restaurant/introFront.do";
	}
	
	@RequestMapping("/restaurant/introImageDeleteForm.do")
	public ModelAndView introImageDeleteForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		if(isRest_pk) {
			int restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introImageDeleteForm: "+restaurant_rest_pk);
			
			model.addObject("rest_pk", restaurant_rest_pk);
		}
		model.setViewName("/restaurant/intro/introImageAppendForm");
		return model;
	}
	
	
}
