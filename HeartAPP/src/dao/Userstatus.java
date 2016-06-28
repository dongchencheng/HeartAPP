package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userstatus", catalog = "heartapp")
public class Userstatus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4150808698319633426L;
	private Integer idUserStatus;
	private String userStatusName;
	private String userStatusDes;

	// Constructors

	/** default constructor */
	public Userstatus() {
	}

	/** minimal constructor */
	public Userstatus(String userStatusName) {
		this.userStatusName = userStatusName;
	}

	/** full constructor */
	public Userstatus(String userStatusName, String userStatusDes) {
		this.userStatusName = userStatusName;
		this.userStatusDes = userStatusDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserStatus", unique = true, nullable = false)
	public Integer getIdUserStatus() {
		return this.idUserStatus;
	}

	public void setIdUserStatus(Integer idUserStatus) {
		this.idUserStatus = idUserStatus;
	}

	@Column(name = "UserStatusName", nullable = false, length = 30)
	public String getUserStatusName() {
		return this.userStatusName;
	}

	public void setUserStatusName(String userStatusName) {
		this.userStatusName = userStatusName;
	}

	@Column(name = "UserStatusDes", length = 45)
	public String getUserStatusDes() {
		return this.userStatusDes;
	}

	public void setUserStatusDes(String userStatusDes) {
		this.userStatusDes = userStatusDes;
	}

}