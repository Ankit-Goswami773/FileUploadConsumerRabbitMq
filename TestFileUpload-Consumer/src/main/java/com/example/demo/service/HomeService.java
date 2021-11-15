package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FileContent;
import com.example.demo.model.Files;
import com.example.demo.model.Merchent;
import com.example.demo.repo.FileContentRepo;
import com.example.demo.repo.MerchentRepo;

@Service
public class HomeService {

	@Autowired
	private FileContentRepo contentRepo;
	
	@Autowired
	private MerchentRepo merchentRepo;
	
	public void matchData(int id )
	{	
		List<FileContent> fileContent = contentRepo.allRecordsFile(id);
		List<Merchent> merchent = merchentRepo.findAll();

		 List<FileContent> collect = fileContent.stream()
				.filter(file -> merchent.stream()
						.anyMatch(mer -> file.getName().equalsIgnoreCase(mer.getName())
						&& file.getAmount() == mer.getAmount()
					&& file.getTransactionID().trim().equalsIgnoreCase(mer.getTransaction_id().trim())
                                )).map(s->update(s)).collect(Collectors.toList());
          
	this.contentRepo.saveAll(collect);
	       
	}
	
	private FileContent update(FileContent content) {
		content.setStatus("Success");
		return content;
	}

}
