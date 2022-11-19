package com.lifesemantics.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInVO {
	private int id;
	private String memberId;
	private String password;
	private String memberEmail;
	private String regDate;
	private String regId;
	private String modDate;
	private String modId;
	private boolean remember;
	
	@Builder
	public MemberInVO(String memberId, String password) {
		this.memberId = memberId;
		this.password = password;
	}
}
