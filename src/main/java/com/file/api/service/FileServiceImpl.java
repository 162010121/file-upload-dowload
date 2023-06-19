package com.file.api.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.api.entity.FileEntity;
import com.file.api.repository.FileRepository;
import com.file.api.utils.ImageUtils;

@Service
public class FileServiceImpl {

	@Autowired
	private FileRepository repository;

	public String uploadImage(MultipartFile file) throws IOException {
		FileEntity enity = repository.save(FileEntity.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imageData(ImageUtils.compressImage(file.getBytes())).build());
		if (enity != null) {
			return "file uplload successfully" + file.getOriginalFilename();
		}
		return null;

	}

	public byte[] downloaImage(String fileName) {
		Optional<FileEntity> dbimage = repository.findByName(fileName);
		byte[] image = ImageUtils.decompressImage(dbimage.get().getImageData());
		return image;

	}

}
