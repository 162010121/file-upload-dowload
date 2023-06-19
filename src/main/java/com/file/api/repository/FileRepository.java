package com.file.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.api.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>{

	
	Optional<FileEntity> findByName(String fileName);
}
