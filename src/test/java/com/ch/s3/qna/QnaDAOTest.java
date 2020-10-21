package com.ch.s3.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ch.s3.MyTestCase;

public class QnaDAOTest extends MyTestCase{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void qnaReplyTest() throws Exception{
		//답글
		QnaDTO child = new QnaDTO();
		child.setTitle("Test Reply Title 6");
		child.setWriter("Test Reply Writer 6");
		child.setContents("Test Reply Contents 6");
		
		//int result = qnaDAO.qnaReply(qnaDTO);
		
		//부모글 정보
		QnaDTO parent = qnaDAO.qnaSelect(10);
		
		//update
		qnaDAO.qnaReplyUpdate(parent);
		
		//부모글의 정보로 답글에 정보를 입력 
		
		//ref는 부모의 ref
		child.setRef(parent.getRef());
		child.setStep(parent.getStep()+1);
		child.setDepth(parent.getDepth()+1);
		
		int result = qnaDAO.qnaReply(child);
		assertNotEquals(0, result);
	}
	
	
	
	//@Test
	public void qnaWriteTest() throws Exception{
		//dto만들어서 가짜 데이터를 만듦
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test title 2");
		qnaDTO.setWriter("test writer 2");
		qnaDTO.setContents("test contents 2");

		int result = qnaDAO.qnaWrite(qnaDTO);
		
		assertNotEquals(0, result);
	}
}
