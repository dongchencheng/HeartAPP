package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userlevel", catalog = "heartapp")
public class Userlevel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8689876619802169662L;
	private Integer idUserLevel;
	private String userLevelName;
	private String userLevelDes;

	// Constructors

	/** default constructor */
	public Userlevel() {
	}

	/** minimal constructor */
	public Userlevel(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	/** full constructor */
	public Userlevel(String userLevelName, String userLevelDes) {
		this.userLevelName = userLevelName;
		this.userLevelDes = userLevelDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserLevel", unique = true, nullable = false)
	public Integer getIdUserLevel() {
		return this.idUserLevel;
	}

	public void setIdUserLevel(Integer idUserLevel) {
		this.idUserLevel = idUserLevel;
	}

	@Column(name = "UserLevelName", nullable = false, length = 30)
	public String getUserLevelName() {
		return this.userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	@Column(name = "UserLevelDes", length = 100)
	public String getUserLevelDes() {
		return this.userLevelDes;
	}

	public void setUserLevelDes(String userLevelDes) {
		this.userLevelDes = userLevelDes;
	}

}