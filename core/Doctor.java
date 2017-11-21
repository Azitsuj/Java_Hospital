package core;

import java.util.Collection;
import java.util.Iterator;

import dao.DoctorDao;
import dao.DoctorDaoImpl;
import dto.DoctorDto;
import tables.Tables;

public class Doctor {

	public void getDoctors() {
		DoctorDao doctorDao = new DoctorDaoImpl();
		Collection<DoctorDto> doctorDtoCol = doctorDao.getAll();
		Tables.printDoctorHeader();
		for (Iterator<DoctorDto> iterator = doctorDtoCol.iterator(); iterator.hasNext();) {
			DoctorDto doctorDto = (DoctorDto) iterator.next();
			Tables.printDoctorTable(doctorDto);
		}
		Tables.printDoctorFooter();
	}

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
}
