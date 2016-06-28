package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Taskfinished entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "taskfinished", catalog = "heartapp")
public class Taskfinished implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4764861400213587100L;
	private Integer idFinishedTask;
	private Integer idTask;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer times;
	private String notes;

	// Constructors

	/** default constructor */
	public Taskfinished() {
	}

	/** minimal constructor */
	public Taskfinished(Integer idTask, Timestamp beginTime, Timestamp endTime) {
		this.idTask = idTask;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Taskfinished(Integer idTask, Timestamp beginTime, Timestamp endTime,
			Integer times, String notes) {
		this.idTask = idTask;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.times = times;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFinishedTask", unique = true, nullable = false)
	public Integer getIdFinishedTask() {
		return this.idFinishedTask;
	}

	public void setIdFinishedTask(Integer idFinishedTask) {
		this.idFinishedTask = idFinishedTask;
	}

	@Column(name = "idTask", nullable = false)
	public Integer getIdTask() {
		return this.idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", nullable = false, length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "Times")
	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Column(name = "Notes", length = 150)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}