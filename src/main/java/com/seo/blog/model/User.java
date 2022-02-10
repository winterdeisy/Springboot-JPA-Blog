package com.seo.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.*;

//ORM -> JAVA(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity //User 클래스가 MySQL에 자동으로 테이블이 생성된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  
public class User {  
	
	@Id //PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
	private int id; //시퀀스, auto_increment
	
	@Column(nullable=false, length=30) //null이 될수 없으며 길이제한 30 
	private String username; //아이디
	
	@Column(nullable=false, length=100) //null이 될수 없으며 길이제한 100
	private String password;
	
	@Column(nullable=false, length=50) //null이 될수 없으며 길이제한 50 
	private String email;
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다 //admin, user, manager 
	
	@CreationTimestamp //시간이 자동입력됨
	private Timestamp createDate;
}
