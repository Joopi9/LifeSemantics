package com.lifesemantics.app.service;

import com.lifesemantics.app.model.MemberInVO;

public interface LoginService {

	/*****************
	 * 2022.11.18
	 * �α��� ó��
	******************/
//	int selectLoginId(String memberId, String password);
	int selectLoginId(MemberInVO memberVo);

}
