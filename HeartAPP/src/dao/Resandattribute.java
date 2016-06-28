package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resandattribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resandattribute", catalog = "heartapp")
public class Resandattribute implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1635927074263111910L;
	private Integer idResAndAttribute;
	private Integer idResource;
	private Integer idAttribute;
	private String resAtrDes;

	// Constructors

	/** default constructor */
	public Resandattribute() {
	}

	/** minimal constructor */
	public Resandattribute(Integer idResource, Integer idAttribute) {
		this.idResource = idResource;
		this.idAttribute = idAttribute;
	}

	/** full constructor */
	public Resandattribute(Integer idResource, Integer idAttribute,
			String resAtrDes) {
		this.idResource = idResource;
		this.idAttribute = idAttribute;
		this.resAtrDes = resAtrDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idResAndAttribute", unique = true, nullable = false)
	public Integer getIdResAndAttribute() {
		return this.idResAndAttribute;
	}

	public void setIdResAndAttribute(Integer idResAndAttribute) {
		this.idResAndAttribute = idResAndAttribute;
	}

	@Column(name = "idResource", nullable = false)
	public Integer getIdResource() {
		return this.idResource;
	}

	public void setIdResource(Integer idResource) {
		this.idResource = idResource;
	}

	@Column(name = "idAttribute", nullable = false)
	public Integer getIdAttribute() {
		return this.idAttribute;
	}

	public void setIdAttribute(Integer idAttribute) {
		this.idAttribute = idAttribute;
	}

	@Column(name = "ResAtrDes", length = 150)
	public String getResAtrDes() {
		return this.resAtrDes;
	}

	public void setResAtrDes(String resAtrDes) {
		this.resAtrDes = resAtrDes;
	}

}