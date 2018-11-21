package com.drkiettran.bookcatalog.file;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public interface FileManager {

	Hashtable<String, String> getAllFilesRecursively(String string) throws IOException;

	Hashtable<String, Integer> getAllExtensions(String string) throws IOException;

}
