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
public class JPAQueryTest {

	//쿼리메서드 - 메서드의 이름을 보고 jpa가 sql문을 실행함
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void testCode01() {
		
//		List<Memo> list = memoRepository.findByMnoBetween(10L, 50L);
//		
//		for (Memo memo : list) {
//			System.out.println(memo.toString());
//		}
		
//		List<Memo> list = memoRepository.findByTextOrderByMnoDesc("안녕하세요3");
//		
//		for(Memo memo : list) {
//			System.out.println(memo.toString());
//		}
		
//		List<Memo> list = memoRepository.findByTextLikeOrWriterLike("%1%", "%2%");
//		
//		for(Memo memo : list) {
//			System.out.println(memo.toString());
//		}
		
		PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> page = memoRepository.findByMnoBetween(10L, 50L, pageable);
		
		for(Memo m : page.getContent()) {
			System.out.println(m.toString());
		}
		
	}
}
