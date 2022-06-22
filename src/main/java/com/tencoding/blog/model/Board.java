package com.tencoding.blog.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // ORM 사용
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터 베이스의 넘버링 전략 따라감
	private int id;
	
	private String title;
	
	@Lob // 대용량 데이터
	private String content;
	
	@ColumnDefault("0")
	private int readCount;
	
	@CreationTimestamp // 자동으로 시간 입력됨 
	private Timestamp createDate;
}
