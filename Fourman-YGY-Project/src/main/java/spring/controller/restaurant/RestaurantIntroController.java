package spring.controller.restaurant;

import java.io.File;
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
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("introFront.do: "+restaurant_rest_pk);
			isRestaurantIntro = service.selectIsRestaurantIntro(restaurant_rest_pk);
			System.out.println(isRestaurantIntro);
		} else {
			model.setViewName("redirect:/main.do");
			return model;
		}
		model.addObject("isRestaurantIntro", isRestaurantIntro);
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
		model.setViewName("/restaurant/intro/intro-insert-form");
		return model;
	}
	@RequestMapping(value="/restaurant/introAdd.do", method=RequestMethod.POST)
	public String menuAdd(
			@ModelAttribute RestaurantMenuDto rmdto, 
			HttpServletRequest request)
	{
		//일단 파일명이 어떻게 넣어오는지부터 확인-입력안했을시: 빈 문자열이 들어간다
		/*for (MultipartFile f : rmdto.getUpfile()) {
			System.out.println("파일명: " + f.getOriginalFilename());
		}*/
		
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
		File Folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
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
		for (MultipartFile f : rmdto.getUpfile()) {
			//빈문자열이 아닐 경우에만 저장
			if(f.getOriginalFilename().length()>0){
				imagename += f.getOriginalFilename()+",";
				String[] st = imagename.split(".");
				System.out.println(st.length+" "+imagename);
				
				int pos = imagename.lastIndexOf( "." );
				String fileExtension = imagename.substring( pos + 1 );
				fileExtension = fileExtension.substring(0, fileExtension.length()-1);
				realname = UUID.randomUUID().toString()+"."+fileExtension;
				size = (int) f.getSize();
				fileWriter.writeFile(f, path, realname);
			}
		}
		if(imagename.length()==0) {
			//System.out.println("파일 등록 안함");
			imagename = "noimage";
			rmdto.setMenu_imagefile(imagename);
			rmdto.setMenu_image_realname("");
			rmdto.setMenu_image_realpath("");
			rmdto.setMenu_image_size(0);
		} else {
			//마지막 , 제거하기
			imagename = imagename.substring(0, imagename.length()-1);
			rmdto.setMenu_imagefile(imagename);
			rmdto.setMenu_image_realname(realname);
			rmdto.setMenu_image_realpath(path);
			rmdto.setMenu_image_size(size);
		}
		
		//db에 저장
		service.insertRestaurantMenu(rmdto);
		return "redirect:/restaurant/menuFront.do";
	}
}
