package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Merchent;

public interface MerchentRepo extends JpaRepository<Merchent, Integer> {

	@Query(value="select * from merchent",nativeQuery = true)
	public List<Merchent> getMerchentData();
	
}
