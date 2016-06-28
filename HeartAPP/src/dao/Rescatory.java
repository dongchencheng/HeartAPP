package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rescatory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rescatory", catalog = "heartapp")
public class Rescatory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 713790235642238275L;
	// Fields

	private Integer idResCatory;
	private String categoryName;
	private String categoryDes;

	// Constructors

	/** default constructor */
	public Rescatory() {
	}

	/** minimal constructor */
	public Rescatory(String categoryName) {
		this.categoryName = categoryName;
	}

	/** full constructor */
	public Rescatory(String categoryName, String categoryDes) {
		this.categoryName = categoryName;
		this.categoryDes = categoryDes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idResCatory", unique = true, nullable = false)
	public Integer getIdResCatory() {
		return this.idResCatory;
	}

	public void setIdResCatory(Integer idResCatory) {
		this.idResCatory = idResCatory;
	}

	@Column(name = "CategoryName", nullable = false, length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "CategoryDes", length = 150)
	public String getCategoryDes() {
		return this.categoryDes;
	}

	public void setCategoryDes(String categoryDes) {
		this.categoryDes = categoryDes;
	}

}