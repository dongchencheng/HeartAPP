package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nuserclicked entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nuserclicked", catalog = "heartapp")
public class Nuserclicked implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7735087332547743199L;
	private Integer idUserClicked;
	private Integer idUser;
	private Integer idResource;
	private Timestamp clickTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nuserclicked() {
	}

	/** minimal constructor */
	public Nuserclicked(Integer idUser, Integer idResource, Timestamp clickTime) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.clickTime = clickTime;
	}

	/** full constructor */
	public Nuserclicked(Integer idUser, Integer idResource,
			Timestamp clickTime, String notes) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.clickTime = clickTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserClicked", unique = true, nullable = false)
	public Integer getIdUserClicked() {
		return this.idUserClicked;
	}

	public void setIdUserClicked(Integer idUserClicked) {
		this.idUserClicked = idUserClicked;
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

	@Column(name = "ClickTime", nullable = false, length = 19)
	public Timestamp getClickTime() {
		return this.clickTime;
	}

	public void setClickTime(Timestamp clickTime) {
		this.clickTime = clickTime;
	}

	@Column(name = "Notes", length = 45)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}