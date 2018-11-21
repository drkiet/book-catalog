package com.drkiettran.bookcatalog;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.bookcatalog.BookCatalog.BOOK_FORMAT_TYPES;

public class BookCatalogTest {
	private static final Logger logger = LoggerFactory.getLogger(BookCatalogTest.class);

	@Test
	public void shouldGetAllBookTypes() {
		String[] bookTypes = BookCatalog.getBookTypes(BOOK_FORMAT_TYPES.class);
		for (String bookType : bookTypes) {
			logger.info("bookType {}", bookType);
		}

		List<String> bookTypeList = BookCatalog.getBookTypesAsList(BOOK_FORMAT_TYPES.class);
		bookTypeList.stream().forEach(bookType -> {
			logger.info("bookType {}", bookType);
		});
	}

	@Test
	public void shouldGetListOfSupportingBooks() throws IOException {
		BookCatalog bc = new BookCatalogImpl();
		Hashtable<String, String> bookFilenamesLocations = bc.getBookFilenamesLocations("d:/ebooks");
		logger.info("number of supporting books: {}", bookFilenamesLocations.size());
		assertThat(bookFilenamesLocations.keySet(), not(empty()));
	}

	@Test
	public void shouldReadPrint() throws IOException, TikaException {
		Tika tika = new Tika();
		try (InputStream stream = new FileInputStream("d:/ebooks/Vue-Essentials-Cheat-Sheet.pdf")) {
			int count = 0;
			while (true) {
				count++;
				if (stream.read() < 0) {
					break;
				}
			}
			System.out.println("bytes: " + count);

			String content = tika.parseToString(stream);
			System.out.println("doc:" + content);
		}

	}
}
