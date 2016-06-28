package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usercollect entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usercollect", catalog = "heartapp")
public class Usercollect implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4114051671453169775L;
	private Integer idUserCollect;
	private Integer idUser;
	private Integer idResource;
	private Timestamp collectTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Usercollect() {
	}

	/** minimal constructor */
	public Usercollect(Integer idUser, Integer idResource, Timestamp collectTime) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.collectTime = collectTime;
	}

	/** full constructor */
	public Usercollect(Integer idUser, Integer idResource,
			Timestamp collectTime, String notes) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.collectTime = collectTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserCollect", unique = true, nullable = false)
	public Integer getIdUserCollect() {
		return this.idUserCollect;
	}

	public void setIdUserCollect(Integer idUserCollect) {
		this.idUserCollect = idUserCollect;
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

	@Column(name = "CollectTime", nullable = false, length = 19)
	public Timestamp getCollectTime() {
		return this.collectTime;
	}

	public void setCollectTime(Timestamp collectTime) {
		this.collectTime = collectTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}