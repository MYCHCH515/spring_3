package com.ch.s3.notice;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ch.s3.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	//notice 서비스 객체를 autowired해서 가져옴
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		System.out.println(noticeDTO.getTitle());
		System.out.println(noticeDTO.getContents());	
		System.out.println(noticeDTO.getNum());
		//서비스에서 받아옴
		int result = noticeService.noticeUpdate(noticeDTO);
		System.out.println("RESULT : "+result);
		String message="Update Fail";
		if(result>0) {
			message = "Update Success";
		}
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		return mv;
	}

	//매개변수 long으로 받아와도됨
	@RequestMapping(value = "noticeUpdate")
	public void noticeUpdate(NoticeDTO noticeDTO, Model model) throws Exception{
		//글번호 출력 
		System.out.println(noticeDTO.getNum());
		
		//db에서 조회해서 글제목, 글 내용을 출력
		noticeDTO = noticeService.noticeSelect(noticeDTO.getNum());
		//update form에 title content를 
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(long num) throws Exception {
		System.out.println("Notice Delete Controller");
		int result = noticeService.noticeDelete(num);
		String message="Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		return mv;
		//return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {

		ModelAndView mv = new ModelAndView();
	
		List<NoticeDTO> ar = noticeService.noticeList(pager);

		mv.addObject("lists", ar);
		mv.addObject("pager", pager);

		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	@RequestMapping(value="noticeWrite")
	public void noticeWrite() {}
	
	@RequestMapping(value="noticeWrite" , method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.noticeWrite(noticeDTO);
		System.out.println("RESULT: " + result);
		
		String message="Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		return mv;	
	}
	
	@RequestMapping(value="noticeSelect")
	public void noticeSelect(long num, Model model) throws Exception {
		System.out.println("noticeSelect");
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeDTO); //매개변수로 받은거는 return안해도됨
	}
	
}
