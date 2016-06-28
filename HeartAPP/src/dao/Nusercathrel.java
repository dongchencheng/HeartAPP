package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nusercathrel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nusercathrel", catalog = "heartapp")
public class Nusercathrel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8191385558067422386L;
	private Integer idNuserCathRel;
	private Integer idNuser;
	private Integer idCatharsis;
	private Integer idPositiveSuggestion;
	private Timestamp responseTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nusercathrel() {
	}

	/** minimal constructor */
	public Nusercathrel(Integer idNuser, Integer idCatharsis,
			Integer idPositiveSuggestion, Timestamp responseTime) {
		this.idNuser = idNuser;
		this.idCatharsis = idCatharsis;
		this.idPositiveSuggestion = idPositiveSuggestion;
		this.responseTime = responseTime;
	}

	/** full constructor */
	public Nusercathrel(Integer idNuser, Integer idCatharsis,
			Integer idPositiveSuggestion, Timestamp responseTime, String notes) {
		this.idNuser = idNuser;
		this.idCatharsis = idCatharsis;
		this.idPositiveSuggestion = idPositiveSuggestion;
		this.responseTime = responseTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idNUserCathRel", unique = true, nullable = false)
	public Integer getIdNuserCathRel() {
		return this.idNuserCathRel;
	}

	public void setIdNuserCathRel(Integer idNuserCathRel) {
		this.idNuserCathRel = idNuserCathRel;
	}

	@Column(name = "idNuser", nullable = false)
	public Integer getIdNuser() {
		return this.idNuser;
	}

	public void setIdNuser(Integer idNuser) {
		this.idNuser = idNuser;
	}

	@Column(name = "idCatharsis", nullable = false)
	public Integer getIdCatharsis() {
		return this.idCatharsis;
	}

	public void setIdCatharsis(Integer idCatharsis) {
		this.idCatharsis = idCatharsis;
	}

	@Column(name = "idPositiveSuggestion", nullable = false)
	public Integer getIdPositiveSuggestion() {
		return this.idPositiveSuggestion;
	}

	public void setIdPositiveSuggestion(Integer idPositiveSuggestion) {
		this.idPositiveSuggestion = idPositiveSuggestion;
	}

	@Column(name = "ResponseTime", nullable = false, length = 19)
	public Timestamp getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime) {
		this.responseTime = responseTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}