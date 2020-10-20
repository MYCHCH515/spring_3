package com.ch.s3.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.s3.util.Pager;

@Repository
public class QnaDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.ch.s3.qna.QnaDAO.";
	
	public List<QnaDTO> qnaList(Pager pager) throws Exception{
		 return sqlSession.selectList(namespace+"qnaList", pager);
	}
	
	public long qnaCount(Pager pager) throws Exception{
		return sqlSession.selectOne(namespace+"qnaCount", pager);
	}
	
	//insert update delete는 리턴 다 int
	public int qnaUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(namespace+"qnaUpdate", qnaDTO);
	}
	
	public int qnaDelete(long num) throws Exception{
		return sqlSession.delete(namespace+"qnaDelete", num);
	}
	
	public QnaDTO qnaSelect(long num) throws Exception{
		return sqlSession.selectOne(namespace+"qnaSelect", num);
	}
	
	public int qnaWrite(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(namespace+"qnaWrite", qnaDTO);
	}
	
	

}
