package util.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Tools {

	public static Scanner scanner() {
		Scanner scanner = new Scanner(new FilterInputStream(System.in) {
			@Override
			public void close() {
			}
		});
		scanner.useLocale(Locale.US);
		return scanner;
	}

	public static OutputStreamWriter outputStreamWriter(String fileName) throws FileNotFoundException {

		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName, true), StandardCharsets.UTF_8);
		return osw;
	}

	public static Scanner fileScanner(String fileName) throws FileNotFoundException {
		File fi = new File(fileName);
		Scanner sc = new Scanner(fi);
		return sc;
	}
}
