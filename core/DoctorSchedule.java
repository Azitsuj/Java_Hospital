package core;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import dao.DoctorScheduleDaoImpl;
import dao.VisitsDaoImpl;
import dao.interf.DoctorScheduleDao;
import dao.interf.VisitsDao;
import dto.DoctorScheduleDto;
import dto.VisitsDto;
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

	public void createDoctorSchedule(DoctorScheduleDto doctorScheduleDto, VisitsDto visitDto, int minutes, Date startDate, Date endDate) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.create(doctorScheduleDto);
		VisitsDao visitDao = new VisitsDaoImpl();
		visitDao.createBlank(visitDto, minutes, startDate, endDate);
	}

	public void deleteDoctorSchedule(Integer id, Integer idDoctor, Date startDateOld, Date endDateOld) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.delete(id);
		VisitsDao visitDao = new VisitsDaoImpl();
		visitDao.deleteSet(idDoctor, startDateOld, endDateOld);
	}

	public DoctorScheduleDto getDoctorSchedule(Integer id) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		DoctorScheduleDto doctorScheduleGet = doctorScheduleDao.get(id);
		return doctorScheduleGet;
	}

	public void editDoctorSchedule(DoctorScheduleDto schedule, VisitsDto visitDto, int minutes, Date startDateOld, Date endDateOld, Date startDate, Date endDate) {
		DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDaoImpl();
		doctorScheduleDao.update(schedule);
		VisitsDao visitDao = new VisitsDaoImpl();
		visitDao.updateBlank(visitDto, minutes, startDateOld, endDateOld, startDate, endDate);
	}
	
}
