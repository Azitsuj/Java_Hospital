package core;

import java.util.Collection;
import java.util.Iterator;

import dao.DoctorScheduleDaoImpl;
import dao.interf.DoctorScheduleDao;
import dto.DoctorScheduleDto;
import tables.Tables;

public class DoctorSchedule {

	public void getScheduls() {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		Collection<DoctorScheduleDto> doctorScheduleDtoCol = doctorScheduleDao.getAll();
		Tables.printScheduleHeader();
		for (Iterator<DoctorScheduleDto> iterator = doctorScheduleDtoCol.iterator(); iterator.hasNext();) {
			DoctorScheduleDto doctorScheduleDto = (DoctorScheduleDto) iterator.next();
			Tables.printDoctorScheduleTable(doctorScheduleDto);
		}
		Tables.printDoctorScheduleFooter();
	}

	public void createDoctorSchedule(DoctorScheduleDto doctorScheduleDto) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.create(doctorScheduleDto);
	}

	public void deleteDoctorSchedule(Integer id) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.delete(id);
	}

	public DoctorScheduleDto getDoctorSchedule(Integer id) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		DoctorScheduleDto doctorScheduleGet = doctorScheduleDao.get(id);
		return doctorScheduleGet;
	}

	public void editDoctorSchedule(DoctorScheduleDto schedule) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.update(schedule);
	}
	
}
