package tables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.DoctorDto;
import dto.DoctorScheduleDto;
import dto.PatientDto;

public class Tables {

	// Patient table
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

	// Doctor table
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
		String doctorAll = String.format("| %1$-5d | %2$-20s | %3$-20s | %4$-21s |", doctorDto.getId(), doctorDto.getName(), doctorDto.getSurname(),
				doctorDto.getSpec());
		System.out.println(doctorAll);
	}

	public static void printDoctorFooter() {
		for (int i = 1; i <= 79; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	// Schedule table
		public static void printScheduleHeader() {
			for (int i = 1; i <= 93; i++) {
				System.out.print("-");
			}
			System.out.println();
			String scheduleHeader = String.format("| %1$-5s | %2$-20s | %3$-20s | %4$-16s | %5$-16s |", "Id", "Imiê lekarza", "Nazwisko lekarza", 
					"Start", "End");
			System.out.println(scheduleHeader);
			for (int i = 1; i <= 93; i++) {
				System.out.print("-");
			}
			System.out.println();
		}

		public static void printDoctorScheduleTable(DoctorScheduleDto doctorScheduleDto) {
			Date startDate, endDate;
			String startDateString = "", endDateString = "";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				startDate = df.parse(doctorScheduleDto.getStart());
				endDate = df.parse(doctorScheduleDto.getEnd());
				startDateString = df.format(startDate);
				endDateString = df.format(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String doctorScheduleAll = String.format("| %1$-5d | %2$-20s | %3$-20s | %4$-16s | %5$-16s |", 
					doctorScheduleDto.getId(), doctorScheduleDto.getDoctor().getName(), doctorScheduleDto.getDoctor().getSurname(), 
					startDateString, endDateString);
			System.out.println(doctorScheduleAll);
		}

		public static void printDoctorScheduleFooter() {
			for (int i = 1; i <= 93; i++) {
				System.out.print("-");
			}
			System.out.println();
		}
}
