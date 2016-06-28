package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "patient", catalog = "heartapp")
public class Patient implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -72392913369185737L;
	private Integer idPatient;
	private String patientName;
	private String patientTel;
	private String patientDes;
	private String patientAnalyze;
	private String notes;

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** full constructor */
	public Patient(String patientName, String patientTel, String patientDes,
			String patientAnalyze, String notes) {
		this.patientName = patientName;
		this.patientTel = patientTel;
		this.patientDes = patientDes;
		this.patientAnalyze = patientAnalyze;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPatient", unique = true, nullable = false)
	public Integer getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "PatientName", length = 30)
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "PatientTel", length = 50)
	public String getPatientTel() {
		return this.patientTel;
	}

	public void setPatientTel(String patientTel) {
		this.patientTel = patientTel;
	}

	@Column(name = "PatientDes", length = 160)
	public String getPatientDes() {
		return this.patientDes;
	}

	public void setPatientDes(String patientDes) {
		this.patientDes = patientDes;
	}

	@Column(name = "PatientAnalyze", length = 150)
	public String getPatientAnalyze() {
		return this.patientAnalyze;
	}

	public void setPatientAnalyze(String patientAnalyze) {
		this.patientAnalyze = patientAnalyze;
	}

	@Column(name = "Notes", length = 150)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}