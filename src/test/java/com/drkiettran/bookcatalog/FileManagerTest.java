package com.drkiettran.bookcatalog;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.bookcatalog.file.FileManager;
import com.drkiettran.bookcatalog.file.FileManagerImpl;

public class FileManagerTest {
	private static final Logger logger = LoggerFactory.getLogger(FileManagerTest.class);

	@Test
	public void shouldGetAllFilesRecursively() throws IOException {
		FileManager fm = new FileManagerImpl();
		Hashtable<String, String> bookNamesLocations = fm.getAllFilesRecursively("d:/ebooks");

		logger.info("Number of books (not include duplicated): {}", bookNamesLocations.size());

		assertThat(bookNamesLocations.keySet(), not(empty()));
	}

	@Test
	public void shouldGetAllUniqueExtensions() throws IOException {
		FileManager fm = new FileManagerImpl();
		Hashtable<String, Integer> extensions = fm.getAllExtensions("d:/ebooks");
		logger.info("Number of unique extensions: {}", extensions.size());
		extensions.keySet().stream().forEach(ext -> {
			logger.info("ext: {}", ext);
		});
		assertThat(extensions.keySet(), not(empty()));
	}
}
