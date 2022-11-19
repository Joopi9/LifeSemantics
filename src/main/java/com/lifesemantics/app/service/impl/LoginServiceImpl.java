package com.lifesemantics.app.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lifesemantics.app.model.MemberInVO;
import com.lifesemantics.app.model.MemberOutVO;
import com.lifesemantics.app.repository.LoginXmlRepository;
import com.lifesemantics.app.service.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

	private final LoginXmlRepository loginXmlRepository;
	private final PasswordEncoder passwordEncoder;
	
	/*****************
	 * 2022.11.18
	 * �α��� ó��
	******************/
	@Override
	public int selectLoginId(MemberInVO memberInVo) {
		MemberOutVO memberOutVo = loginXmlRepository.selectLoginId(memberInVo.getMemberId());
		// ���̵� �������� �ʴ� ���
		int result = -1;
		if(memberOutVo != null) {
//			if(passwordEncoder.matches(memberInVo.getPassword(), memberOutVo.getPassword())) {
//				result = 1;
//			}
			if(memberInVo.getPassword().equals(memberOutVo.getPassword())) {
				result = 1;	// ���̵��ְ� ��� �°�
			}else {
				result = 0;	// ���̵��ְ� ��� Ʋ����
			}
		}
		return result;
	}
}
