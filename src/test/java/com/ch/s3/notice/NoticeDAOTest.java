package com.ch.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ch.s3.MyTestCase;
import com.ch.s3.notice.NoticeDAO;
import com.ch.s3.notice.NoticeDTO;
import com.ch.s3.util.Pager;

public class NoticeDAOTest extends MyTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}

	@Before
	public void beforeTest() {
		System.out.println("Before Method");
	}
	
	@After
	public void afterTest() {
		System.out.println("After Method");
	}

	//@Test
	public void noticeDeleteTest() throws Exception{
		System.out.println("Delete");
		  int result = noticeDAO.noticeDelete(222);

		   //단정문 
		   assertEquals(0, result);
	}
	//noticeInsertTest
	//@Test
	public void noticeInsertTest() throws Exception{
		System.out.println("Insert");
		
		for(int i=0;i<100;i++) {
			 NoticeDTO noticeDTO = new NoticeDTO();
			 noticeDTO.setTitle("Title"+i);
			 noticeDTO.setContents("Contents"+i);
			 noticeDTO.setWriter("Writer"+i);
			 int result = noticeDAO.noticeWrite(noticeDTO);
			 
			 if(i%10==0) {
				 Thread.sleep(1000);
			 }
		}
	}
	//@Test
	public void noticeSelectTest() throws Exception {
       System.out.println("Select");
	   NoticeDTO noticeDTO = noticeDAO.noticeSelect(5);

	   //단정문 
	   assertNotNull(noticeDTO);
	}
	
	@Test
	public void noticeListTest() throws Exception{
		Pager pager = new Pager();
		pager.setStartRow(1);
		pager.setLastRow(10);
		List<NoticeDTO> ar = noticeDAO.noticeList(pager);
		assertEquals(10, ar.size());
	}


}
