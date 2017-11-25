package core;

import java.util.Collection;
import java.util.Iterator;

import dao.VisitsDaoImpl;
import dao.interf.VisitsDao;
import dto.VisitsDto;
import tables.Tables;

public class Visits {
	
	public void getDoctorVisits(Integer id) {
		VisitsDao visitsDao = new VisitsDaoImpl();
		Collection<VisitsDto> visitsDtoCol = visitsDao.getDoctorVisit(id);
		Tables.printVisitsHeader();
		for (Iterator<VisitsDto> iterator = visitsDtoCol.iterator(); iterator.hasNext();) {
			VisitsDto visitsDto = (VisitsDto) iterator.next();
			Tables.printVisitsTable(visitsDto);
		}
		Tables.printVisitsFooter();
	}
	/*
	public void createDoctor(DoctorDto doctorDto) {
		DoctorDao doctorDao = new DoctorDaoImpl();
		doctorDao.create(doctorDto);
	}

	public void deleteDoctor(Integer id) {
		DoctorDao doctorDao = new DoctorDaoImpl();
		doctorDao.delete(id);
	}

	public DoctorDto getDoctor(Integer id) {
		DoctorDao doctorDao = new DoctorDaoImpl();
		DoctorDto doctorGet = doctorDao.get(id);
		return doctorGet;
	}

	public void editDoctor(DoctorDto doctor) {
		DoctorDao doctorDao = new DoctorDaoImpl();
		doctorDao.update(doctor);
	}
	*/
}
