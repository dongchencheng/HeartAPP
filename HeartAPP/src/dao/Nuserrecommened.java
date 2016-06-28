package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nuserrecommened entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nuserrecommened", catalog = "heartapp")
public class Nuserrecommened implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549441698714606826L;
	private Integer idUserRecommened;
	private Integer idUser;
	private Integer idResource;
	private String listenStatus;
	private Timestamp createTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nuserrecommened() {
	}

	/** minimal constructor */
	public Nuserrecommened(Integer idUser, Integer idResource,
			Timestamp createTime) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.createTime = createTime;
	}

	/** full constructor */
	public Nuserrecommened(Integer idUser, Integer idResource,
			String listenStatus, Timestamp createTime, String notes) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.listenStatus = listenStatus;
		this.createTime = createTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserRecommened", unique = true, nullable = false)
	public Integer getIdUserRecommened() {
		return this.idUserRecommened;
	}

	public void setIdUserRecommened(Integer idUserRecommened) {
		this.idUserRecommened = idUserRecommened;
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

	@Column(name = "ListenStatus", length = 45)
	public String getListenStatus() {
		return this.listenStatus;
	}

	public void setListenStatus(String listenStatus) {
		this.listenStatus = listenStatus;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}