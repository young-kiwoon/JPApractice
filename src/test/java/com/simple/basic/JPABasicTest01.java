package com.simple.basic;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPABasicTest01 {

	@Autowired
	MemoRepository memoRepository;

	//insert 작업
//	@Test
//	public void testCode01() {
//		
//		for (int i = 0; i < 100; i++) {
//			Memo memo = Memo.builder().writer("youngkw" + i).text("안녕하세요" + i).build();
//			
//			memoRepository.save(memo);
//		}
//	}
	
	//select 작업
	@Test
	public void testCode02() {
		
//		특정 select		
//		Optional<Memo> result = memoRepository.findById(100L);
//		
//		if(result.isPresent()) {
//			Memo memo = result.get();
//			System.out.println(memo.toString());
//		}
//		else {
//			System.out.println("결과 없음");
//		}
		
		//selectAll
//		List<Memo> list = memoRepository.findAll();
//		
//		for (Memo memo : list) {
//			System.out.println(memo.toString());
//		}
		
		//update
//		Memo memo = Memo.builder().mno(101L)
//					  			  .writer("업뎃완료!")
//					  			  .text("업뎃완료!!")
//					  			  .build();
//		
//		Memo result = memoRepository.save(memo);
//		System.out.println("업뎃 된 엔티티: " + result);
		
		
		//delete
//		memoRepository.deleteById(101L);
		
		
		
	}
}
