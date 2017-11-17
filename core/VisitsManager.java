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

		System.out.println("Witaj w rejestracji pacjentów");
		boolean flag = true;
		String choice;
		while (flag) {
			System.out.println("Co chcesz zrobiæ: 1 - pacjenci, 2 - lekarze, 3 - umawianie wizyt, \'q\' - wyjœcie z programu");
			Scanner sc = Tools.scanner();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			// Menu pacjentów
			case "1":
				while (flag) {
					System.out.println("Wybierz opcjê: L - lista pacjentów, N - dodawanie nowego pacjenta, E - edycja pacjenta, D - usuwanie pacjenta, B - powrót do poprzedniego menu, Q - wyjœcie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					case "l":
						Patient patient = new Patient();
						patient.getPatients();
						System.out.println("Powrót do poprzedniego menu");
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
						// Zakoñczenie programu
						System.out.println("Wyszed³eœ z programu...");
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
				System.out.println("Wyszed³eœ z programu...");
				flag = false;
				break;
			}
		}

	}
}
