package com.ch.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	public int noticeDelete(long num) throws Exception{
		return noticeDAO.noticeDelete(num);	
	}
	public NoticeDTO noticeSelect(long num) throws Exception {
		return noticeDAO.noticeSelect(num);	
	}	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);	
	}
	public List<NoticeDTO> noticeList(Pager pager) throws Exception{
		System.out.println("Service List");
		
		//**rownum 계산
		pager.makeRow();
		
		
		//**page 계산
		long totalCount = noticeDAO.noticeCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage();
		
		return noticeDAO.noticeList(pager);
	}
}
