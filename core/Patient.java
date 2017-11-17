package core;

import java.util.Collection;
import java.util.Iterator;

import dao.PatientDao;
import dao.PatientDaoImpl;
import dto.PatientDto;
import tables.Tables;

public class Patient {

	public void getPatients() {
		PatientDto patientQuery = new PatientDto();
		PatientDao patientDao = new PatientDaoImpl();
		// Collection<PatientDto> patientDtoCol =
		// patientDao.search(patientQuery);
		Collection<PatientDto> patientDtoCol = patientDao.getAll();
		Tables.printPatientHeader();
		for (Iterator<PatientDto> iterator = patientDtoCol.iterator(); iterator.hasNext();) {
			PatientDto patientDto = (PatientDto) iterator.next();
			// System.out.println(patientDto.getId() + "\t" +
			// patientDto.getName() + "\t" + patientDto.getSurname());
			Tables.printPatientTable(patientDto);
		}
		Tables.printPatientFooter();
	}
}
