package com.lifesemantics.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.lifesemantics.app.model.MemberInVO;
import com.lifesemantics.app.model.MemberOutVO;

@Mapper
public interface LoginXmlRepository {

	/*****************
	 * 2022.11.18
	 * �α��� ó��
	******************/
	MemberOutVO selectLoginId(String memberId);

}
