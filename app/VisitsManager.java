package app;

import java.util.Scanner;

import core.Doctor;
import core.DoctorSchedule;
import core.Patient;
import dto.DoctorDto;
import dto.DoctorScheduleDto;
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
			DoctorSchedule schedule = new DoctorSchedule();
			String id, name, surname, spec, day, start, end;
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
				
				
				
				while (flag) {
					System.out.println(
							"Wybierz opcjê: P - umówienie pacjenta, L - lista dy¿urów, N - dodawanie nowego dy¿uru, E - edycja dy¿uru, D - usuwanie wizyty, "
							+ "X - usuwanie dy¿uru, B - powrót do poprzedniego menu, Q - wyjœcie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					// lista wszystkich dy¿urów
					case "l":
						schedule.getScheduls();
						System.out.println("Powrót do poprzedniego menu");
						break;
					// nowy dy¿ur
					case "n":
						System.out.println("Podaj istniej¹ce id lekarza:");
						id = sc.nextLine();
						System.out.println("Podaj datê nowego dy¿uru [dd-mm-rrrr]:");
						day = sc.nextLine();
						System.out.println("Podaj godzinê rozpoczêcia dy¿uru [hh:mm]:");
						start = sc.nextLine();
						System.out.println("Podaj godzinê zakoñczenia dy¿uru [hh:mm]:");
						end = sc.nextLine();
						DoctorScheduleDto doctorScheduleDto = new DoctorScheduleDto();
						doctorScheduleDto.getDoctor().setId(Integer.valueOf(id));
						DoctorDto doctorTemp = doctor.getDoctor(doctorScheduleDto.getDoctor().getId());
						doctorScheduleDto.getDoctor().setName(doctorTemp.getName());
						doctorScheduleDto.getDoctor().setSurname(doctorTemp.getSurname());
						doctorScheduleDto.getDoctor().setSpec(doctorTemp.getSpec());
						doctorScheduleDto.setDay(day);
						doctorScheduleDto.setStart(start);
						doctorScheduleDto.setEnd(end);
						schedule.createDoctorSchedule(doctorScheduleDto);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// edycja wskazanego dy¿uru
						// TO DO
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
				
				
				
			case "q":
				System.out.println("Wyszed³eœ z programu...");
				flag = false;
				break;
			}
		}

	}
}
