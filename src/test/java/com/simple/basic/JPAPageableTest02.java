package com.simple.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPAPageableTest02 {

	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void testCode01(){
		
		//sort클래스는 정렬에 사용
//		Sort order = Sort.by("mno").descending();
//		
//	 	List<Memo> list = memoRepository.findAll(order);
//	 	
//	 	for (Memo memo : list) {
//			System.out.println(memo.toString());
//		}
		
		//정렬조건 and
//		Sort order01 = Sort.by("writer").descending();
//		Sort order02 = Sort.by("text").ascending();
//
//		Sort sort = order01.and(order02);
//		
//		List<Memo> list = memoRepository.findAll(sort);		//합쳐진 정렬
//		
//		for (Memo memo : list) {
//			System.out.println(memo.toString());
//		}

//		PageRequest pageable = PageRequest.of(0, 10);	//페이지 번호, 데이터 개수
//		
//		Page<Memo> result = memoRepository.findAll(pageable);
//		
//		for(Memo m : result.getContent()) {
//			System.out.println(m.toString());
//		}
		
		PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		
		Page<Memo> result = memoRepository.findAll(pageable);
		
		for(Memo m : result.getContent()) {
			System.out.println(m.toString());
		}
		
		
	}
}
