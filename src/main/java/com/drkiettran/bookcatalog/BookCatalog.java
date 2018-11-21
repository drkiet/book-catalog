package com.drkiettran.bookcatalog;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public interface BookCatalog {

	enum BOOK_FORMAT_TYPES {
		AZW, AZW3, AZW4, CBZ, CBR, CBC, CHM, DJVU, DOCX, EPUB, FB2, FBZ, HTML, HTMLZ, LIT, LRF, MOBI, ODT, PDF, PRC,
		PDB, PML, RB, RTF, SNB, TCR, TXT, TXTZ
	};

	Hashtable<String, String> getBookFilenamesLocations(String string) throws IOException;
	
	public static List<String> getBookTypesAsList(Class<? extends Enum<?>> e) {
		return Arrays.stream(e.getEnumConstants()).map(Enum::name).collect(Collectors.toList());
	}

	public static String[] getBookTypes(Class<? extends Enum<?>> e) {

		return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
}
