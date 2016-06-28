package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usercreatetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usercreatetype", catalog = "heartapp")
public class Usercreatetype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -623612360250632983L;
	private Integer idUserCreateType;
	private String userCreateTypeName;
	private String userCreateTypeDes;

	// Constructors

	/** default constructor */
	public Usercreatetype() {
	}

	/** minimal constructor */
	public Usercreatetype(String userCreateTypeName) {
		this.userCreateTypeName = userCreateTypeName;
	}

	/** full constructor */
	public Usercreatetype(String userCreateTypeName, String userCreateTypeDes) {
		this.userCreateTypeName = userCreateTypeName;
		this.userCreateTypeDes = userCreateTypeDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserCreateType", unique = true, nullable = false)
	public Integer getIdUserCreateType() {
		return this.idUserCreateType;
	}

	public void setIdUserCreateType(Integer idUserCreateType) {
		this.idUserCreateType = idUserCreateType;
	}

	@Column(name = "UserCreateTypeName", nullable = false, length = 30)
	public String getUserCreateTypeName() {
		return this.userCreateTypeName;
	}

	public void setUserCreateTypeName(String userCreateTypeName) {
		this.userCreateTypeName = userCreateTypeName;
	}

	@Column(name = "UserCreateTypeDes", length = 100)
	public String getUserCreateTypeDes() {
		return this.userCreateTypeDes;
	}

	public void setUserCreateTypeDes(String userCreateTypeDes) {
		this.userCreateTypeDes = userCreateTypeDes;
	}

}