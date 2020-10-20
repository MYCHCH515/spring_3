package com.ch.s3.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.s3.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> memberList(Pager pager) throws Exception{
		
		pager.makeRow();
		
		long totalCount = memberDAO.memberCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage();
		
		return memberDAO.memberList(pager);
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberDTO memberSelect(long num) throws Exception{
		return memberDAO.memberSelect(num);
	}
	
	public int memberDelete(long num) throws Exception{
		return memberDAO.memberDelete(num);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
