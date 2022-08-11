package com.simple.basic.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simple.basic.entity.Memo;

//JPA인터페이스를 상속받는걸로 자동으로 빈등록이 일어납니다
//<엔티티명, 엔티티의 ID타입>
public interface MemoRepository extends JpaRepository<Memo, Long>{

	//쿼리 메서드
	//select * from Memo where mno between ? and ?
	List<Memo> findByMnoBetween(Long start, Long end);
		
	//select * from Memo where text = ? order by mno desc
	List<Memo> findByTextOrderByMnoDesc(String text);
	
	//select * from tbl_memo where text like '%1%' or writer like '%2%';
	List<Memo> findByTextLikeOrWriterLike(String text ,String writer);
	
	//쿼리메서드와 PageRequest의 조합
	//매개변수로 Page인터페이스 타입을 전달, 변환은 Page<Memo>로 받음
	Page<Memo> findByMnoBetween(Long start, Long end, Pageable page);
	
	
	
	//JPQL - sql과 유사하나 엔티티를 사용해서 작성
	@Query("select m from Memo m order by m.mno desc")
	List<Memo> getListDesc();
	
	//JPQL 파라미터 전달 @Param(이름)
	@Query("select m from Memo m where m.mno > :num order by m.mno desc")
	List<Memo> getListDesc2(@Param("num") Long num);
	
	@Query("select m from Memo m where m.writer like :form")
	List<Memo> getListLike(@Param("form") String param);
	
	//JPQL - insert, update는 @Transactional, @Modifying을 붙인다.
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :writer where m.mno = :mno")
	int updateMemo(@Param("writer") String writer, @Param("mno")Long mno);
	
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :#{#a.writer}, m.text = :#{#a.text} where m.mno = :#{#a.mno}")
	int updateMemo(@Param("a") Memo memo);
	
	
	//JPQL의 페이지 결합
	@Query("select m from Memo m where m.mno > :a ")
	Page<Memo> getListJPQL(@Param("a") Long a, Pageable pageable);
	
	//네이티브 쿼리
	@Query(value = "select * from tbl_memo where mno = ?", nativeQuery = true);
	Memo getNative(Long mno);
}
