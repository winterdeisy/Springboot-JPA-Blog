package com.seo.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

//사용자가 요청할때 html 파일을 응답 -> @Controller 
//사용자가 요청할때 그에 대한 데이터 응답 -> @RestController
@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest";

	//http://localhost:8080/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member.MemberBuilder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG+"getter : "+m.getUsername()); 
		m.setUsername("seo");
		System.out.println(TAG+"getter : "+m.getUsername()); 
		return "lombok test 완료";
		
	}
	//인터넷 브라우저 요청은 get 요청만 가능하다
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청: " +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	//http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m){
		return "post 요청: " +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m){
		return "put 요청"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(){
		return "delete 요청";
	}
}
