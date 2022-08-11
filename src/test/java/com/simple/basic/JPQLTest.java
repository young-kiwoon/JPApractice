package com.simple.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPQLTest {

	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void testCode01() {
//		List<Memo> list = memoRepository.getListDesc();
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
		
		
//		List<Memo> list = memoRepository.getListDesc2(50L);
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
		
		
//		List<Memo> list = memoRepository.getListLike("%13%");
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
		
		
//		int result = memoRepository.updateMemo("변경할 값!", 55L);
//		System.out.println("업데이트 수행결과: " + result);
	
//		Memo memo = Memo.builder().writer("객체파라미터 변경").text("객체파라미터사용").build();
//		
//		int result = memoRepository.updateMemo(memo);
//		System.out.println("업데이트 수행결과: " + result);
		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").ascending());
//		long num = 30L;
//		
//		Page<Memo> result = memoRepository.getListJPQL(num, pageable);
//		
//		for(Memo memo : result.getContent()) {
//			System.out.println(memo.toString());
//		}
//		System.out.println("전체 게시글 수: "+ result.getTotalElements());
	
		
		Memo m = memoRepository.getNative(100L);
		System.out.println(m.toString());
	}
}
