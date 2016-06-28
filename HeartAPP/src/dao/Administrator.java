package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "administrator", catalog = "heartapp", uniqueConstraints = @UniqueConstraint(columnNames = "adminname"))
public class Administrator implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5852358292545301724L;
	private Integer idAdministrator;
	private String adminname;
	private String password;
	private Integer level;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** full constructor */
	public Administrator(String adminname, String password, Integer level) {
		this.adminname = adminname;
		this.password = password;
		this.level = level;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAdministrator", unique = true, nullable = false)
	public Integer getIdAdministrator() {
		return this.idAdministrator;
	}

	public void setIdAdministrator(Integer idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	@Column(name = "adminname", unique = true, nullable = false, length = 16)
	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "level", nullable = false)
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}