package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", catalog = "heartapp")
public class Task implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -195083675969193089L;
	private Integer idTask;
	private Integer idCounselor;
	private Integer idPatient;
	private String taskType;
	private Integer times;
	private Integer range;
	private Timestamp assignTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Integer idCounselor, Integer idPatient, Timestamp assignTime) {
		this.idCounselor = idCounselor;
		this.idPatient = idPatient;
		this.assignTime = assignTime;
	}

	/** full constructor */
	public Task(Integer idCounselor, Integer idPatient, String taskType,
			Integer times, Integer range, Timestamp assignTime, String notes) {
		this.idCounselor = idCounselor;
		this.idPatient = idPatient;
		this.taskType = taskType;
		this.times = times;
		this.range = range;
		this.assignTime = assignTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTask", unique = true, nullable = false)
	public Integer getIdTask() {
		return this.idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	@Column(name = "idCounselor", nullable = false)
	public Integer getIdCounselor() {
		return this.idCounselor;
	}

	public void setIdCounselor(Integer idCounselor) {
		this.idCounselor = idCounselor;
	}

	@Column(name = "idPatient", nullable = false)
	public Integer getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "TaskType", length = 30)
	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "Times")
	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Column(name = "Range")
	public Integer getRange() {
		return this.range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	@Column(name = "AssignTime", nullable = false, length = 19)
	public Timestamp getAssignTime() {
		return this.assignTime;
	}

	public void setAssignTime(Timestamp assignTime) {
		this.assignTime = assignTime;
	}

	@Column(name = "Notes", length = 150)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}