package kodlamaio.hrms.core.utilites.business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements ImageService {

	Cloudinary cloudinary;

	public CloudinaryManager() {

		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "mycloudimageaby", "api_key", "686578711162378",
				"api_secret", "3baV26xv2MtPg_VQyAa3lbIA-2E"));

	}

	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {

		Map<String, Object> options = new HashMap<>();

		var allowedFormats = Arrays.asList("png", "jpg", "jpeg");

		options.put("allowed_formats", allowedFormats);

		File file = convertToFile(multipartFile);

		Map uploader = null;

		try {

			uploader = cloudinary.uploader().upload(file, options);

		} catch (Exception e) {

			return new ErrorDataResult<>(e.getMessage());

		}

		return new SuccessDataResult<>(uploader);

	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {

		return null;

	}

	private File convertToFile(MultipartFile multipartFile) throws IOException {

		File file = new File(multipartFile.getOriginalFilename());

		FileOutputStream stream = new FileOutputStream(file);

		stream.write(multipartFile.getBytes());

		stream.close();

		return file;

	}

}
