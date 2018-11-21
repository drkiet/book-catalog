package com.drkiettran.bookcatalog;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

import com.drkiettran.bookcatalog.file.FileManager;
import com.drkiettran.bookcatalog.file.FileManagerImpl;

public class BookCatalogImpl implements BookCatalog {

	@Override
	public Hashtable<String, String> getBookFilenamesLocations(String dirName) throws IOException {
		FileManager fm = new FileManagerImpl();
		List<String> supportingExtensions = BookCatalog.getBookTypesAsList(BookCatalog.BOOK_FORMAT_TYPES.class);
		Hashtable<String, String> filenamesLocations = fm.getAllFilesRecursively(dirName);
		Hashtable<String, String> supportingBooks = new Hashtable<String, String>();
		filenamesLocations.keySet().stream().forEach(fileName -> {
			if (supportingExtensions.contains(FilenameUtils.getExtension(fileName).toUpperCase())) {
				supportingBooks.put(fileName, filenamesLocations.get(fileName));
			}
		});

		return supportingBooks;
	}

}
