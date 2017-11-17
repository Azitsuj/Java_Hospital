package core;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import dao.PatientDao;
import dao.PatientDaoImpl;
import dto.PatientDto;
import tables.Tables;
import util.tools.Tools;

public class VisitsManager {

	public static void main(String[] args) {

		System.out.println("Witaj w rejestracji pacjent�w");
		boolean flag = true;
		String choice;
		while (flag) {
			System.out.println("Co chcesz zrobi�: 1 - pacjenci, 2 - lekarze, 3 - umawianie wizyt, \'q\' - wyj�cie z programu");
			Scanner sc = Tools.scanner();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			// Menu pacjent�w
			case "1":
				while (flag) {
					System.out.println("Wybierz opcj�: L - lista pacjent�w, N - dodawanie nowego pacjenta, E - edycja pacjenta, D - usuwanie pacjenta, B - powr�t do poprzedniego menu, Q - wyj�cie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					case "l":
						Patient patient = new Patient();
						patient.getPatients();
						System.out.println("Powr�t do poprzedniego menu");
						break;
					case "n":
						// to do
						break;
					case "e":
						// to do
						break;
					case "d":
						// to do
						break;
					case "b":
						flag = false;
						break;
					case "q":
						// Zako�czenie programu
						System.out.println("Wyszed�e� z programu...");
						System.exit(0);
					}
				}
				flag = true;
				break;
			case "2":
				// to do
			case "3":
				// to do
			case "q":
				System.out.println("Wyszed�e� z programu...");
				flag = false;
				break;
			}
		}

	}
}
