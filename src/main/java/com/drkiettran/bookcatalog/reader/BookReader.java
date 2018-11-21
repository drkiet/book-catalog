package com.drkiettran.bookcatalog.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.drkiettran.bookcatalog.model.Book;

public interface BookReader {

	Book load(String filename) throws FileNotFoundException, IOException;

	String getTitle();

}
