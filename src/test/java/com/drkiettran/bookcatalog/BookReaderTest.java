package com.drkiettran.bookcatalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.bookcatalog.model.Book;
import com.drkiettran.bookcatalog.reader.BookReader;
import com.drkiettran.bookcatalog.reader.BookReaderImpl;

public class BookReaderTest {
	private static final Logger logger = LoggerFactory.getLogger(BookReaderTest.class);

	@Test
	public void shouldReadOneBook() throws FileNotFoundException, IOException {
		BookReader br = new BookReaderImpl();
		String filename = "d:\\ebooks\\Daniel Kahneman Thinking Fast and Slow.pdf";
		Book book = br.load(filename);
		logger.info("\ntitle {},\npages {},\nauthor {},\npublisher {}", book.getTitle(), book.getPages(),
				book.getAuthor(), book.getPublisher());
		assertThat(book.getPages(), greaterThan(0));

		assertThat(br.getTitle(), equalTo("Thinking, Fast and Slow"));
	}
}
