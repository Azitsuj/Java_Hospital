package dao.interf;

import java.util.Collection;

import dto.DoctorScheduleDto;

public interface DoctorScheduleDao {

	DoctorScheduleDto get(Integer id);

	Collection<DoctorScheduleDto> getAll();

	void delete(Integer id);

	void update(DoctorScheduleDto schedule);

	void create(DoctorScheduleDto schedule);

	Collection<DoctorScheduleDto> search(DoctorScheduleDto scheduleDto);

}
