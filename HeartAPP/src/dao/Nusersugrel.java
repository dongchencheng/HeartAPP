package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nusersugrel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nusersugrel", catalog = "heartapp")
public class Nusersugrel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8880018674414925380L;
	private Integer idNuserSugRel;
	private Integer idNuser;
	private Integer idPositive;
	private Timestamp beginTime;
	private Timestamp endeTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nusersugrel() {
	}

	/** minimal constructor */
	public Nusersugrel(Integer idNuser, Integer idPositive,
			Timestamp beginTime, Timestamp endeTime) {
		this.idNuser = idNuser;
		this.idPositive = idPositive;
		this.beginTime = beginTime;
		this.endeTime = endeTime;
	}

	/** full constructor */
	public Nusersugrel(Integer idNuser, Integer idPositive,
			Timestamp beginTime, Timestamp endeTime, String notes) {
		this.idNuser = idNuser;
		this.idPositive = idPositive;
		this.beginTime = beginTime;
		this.endeTime = endeTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idNUserSugRel", unique = true, nullable = false)
	public Integer getIdNuserSugRel() {
		return this.idNuserSugRel;
	}

	public void setIdNuserSugRel(Integer idNuserSugRel) {
		this.idNuserSugRel = idNuserSugRel;
	}

	@Column(name = "idNUser", nullable = false)
	public Integer getIdNuser() {
		return this.idNuser;
	}

	public void setIdNuser(Integer idNuser) {
		this.idNuser = idNuser;
	}

	@Column(name = "idPositive", nullable = false)
	public Integer getIdPositive() {
		return this.idPositive;
	}

	public void setIdPositive(Integer idPositive) {
		this.idPositive = idPositive;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndeTime", nullable = false, length = 19)
	public Timestamp getEndeTime() {
		return this.endeTime;
	}

	public void setEndeTime(Timestamp endeTime) {
		this.endeTime = endeTime;
	}

	@Column(name = "Notes", length = 100)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}