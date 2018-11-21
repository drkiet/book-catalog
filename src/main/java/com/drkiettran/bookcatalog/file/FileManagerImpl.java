package com.drkiettran.bookcatalog.file;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManagerImpl implements FileManager {
	private static final Logger logger = LoggerFactory.getLogger(FileManagerImpl.class);

	@Override
	public Hashtable<String, String> getAllFilesRecursively(String dirName) throws IOException {
		Hashtable<String, String> fileNamesLocations = new Hashtable<String, String>();

		File dir = new File(dirName);
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			fileNamesLocations.put(file.getName(), file.getCanonicalPath());
		}
		return fileNamesLocations;
	}

	@Override
	public Hashtable<String, Integer> getAllExtensions(String dirName) throws IOException {
		Hashtable<String, String> fileNamesLocations = this.getAllFilesRecursively(dirName);
		Hashtable<String, Integer> extensions = new Hashtable<String, Integer>();

		fileNamesLocations.keySet().stream().forEach(fileName -> {
			String ext = FilenameUtils.getExtension(fileName);
			Integer count = extensions.get(ext);
			if (count == null) {
				count = Integer.valueOf(0);
			}
			extensions.put(ext, ++count);
		});

		return extensions;
	}

}
