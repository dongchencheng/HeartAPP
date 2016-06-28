package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Counselor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "counselor", catalog = "heartapp")
public class Counselor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6725712836948511609L;
	private Integer idCounselor;
	private Integer idFranchisee;
	private String couName;
	private String couCard;
	private String couTel;
	private String couDes;
	private String notes;

	// Constructors

	/** default constructor */
	public Counselor() {
	}

	/** minimal constructor */
	public Counselor(Integer idFranchisee) {
		this.idFranchisee = idFranchisee;
	}

	/** full constructor */
	public Counselor(Integer idFranchisee, String couName, String couCard,
			String couTel, String couDes, String notes) {
		this.idFranchisee = idFranchisee;
		this.couName = couName;
		this.couCard = couCard;
		this.couTel = couTel;
		this.couDes = couDes;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCounselor", unique = true, nullable = false)
	public Integer getIdCounselor() {
		return this.idCounselor;
	}

	public void setIdCounselor(Integer idCounselor) {
		this.idCounselor = idCounselor;
	}

	@Column(name = "idFranchisee", nullable = false)
	public Integer getIdFranchisee() {
		return this.idFranchisee;
	}

	public void setIdFranchisee(Integer idFranchisee) {
		this.idFranchisee = idFranchisee;
	}

	@Column(name = "CouName", length = 30)
	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	@Column(name = "CouCard", length = 30)
	public String getCouCard() {
		return this.couCard;
	}

	public void setCouCard(String couCard) {
		this.couCard = couCard;
	}

	@Column(name = "CouTel", length = 50)
	public String getCouTel() {
		return this.couTel;
	}

	public void setCouTel(String couTel) {
		this.couTel = couTel;
	}

	@Column(name = "CouDes", length = 160)
	public String getCouDes() {
		return this.couDes;
	}

	public void setCouDes(String couDes) {
		this.couDes = couDes;
	}

	@Column(name = "Notes", length = 150)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}