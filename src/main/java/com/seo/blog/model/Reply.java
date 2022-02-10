package com.seo.blog.model;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

import java.sql.Timestamp;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB 넘버링 전략을 따라감
	private int id;
	
	@Column(nullable=false, length=200)
	private String content;
	
	//FK
	@JoinColumn(name="boardId") //컬럼 이름이 boardId
	@ManyToOne//연관관계, 하나의 게시글에는 여러개의 답변이 달린다	
	private Board board;
	
	//FK
	@JoinColumn(name="userId")
	@ManyToOne //하나의 유저는 여러개의 답변을 가질 수 있다
	private User user;

	@CreationTimestamp
	private Timestamp createDate;
}
