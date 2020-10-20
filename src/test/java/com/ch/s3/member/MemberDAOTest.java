package com.ch.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ch.s3.MyTestCase;


public class MemberDAOTest extends MyTestCase {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public void memberSelectTest() throws Exception{
		MemberDTO memberDTO = memberDAO.memberSelect(2);
		
		assertNotNull(memberDTO);	
	}
	
	//@Test
	public void memberJoinTest() throws Exception{
		for(int i=0;i<100;i++) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId("ID"+i);
			memberDTO.setPw("Pw"+i);
			memberDTO.setName("Name"+i);
			memberDTO.setEmail("Email"+i);
			
			int result = memberDAO.memberJoin(memberDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		
		
	}

	

}
