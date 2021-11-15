package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FileContent;
import com.example.demo.model.Merchent;
import com.example.demo.repo.FileContentRepo;
import com.example.demo.repo.MerchentRepo;


@RestController
public class HOmeController {

	@Autowired
	private FileContentRepo contentRepo;

	@Autowired
	private MerchentRepo merchentRepo;

	@GetMapping("/")
	public List<FileContent> getAll() {
		return contentRepo.allRecordsFile(1);
	}

	@GetMapping("/merchent")
	public void getAllMer() {

		List<FileContent> fileContent = contentRepo.allRecordsFile(1);
		List<Merchent> merchent = merchentRepo.findAll();

		 List<FileContent> collect = fileContent.stream()
				.filter(file -> merchent.stream()
						.anyMatch(mer -> file.getName().equalsIgnoreCase(mer.getName())
						&& file.getAmount() == mer.getAmount()
					&& file.getTransactionID().trim().equalsIgnoreCase(mer.getTransaction_id().trim())
                                )).map(s->update(s)).collect(Collectors.toList());
          
	this.contentRepo.saveAll(collect);
	}

	public FileContent update(FileContent content) {
		content.setStatus("Success");
		return content;
	}

}
