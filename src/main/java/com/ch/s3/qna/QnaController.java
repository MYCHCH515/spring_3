package com.ch.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ch.s3.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView qnaList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<QnaDTO> ar = qnaService.qnaList(pager);
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		
		mv.setViewName("qna/qnaList");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView qnaUpdate(QnaDTO qnaDTO) throws Exception {
		System.out.println(qnaDTO.getTitle());
		System.out.println(qnaDTO.getContents());	
		System.out.println(qnaDTO.getNum());
		//서비스에서 받아옴
		int result = qnaService.qnaUpdate(qnaDTO);
		System.out.println("RESULT : "+result);
		String message="Update Fail";
		if(result>0) {
			message = "Update Success";
		}
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		return mv;
	}

	//매개변수 long으로 받아와도됨
	@RequestMapping(value = "qnaUpdate")
	public void qnaUpdate(QnaDTO qnaDTO, Model model) throws Exception{
		//글번호 출력 
		System.out.println(qnaDTO.getNum());
		
		//db에서 조회해서 글제목, 글 내용을 출력
		qnaDTO = qnaService.qnaSelect(qnaDTO.getNum());
		//update form에 title content를 
		model.addAttribute("dto", qnaDTO);
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(long num) throws Exception {
		System.out.println("qna Delete Controller");
		int result = qnaService.qnaDelete(num);
		String message="Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		return mv;
	}
	
	@RequestMapping(value="qnaWrite")
	public void qnaWrite() {}
	
	@RequestMapping(value="qnaWrite" , method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.qnaWrite( qnaDTO);
		System.out.println("RESULT: " + result);
		
		String message="Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		return mv;	
	}
	
	@RequestMapping(value="qnaSelect")
	public void qnaSelect(long num, Model model) throws Exception {
		System.out.println("qnaSelect");
		QnaDTO qnaDTO = qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaDTO); //매개변수로 받은거는 return안해도됨
	}
	
	
	
}
