package com.seo.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.seo.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new하는게 아닌 
//특정 어노테이션이 붙어있는 클래스 파일을 new해서(Ioc) 스프링이 컨테이너에서 관리해준다.
@RestController
public class BlogControllerTest {

	//주소 이름을 입력받음
	//http://localhost:8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello Spring boot</h1>";
	}

}
