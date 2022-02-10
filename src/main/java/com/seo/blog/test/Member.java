package com.seo.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok 라이브러리
@Data //getter + setter
@NoArgsConstructor //빈 생성자
public class Member {
	private int id;
	private String username;
	private String email;
	private String password;
	
	@Builder //오버로딩 없이 내가 넣고 싶은 파라미터를 넣을 수 있다 (Member.builder())
	public Member(int id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
