package com.file.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="file_tabel")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="fileName")
	private String name;
	@Column(name="fileType")
	private String type;
	@Column(name="ImageInformation")
	private byte[] imageData;
	

}
