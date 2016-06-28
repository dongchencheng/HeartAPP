package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nuserliked entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nuserliked", catalog = "heartapp")
public class Nuserliked implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -419836391397746307L;
	private Integer idUserLiked;
	private Integer idUser;
	private Integer idResource;
	private Timestamp likeTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nuserliked() {
	}

	/** minimal constructor */
	public Nuserliked(Integer idUser, Integer idResource, Timestamp likeTime) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.likeTime = likeTime;
	}

	/** full constructor */
	public Nuserliked(Integer idUser, Integer idResource, Timestamp likeTime,
			String notes) {
		this.idUser = idUser;
		this.idResource = idResource;
		this.likeTime = likeTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserLiked", unique = true, nullable = false)
	public Integer getIdUserLiked() {
		return this.idUserLiked;
	}

	public void setIdUserLiked(Integer idUserLiked) {
		this.idUserLiked = idUserLiked;
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

	@Column(name = "LikeTime", nullable = false, length = 19)
	public Timestamp getLikeTime() {
		return this.likeTime;
	}

	public void setLikeTime(Timestamp likeTime) {
		this.likeTime = likeTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}