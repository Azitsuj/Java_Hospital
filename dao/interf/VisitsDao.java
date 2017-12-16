package dao.interf;

import java.util.Collection;
import java.util.Date;

import dto.DoctorDto;
import dto.VisitsDto;

public interface VisitsDao {

	Collection<VisitsDto> getPatientsVisit();

	Collection<VisitsDto> getDoctorVisit(Integer id);
	
	void delete(Integer id);
	
	void deleteSet(Integer id, Date startDateOld, Date endDateOld);

	void updateBlank(VisitsDto visit, int minutes, Date startDateOld, Date endDateOld, Date startDate, Date endDate);

	void createBlank(VisitsDto visit, int minutes, Date startDate, Date endDate);
	
	void create(VisitsDto visit);

	Collection<DoctorDto> search(VisitsDto visitDto);
}
