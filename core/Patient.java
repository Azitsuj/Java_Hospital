package core;

import java.util.Collection;
import java.util.Iterator;

import dao.PatientDao;
import dao.PatientDaoImpl;
import dto.PatientDto;
import tables.Tables;

public class Patient {

	public void getPatients() {
		PatientDao patientDao = new PatientDaoImpl();
		Collection<PatientDto> patientDtoCol = patientDao.getAll();
		Tables.printPatientHeader();
		for (Iterator<PatientDto> iterator = patientDtoCol.iterator(); iterator.hasNext();) {
			PatientDto patientDto = (PatientDto) iterator.next();
			Tables.printPatientTable(patientDto);
		}
		Tables.printPatientFooter();
	}
	
	public void createPatient(PatientDto patientDto) {
		PatientDao patientDao = new PatientDaoImpl();
		patientDao.create(patientDto);
	}
	
	public void deletePatient(Integer id) {
		PatientDao patientDao = new PatientDaoImpl();
		patientDao.delete(id);
	}

	public PatientDto getPatient(Integer id) {
		PatientDao patientDao = new PatientDaoImpl();
		PatientDto patientGet = patientDao.get(id);
		return patientGet;
	}

	public void editPatient(PatientDto patient) {
		PatientDao patientDao = new PatientDaoImpl();
		patientDao.update(patient);
	}
}
