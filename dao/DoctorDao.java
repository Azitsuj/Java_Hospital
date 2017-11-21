package dao;

import java.util.Collection;

import dto.DoctorDto;

public interface DoctorDao {

	DoctorDto get(Integer id);

	Collection<DoctorDto> getAll();

	void delete(Integer id);

	void update(DoctorDto doctor);

	void create(DoctorDto doctor);

	Collection<DoctorDto> search(DoctorDto doctortDto);
	
}
