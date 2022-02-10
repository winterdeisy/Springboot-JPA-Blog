package com.seo.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터
	private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0") //숫자는 홑따옴표 필요없음
	private int count; //조회수
	
	@ManyToOne(fetch = FetchType.EAGER) 
	//연관관계, Many = Board, One = User, 한명의 유저는 여러개의 게시글을 쓸 수 있다.
	
	@JoinColumn(name="userId") //필드 이름
	private User user; 
	//private int userId;
	//DB는 오브젝트를 저장할 수 없어 FK를 사용하는데, 자바는 오브젝트를 저장할 수 있다.
	//자바는 DB 자료형에 맞춰서 테이블을 만든다
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	//Board 테이블에 Join할때 값만 넣는 용도
	private List<Reply> reply;
	  
	@CreationTimestamp //현재시간으로 자동으로 표기
	private Timestamp createDate;
}
