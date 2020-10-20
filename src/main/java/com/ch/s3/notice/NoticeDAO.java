package com.ch.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.s3.util.Pager;

@Repository
public class NoticeDAO {
	
	//XML에서 만든 객체를 찾아서 주입해줌
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.ch.s3.notice.NoticeDAO.";
	
	//insert update delete는 리턴 다 int
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(namespace+"noticeUpdate", noticeDTO);
	}
	
	public int noticeDelete(long num) throws Exception{
		return sqlSession.delete(namespace+"noticeDelete", num);
	}
	
	public NoticeDTO noticeSelect(long num) throws Exception{
		return sqlSession.selectOne(namespace+"noticeSelect", num);
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(namespace+"noticeWrite", noticeDTO);
	}
	
	public List<NoticeDTO> noticeList(Pager pager) throws Exception {	
		
		return sqlSession.selectList(namespace+"noticeList", pager);
	}
	
	public long noticeCount(Pager pager) throws Exception{
		return sqlSession.selectOne(namespace+"noticeCount", pager);
	}

}
