package main;

import java.io.File;

import threads.FileController;


public class Main {
	public static void main(String[] args) {
		File saida = new File("C:\\Users\\Jusan\\Desktop\\saida");
		File destino = new File("C:\\Users\\Jusan\\Desktop\\entrada");
		File saida2 = new File("C:\\Users\\Jusan\\Desktop\\saida2");
		File saida3 = new File("C:\\Users\\Jusan\\Desktop\\saida3");

		FileController thread1 = new FileController(saida, destino);
		FileController thread2 = new FileController(saida2, destino);
		FileController thread3 = new FileController(saida3, destino);
	}
}