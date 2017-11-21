package dto;

public class VisitsDto {

	private Integer id;
	private String day;
	private String visit_start;
	private String visit_end;

	private PatientDto patient = new PatientDto();
	private DoctorDto doctor = new DoctorDto();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getVisit_start() {
		return visit_start;
	}

	public void setVisit_start(String visit_start) {
		this.visit_start = visit_start;
	}

	public String getVisit_end() {
		return visit_end;
	}

	public void setVisit_end(String visit_end) {
		this.visit_end = visit_end;
	}

	public PatientDto getPatient() {
		return patient;
	}

	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((visit_end == null) ? 0 : visit_end.hashCode());
		result = prime * result + ((visit_start == null) ? 0 : visit_start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitsDto other = (VisitsDto) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (visit_end == null) {
			if (other.visit_end != null)
				return false;
		} else if (!visit_end.equals(other.visit_end))
			return false;
		if (visit_start == null) {
			if (other.visit_start != null)
				return false;
		} else if (!visit_start.equals(other.visit_start))
			return false;
		return true;
	}

}
