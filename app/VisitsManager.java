package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import core.Doctor;
import core.DoctorSchedule;
import core.Patient;
import core.Visits;
import dto.DoctorDto;
import dto.DoctorScheduleDto;
import dto.PatientDto;
import dto.VisitsDto;
import util.tools.Tools;

public class VisitsManager {

	public static void main(String[] args) throws ParseException {

		System.out.println("Witaj w rejestracji pacjentów");
		boolean flag = true;
		String choice;
		Date startDate, endDate, startDateOld, endDateOld;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String startDateString = "";
		String endDateString = "";
		long dateDiff;
		int minutes;

		while (flag) {
			System.out.println("Co chcesz zrobiæ: 1 - pacjenci, 2 - lekarze, 3 - dy¿ury lekarzy, 4 - wizyty, \'q\' - wyjœcie z programu");
			Scanner sc = Tools.scanner();
			choice = sc.nextLine();
			Patient patient = new Patient();
			Doctor doctor = new Doctor();
			DoctorSchedule schedule = new DoctorSchedule();
			Visits visit = new Visits();
			String id, idd, name, surname, spec, start, end;
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
					System.out.println("Wybierz opcjê: L - lista dy¿urów, N - dodawanie nowego dy¿uru, E - edycja dy¿uru, D - usuwanie dy¿uru, "
							+ "B - powrót do poprzedniego menu, Q - wyjœcie");
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
						while (true) {
							try {
								while (true) {
									System.out.println("Podaj datê i godzinê nowego dy¿uru [rrrr-mm-dd hh:mm]:");
									start = sc.nextLine();
									if (start.charAt(start.length() - 1) == '0') {
										startDate = df.parse(start);
										if (!df.format(startDate).equals(start)) {
											System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
										} else {
											startDateString = df.format(startDate);
											break;
										}
									} else {
										System.out.println("Poda³eœ z³¹ godzinê, minuty musz¹ byæ zaokr¹glone do pe³nych dziesi¹tek, spróbuj jeszcze raz");
									}
								}
								break;
							} catch (ParseException e) {
								System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
								// e.printStackTrace();
							}
						}
						while (true) {
							try {
								while (true) {
									System.out.println("Podaj datê i godzinê zakoñczenia dy¿uru [rrrr-mm-dd hh:mm]:");
									end = sc.nextLine();
									if (start.charAt(start.length() - 1) == '0') {
										endDate = df.parse(end);
										if (!df.format(endDate).equals(end)) {
											System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
										} else {
											endDateString = df.format(endDate);
											break;
										}
									} else {
										System.out.println("Poda³eœ z³¹ godzinê, minuty musz¹ byæ zaokr¹glone do pe³nych dziesi¹tek, spróbuj jeszcze raz");
									}
								}
								break;
							} catch (ParseException e) {
								System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
								// e.printStackTrace();
							}
						}
						// ró¿nica w minutach pomiêdzy pocz¹tkiem a koñcem
						// dy¿uru - potrzebna aby utworzyæ odpowiednio wiele pól
						// dla umawiania wizyt
						dateDiff = (endDate.getTime() - startDate.getTime());
						minutes = (int) TimeUnit.MILLISECONDS.toMinutes(dateDiff);
						DoctorScheduleDto doctorScheduleDto = new DoctorScheduleDto();
						doctorScheduleDto.getDoctor().setId(Integer.valueOf(id));
						DoctorDto doctorTemp = doctor.getDoctor(doctorScheduleDto.getDoctor().getId());
						VisitsDto visitTemp = new VisitsDto();
						doctorScheduleDto.getDoctor().setName(doctorTemp.getName());
						doctorScheduleDto.getDoctor().setSurname(doctorTemp.getSurname());
						doctorScheduleDto.getDoctor().setSpec(doctorTemp.getSpec());
						doctorScheduleDto.setStart(startDateString);
						doctorScheduleDto.setEnd(endDateString);
						visitTemp.setVisit_start(startDateString);
						visitTemp.setVisit_end(endDateString);
						visitTemp.getDoctor().setId(Integer.valueOf(id));
						visitTemp.getDoctor().setName(doctorTemp.getName());
						visitTemp.getDoctor().setSurname(doctorTemp.getSurname());
						visitTemp.getDoctor().setSpec(doctorTemp.getSpec());
						schedule.createDoctorSchedule(doctorScheduleDto, visitTemp, minutes, startDate, endDate);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// edycja wskazanego dy¿uru
					case "e":
						System.out.println("Podaj id dy¿uru do edycji:");
						id = sc.nextLine();
						// DoctorDto doctorGet =
						// doctor.getDoctor(Integer.valueOf(id));
						DoctorScheduleDto scheduleGet = schedule.getDoctorSchedule(Integer.valueOf(id));
						System.out.println("Dane wybranego dy¿uru:");
						System.out.println("Id dy¿uru: " + scheduleGet.getId() + ", id lekarza: " + scheduleGet.getDoctor().getId() + ", imiê: "
								+ scheduleGet.getDoctor().getName() + ", nazwisko: " + scheduleGet.getDoctor().getSurname() + ", specjalizacja: "
								+ scheduleGet.getDoctor().getSpec() + ", start: " + scheduleGet.getStart() + ", koniec: " + scheduleGet.getEnd());
						startDateOld = df.parse(scheduleGet.getStart());
						endDateOld = df.parse(scheduleGet.getEnd());
						System.out.println("Podaj nowe id lekarza (\'ENTER\' aby pomin¹æ):");
						idd = sc.nextLine();
						if (idd.length() == 0) {
							idd = String.valueOf(scheduleGet.getDoctor().getId());
						} else {
							scheduleGet.getDoctor().setId(Integer.valueOf(idd));
						}
						while (true) {
							try {
								while (true) {
									System.out.println("Podaj now¹ datê i godzinê dy¿uru [rrrr-mm-dd hh:mm] (\'ENTER\' aby pomin¹æ):");
									start = sc.nextLine();
									if (start.length() == 0) {
										startDate = df.parse(scheduleGet.getStart());
										startDateString = df.format(startDate);
										break;
									} else {
										if (start.charAt(start.length() - 1) == '0') {
											startDate = df.parse(start);
											if (!df.format(startDate).equals(start)) {
												System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
											} else {
												startDateString = df.format(startDate);
												break;
											}
										} else {
											System.out.println("Poda³eœ z³¹ godzinê, minuty musz¹ byæ zaokr¹glone do pe³nych dziesi¹tek, spróbuj jeszcze raz");
										}
									}
								}
								break;
							} catch (ParseException e) {
								System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
								// e.printStackTrace();
							}
						}
						while (true) {
							try {
								while (true) {
									System.out.println("Podaj now¹ datê i godzinê zakoñczenia dy¿uru [rrrr-mm-dd hh:mm] (\'ENTER\' aby pomin¹æ):");
									end = sc.nextLine();
									if (end.length() == 0) {
										endDate = df.parse(scheduleGet.getEnd());
										endDateString = df.format(endDate);
										break;
									} else {
										if (end.charAt(end.length() - 1) == '0') {
											endDate = df.parse(end);
											if (!df.format(endDate).equals(end)) {
												System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
											} else {
												endDateString = df.format(endDate);
												break;
											}
										} else {
											System.out.println("Poda³eœ z³¹ godzinê, minuty musz¹ byæ zaokr¹glone do pe³nych dziesi¹tek, spróbuj jeszcze raz");
										}
									}
								}
								break;
							} catch (ParseException e) {
								System.out.println("Poda³eœ z³¹ datê, spróbuj jeszcze raz");
								// e.printStackTrace();
							}
						}

						dateDiff = (endDate.getTime() - startDate.getTime());
						minutes = (int) TimeUnit.MILLISECONDS.toMinutes(dateDiff);
						doctorTemp = doctor.getDoctor(scheduleGet.getDoctor().getId());
						visitTemp = new VisitsDto();
						scheduleGet.getDoctor().setName(doctorTemp.getName());
						scheduleGet.getDoctor().setSurname(doctorTemp.getSurname());
						scheduleGet.getDoctor().setSpec(doctorTemp.getSpec());
						scheduleGet.setStart(startDateString);
						scheduleGet.setEnd(endDateString);
						visitTemp.setVisit_start(startDateString);
						visitTemp.setVisit_end(endDateString);
						visitTemp.getDoctor().setId(Integer.valueOf(idd));
						visitTemp.getDoctor().setName(doctorTemp.getName());
						visitTemp.getDoctor().setSurname(doctorTemp.getSurname());
						visitTemp.getDoctor().setSpec(doctorTemp.getSpec());
						schedule.editDoctorSchedule(scheduleGet, visitTemp, minutes, startDateOld, endDateOld, startDate, endDate);
						System.out.println("Powrót do poprzedniego menu");
						break;
					// usuwanie wskazanego dy¿uru:
					case "d":
						System.out.println("Podaj id dy¿uru do usuniêcia:");
						id = sc.nextLine();
						scheduleGet = schedule.getDoctorSchedule(Integer.valueOf(id));
						startDateOld = df.parse(scheduleGet.getStart());
						endDateOld = df.parse(scheduleGet.getEnd());
						Integer idDoctor = scheduleGet.getDoctor().getId();
						schedule.deleteDoctorSchedule(Integer.valueOf(id), idDoctor, startDateOld, endDateOld);
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

			case "4":

				while (flag) {
					System.out.println("Wybierz opcjê: L - lista dy¿urów wybranego lekarza, T - lista terminów wizyt wybranego lekarza, "
							+ "N - umawianie wizyt, E - edycja wizyt, D - usuwanie wizyt, "
							+ "B - powrót do poprzedniego menu, Q - wyjœcie");
					choice = sc.nextLine();
					switch (choice.toLowerCase()) {
					// lista wszystkich dy¿urów danego lekarza
					case "l":
						System.out.println("Podaj id lekarza, którego dy¿ury chcesz zobaczyæ:");
						id = sc.nextLine();
						schedule.getSelectedScheduls(Integer.valueOf(id));
						System.out.println("Powrót do poprzedniego menu");
						break;
						
					case "t":
						System.out.println("Podaj id lekarza, którego terminy wizyt chcesz zobaczyæ:");
						id = sc.nextLine();
						visit.getDoctorVisits(Integer.valueOf(id));
						System.out.println("Powrót do poprzedniego menu");
						break;
					}
				}

			case "q":

				System.out.println("Wyszed³eœ z programu...");
				flag = false;
				break;
			}
		}

	}
}
