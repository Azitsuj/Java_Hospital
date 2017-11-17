package tables;

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

}
