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
	private final String NAMESPACE = "com.ch.s3.qna.QnaDAO.";
	
	//selectList
	public List<QnaDTO> qnaList(Pager pager) throws Exception{
		 return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	}
	
	//count
	public long qnaCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	}
	
	//selectOne
	public QnaDTO qnaSelect(long num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", num);
	}
	
	//reply
	public int qnaReply (QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaDTO);
	}
	
	public int qnaReplyUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaDTO);
	}

	//write
	public int qnaWrite(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaWrite", qnaDTO);
	}

	//insert update delete는 리턴 다 int
	public int qnaUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"qnaUpdate", qnaDTO);
	}
	
	public int qnaDelete(long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"qnaDelete", num);
	}
	
	

	

}
