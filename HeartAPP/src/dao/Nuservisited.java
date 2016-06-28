package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nuservisited entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nuservisited", catalog = "heartapp")
public class Nuservisited implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3474611747836169795L;
	private Integer idUserVisited;
	private Integer idUser;
	private Integer idResource;
	private Timestamp listTime;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nuservisited() {
	}

	/** minimal constructor */
	public Nuservisited(Integer idUser, Integer idResource) {
		this.idUser = idUser;
		this.idResource = idResource;
	}

	/** full constructor */
	public Nuservisited(Integer idUser, Integer idResource, Timestamp listTime,
			Timestamp beginTime, Timestamp endTime, String notes) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.listTime = listTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserVisited", unique = true, nullable = false)
	public Integer getIdUserVisited() {
		return this.idUserVisited;
	}

	public void setIdUserVisited(Integer idUserVisited) {
		this.idUserVisited = idUserVisited;
	}

	@Column(name = "idUser", nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "idResource", nullable = false)
	public Integer getIdResource() {
		return this.idResource;
	}

	public void setIdResource(Integer idResource) {
		this.idResource = idResource;
	}

	@Column(name = "ListTime", length = 19)
	public Timestamp getListTime() {
		return this.listTime;
	}

	public void setListTime(Timestamp listTime) {
		this.listTime = listTime;
	}

	@Column(name = "BeginTime", length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}