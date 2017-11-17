package core;

import java.util.Collection;
import java.util.Iterator;

import dao.PatientDao;
import dao.PatientDaoImpl;
import dto.PatientDto;

public class VisitsManager {

	public static void main(String[] args) {

		PatientDto patientQuery = new PatientDto();
		PatientDao patientDao = new PatientDaoImpl();
//		Collection<PatientDto> patientDtoCol = patientDao.search(patientQuery);
		Collection<PatientDto> patientDtoCol = patientDao.getAll();

		for (Iterator<PatientDto> iterator = patientDtoCol.iterator(); iterator.hasNext();) {
			PatientDto patientDto = (PatientDto) iterator.next();
			System.out.println(patientDto.getId() + "\t" + patientDto.getName() + "\t" + patientDto.getSurname());
		}
	}
}
