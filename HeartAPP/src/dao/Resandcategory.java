package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resandcategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resandcategory", catalog = "heartapp")
public class Resandcategory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476559732809565104L;
	private Integer idResAndCategory;
	private Integer idCategory;
	private Integer idResource;
	private String resCatDes;

	// Constructors

	/** default constructor */
	public Resandcategory() {
	}

	/** minimal constructor */
	public Resandcategory(Integer idCategory, Integer idResource) {
		this.idCategory = idCategory;
		this.idResource = idResource;
	}

	/** full constructor */
	public Resandcategory(Integer idCategory, Integer idResource,
			String resCatDes) {
		this.idCategory = idCategory;
		this.idResource = idResource;
		this.resCatDes = resCatDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idResAndCategory", unique = true, nullable = false)
	public Integer getIdResAndCategory() {
		return this.idResAndCategory;
	}

	public void setIdResAndCategory(Integer idResAndCategory) {
		this.idResAndCategory = idResAndCategory;
	}

	@Column(name = "idCategory", nullable = false)
	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "idResource", nullable = false)
	public Integer getIdResource() {
		return this.idResource;
	}

	public void setIdResource(Integer idResource) {
		this.idResource = idResource;
	}

	@Column(name = "ResCatDes", length = 150)
	public String getResCatDes() {
		return this.resCatDes;
	}

	public void setResCatDes(String resCatDes) {
		this.resCatDes = resCatDes;
	}

}