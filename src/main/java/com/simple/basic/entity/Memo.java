package com.simple.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity						//jpa가 엔티티로 관리한다는 의미
@Table(name = "TBL_MEMO")	//테이블 명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mno;
	
	//column의 null 여부, 길이
	@Column(nullable = false, length = 200)
	private String writer;
	
	//직접 써서
	@Column(columnDefinition = "varchar(200) default 'y'")
	private String text;
}
