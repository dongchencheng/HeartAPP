package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resattributes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resattributes", catalog = "heartapp")
public class Resattributes implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3047796733757370143L;
	private Integer idResAttributes;
	private Integer idResCategory;
	private String attributeName;
	private String attributeDes;

	// Constructors

	/** default constructor */
	public Resattributes() {
	}

	/** minimal constructor */
	public Resattributes(Integer idResCategory, String attributeName) {
		this.idResCategory = idResCategory;
		this.attributeName = attributeName;
	}

	/** full constructor */
	public Resattributes(Integer idResCategory, String attributeName,
			String attributeDes) {
		this.idResCategory = idResCategory;
		this.attributeName = attributeName;
		this.attributeDes = attributeDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idResAttributes", unique = true, nullable = false)
	public Integer getIdResAttributes() {
		return this.idResAttributes;
	}

	public void setIdResAttributes(Integer idResAttributes) {
		this.idResAttributes = idResAttributes;
	}

	@Column(name = "idResCategory", nullable = false)
	public Integer getIdResCategory() {
		return this.idResCategory;
	}

	public void setIdResCategory(Integer idResCategory) {
		this.idResCategory = idResCategory;
	}

	@Column(name = "AttributeName", nullable = false, length = 45)
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "AttributeDes", length = 150)
	public String getAttributeDes() {
		return this.attributeDes;
	}

	public void setAttributeDes(String attributeDes) {
		this.attributeDes = attributeDes;
	}

}