package com.tylerbartnick.utilities;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileViaStream {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String inputFilePath = escapeFilePath(getInputFilePath());
		String outputFilePath = escapeFilePath(getOutputFilePath());

		FileInputStream src = null;
		try {
			src = new FileInputStream(inputFilePath);
		} catch (IOException ex) {
			System.out.println("An error occurred with the input file. Try a different file.");
			System.exit(-1);
		}

		FileOutputStream dest = null;
		try {
			dest = new FileOutputStream(outputFilePath);
		} catch (IOException ex) {
			System.out.println("An error occured with the output file. Try a different file.");
			System.exit(-1);
		}

		copySrcToDest(src, dest);
	}

	public static String getInputFilePath() {
		System.out.print("Please enter the full path of the file to copy\n> ");
		String filePath = scanner.nextLine();
		return filePath;
	}

	public static String getOutputFilePath() {
		System.out.print("Please enter the full path of the file destination\n> ");
		String filePath = scanner.nextLine();
		return filePath;
	}

	public static String escapeFilePath(String filePath) {
		if (System.getProperty("os.name").startsWith("Windows")) {
			filePath = filePath.replace("\\", "\\\\");
		}

		return filePath;
	}

	public static void copySrcToDest(FileInputStream src, FileOutputStream dest) {
		int filePointer;
		try {
			while ((filePointer = src.read()) != -1) {
				dest.write(filePointer);
			}

		} catch (IOException ex) {
			System.out.println("Unable to copy contents of source file to destination file.");
			System.exit(-1);
		}
	}

}
