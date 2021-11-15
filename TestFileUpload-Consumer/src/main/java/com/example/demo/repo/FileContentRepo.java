package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FileContent;
import com.example.demo.model.Merchent;

@Transactional
@Repository
public interface FileContentRepo  extends JpaRepository<FileContent, Integer>{

	@Query(value=" select * from content where file_id=:id ",nativeQuery = true)
	public List<FileContent> allRecordsFile(@Param("id") int id);
	
	@Query(value="select * from merchent",nativeQuery = true)
	public List<Merchent> allRecordsMerchent();
	
	@Modifying
	@Query(value="Update content set status ='success' where id=:id ",nativeQuery = true)
	public void updateRecord(@Param("id") int id);
}
