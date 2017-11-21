package core;

import java.util.Scanner;

import dto.DoctorDto;
import dto.PatientDto;
import util.tools.Tools;

public class VisitsManager {

	public static void main(String[] args) {

		System.out.println("Witaj w rejestracji pacjentów");
		boolean flag = true;
		String choice;
		while (flag) {
			System.out.println("Co chcesz zrobiæ: 1 - pacjenci, 2 - lekarze, 3 - wizyty, \'q\' - wyjœcie z programu");
			Scanner sc = Tools.scanner();
			choice = sc.nextLine();
			Patient patient = new Patient();
			Doctor doctor = new Doctor();
			String id, name, surname, spec;
			switch (choice.toLowerCase()) {
			// Menu pacjentów
			case "1":
				while (flag) {
					System.out.println(
							"Wybierz opcjê: L - lista pacjentów, N - dodawanie nowego pacjenta, E - edycja pacjenta, D - usuwanie pacjenta, B - powrót do poprzedniego menu, Q - wyjœcie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					// lista wszystkich pacjentów
					case "l":
						patient.getPatients();
						System.out.println("Powrót do poprzedniego menu");
						break;
					// nowy pacjent
					case "n":
						System.out.println("Podaj imiê nowego pacjenta:");
						name = sc.nextLine();
						System.out.println("Podaj nazwisko nowego pacjenta:");
						surname = sc.nextLine();
						PatientDto patientDto = new PatientDto();
						patientDto.setName(name);
						patientDto.setSurname(surname);
						patient.createPatient(patientDto);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// edycja wskazanego pacjenta
					case "e":
						System.out.println("Podaj id pacjenta do edycji:");
						id = sc.nextLine();
						PatientDto patientGet = patient.getPatient(Integer.valueOf(id));
						System.out.println("Wybrany pacjent ma nastêpuj¹ce dane:");
						System.out.println("Id: " + patientGet.getId() + ", imiê: " + patientGet.getName() + ", nazwisko: " + patientGet.getSurname());
						System.out.println("Podaj nowe imiê (\'ENTER\' aby pomin¹æ):");
						name = sc.nextLine();
						if (name.length() == 0) {
							name = patientGet.getName();
						} else {
							patientGet.setName(name);
						}
						System.out.println("Podaj nowe nazwisko (\'ENTER\' aby pomin¹æ):");
						surname = sc.nextLine();
						if (surname.length() == 0) {
							surname = patientGet.getSurname();
						} else {
							patientGet.setSurname(surname);
						}
						patient.editPatient(patientGet);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// usuwanie wskazanego pacjenta
					case "d":
						System.out.println("Podaj id pacjenta do usuniêcia:");
						id = sc.nextLine();
						patient.deletePatient(Integer.valueOf(id));
						System.out.println("Powrót do poprzedniego menu");
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
				while (flag) {
					System.out.println(
							"Wybierz opcjê: L - lista lekarzy, N - dodawanie nowego lekarza, E - edycja lekarza, D - usuwanie lekarza, B - powrót do poprzedniego menu, Q - wyjœcie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					// lista wszystkich lekarzy
					case "l":
						doctor.getDoctors();
						System.out.println("Powrót do poprzedniego menu");
						break;
					// nowy lekarz
					case "n":
						System.out.println("Podaj imiê nowego lekarza:");
						name = sc.nextLine();
						System.out.println("Podaj nazwisko nowego lekarza:");
						surname = sc.nextLine();
						System.out.println("Podaj specjalizacjê nowego lekarza:");
						spec = sc.nextLine();
						DoctorDto doctorDto = new DoctorDto();
						doctorDto.setName(name);
						doctorDto.setSurname(surname);
						doctorDto.setSpec(spec);
						doctor.createDoctor(doctorDto);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// edycja wskazanego lekarza
					case "e":
						System.out.println("Podaj id lekarza do edycji:");
						id = sc.nextLine();
						DoctorDto doctorGet = doctor.getDoctor(Integer.valueOf(id));
						System.out.println("Wybrany lekarz ma nastêpuj¹ce dane:");
						System.out.println("Id: " + doctorGet.getId() + ", imiê: " + doctorGet.getName() + ", nazwisko: " + doctorGet.getSurname()
								+ ", specjalizacja: " + doctorGet.getSpec());
						System.out.println("Podaj nowe imiê (\'ENTER\' aby pomin¹æ):");
						name = sc.nextLine();
						if (name.length() == 0) {
							name = doctorGet.getName();
						} else {
							doctorGet.setName(name);
						}
						System.out.println("Podaj nowe nazwisko (\'ENTER\' aby pomin¹æ):");
						surname = sc.nextLine();
						if (surname.length() == 0) {
							surname = doctorGet.getSurname();
						} else {
							doctorGet.setSurname(surname);
						}
						System.out.println("Podaj now¹ specjalizacjê (\'ENTER\' aby pomin¹æ):");
						spec = sc.nextLine();
						if (spec.length() == 0) {
							spec = doctorGet.getSurname();
						} else {
							doctorGet.setSurname(spec);
						}
						doctor.editDoctor(doctorGet);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// usuwanie wskazanego lekarza
					case "d":
						System.out.println("Podaj id lekarza do usuniêcia:");
						id = sc.nextLine();
						doctor.deleteDoctor(Integer.valueOf(id));
						System.out.println("Powrót do poprzedniego menu");
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
