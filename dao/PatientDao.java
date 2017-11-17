package dao;

import java.util.Collection;

import dto.PatientDto;

public interface PatientDao {
	PatientDto get(Integer id);
	Collection<PatientDto> getAll();
	void delete(Integer id);
	void update(PatientDto patient);
	void create(PatientDto patient);
	Collection<PatientDto> search(PatientDto patientDto);
}
