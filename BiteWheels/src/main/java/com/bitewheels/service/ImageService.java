//package com.bitewheels.service;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.bitewheels.exception.NotFoundException;
//import com.bitewheels.model.ImageData;
//import com.bitewheels.model.ImageUtils;
//import com.bitewheels.repository.ImageRepository;
//
//@Service
//public class ImageService {
//	@Autowired
//	private ImageRepository imageRepo;
//
//	public String uploadImage(MultipartFile file) throws IOException {
//		ImageData save = imageRepo.save(ImageData.builder()
//				.name(file.getOriginalFilename())
//				.type(file.getContentType())
//				.imageData(ImageUtils.compressImage(file.getBytes())).build());
//		System.out.println("Hello");
//		System.out.println(Arrays.toString(ImageUtils.compressImage(file.getBytes())));
//		System.out.println(Arrays.toString(file.getBytes()));
//		if (save != null)
//			return "file uploaded succesfully" + file.getOriginalFilename();
//		return "something went wrong";
//	}
//
//	public byte[] downloadImage(String imageName) throws IOException {
//		ImageData image = imageRepo.findByName(imageName).orElseThrow(() -> new NotFoundException("Image not found!"));
//		return ImageUtils.decompressImage(image.getImageData());
//	}
//}
