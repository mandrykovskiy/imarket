package ua.servise;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {
	public enum Folder {
		PRODUCT, COUNTRY, CATEGORY, CREATOR;
	}

	String write(Folder folder, MultipartFile file, int id);
}
