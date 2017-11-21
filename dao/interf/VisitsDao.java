package dao.interf;

import java.util.Collection;

import dto.DoctorDto;
import dto.VisitsDto;

public interface VisitsDao {

	VisitsDto get(Integer id);

	Collection<DoctorDto> getAll();

	void delete(Integer id);

	void update(DoctorDto doctor);

	void create(DoctorDto doctor);

	Collection<DoctorDto> search(DoctorDto doctortDto);
}
