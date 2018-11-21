package com.drkiettran.bookcatalog.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FilenameUtils;
import org.apache.lucene.document.Document;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.searchengine.lucene.LucenePDFDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.bookcatalog.model.Book;

public class BookReaderImpl implements BookReader {
	private static final Logger logger = LoggerFactory.getLogger(BookReaderImpl.class);

	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;

	@Override
	public Book load(String filename) throws FileNotFoundException, IOException {
		if ("pdf".equalsIgnoreCase(FilenameUtils.getExtension(filename))) {
			return loadPdf(filename);
		}
		return null;
	}

	private Book loadPdf(String filename) throws FileNotFoundException, IOException {
		try (RandomAccessRead rar = new RandomAccessFile(new File(filename), "r")) {
			Book book = new Book();
			PDFParser parser = new PDFParser(rar);
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);

			PDDocumentInformation info = pdDoc.getDocumentInformation();
			book.setTitle(info.getTitle());
			book.setAuthor(info.getAuthor());
			book.setPublisher(info.getProducer());
			book.setPages(pdDoc.getNumberOfPages());
			PDPageTree tree = pdDoc.getPages();
			Document doc = LucenePDFDocument.getDocument(new FileInputStream(filename));
			for (int count = 0; count < tree.getCount(); count++) {
				PDPage page = tree.get(count);
				System.out.println("page " + count + ":\n");
				printPage(page.getContents());
			}
			return book;
		}
	}

	private void printPage(InputStream contents) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(contents))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
