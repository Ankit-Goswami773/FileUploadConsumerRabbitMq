package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileContent {
   @Id
   @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
   private String name;
	private String	transactionID;
	private String TransactionType;
	private long Amount;
	private String date;
	private String status;
	private int file_id;
	
}
