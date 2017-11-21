package tables;

import dto.DoctorDto;
import dto.PatientDto;

public class Tables {

	public static void printPatientHeader() {
		for (int i = 1; i <= 55; i++) {
			System.out.print("-");
		}
		System.out.println();
		String patientHeader = String.format("| %1$-5s | %2$-20s | %3$-20s |", "Id", "Imiê pacjenta", "Nazwisko pacjenta");
		System.out.println(patientHeader);
		for (int i = 1; i <= 55; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void printPatientTable(PatientDto patientDto) {
		String patientAll = String.format("| %1$-5d | %2$-20s | %3$-20s |", patientDto.getId(), patientDto.getName(), patientDto.getSurname());
		System.out.println(patientAll);
	}

	public static void printPatientFooter() {
		for (int i = 1; i <= 55; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void printDoctorHeader() {
		for (int i = 1; i <= 79; i++) {
			System.out.print("-");
		}
		System.out.println();
		String doctorHeader = String.format("| %1$-5s | %2$-20s | %3$-20s | %4$-21s |", "Id", "Imiê lekarza", "Nazwisko lekarza", "Specjalizacja lekarza");
		System.out.println(doctorHeader);
		for (int i = 1; i <= 79; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void printDoctorTable(DoctorDto doctorDto) {
		String doctorAll = String.format("| %1$-5d | %2$-20s | %3$-20s | %4$-21s |", doctorDto.getId(), doctorDto.getName(), doctorDto.getSurname(), doctorDto.getSpec());
		System.out.println(doctorAll);
	}

	public static void printDoctorFooter() {
		for (int i = 1; i <= 79; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
