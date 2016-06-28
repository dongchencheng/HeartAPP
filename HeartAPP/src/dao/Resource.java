package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resource", catalog = "heartapp")
public class Resource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8140980497710418902L;
	private Integer idResource;
	private String resourceName;
	private String resourceBack;
	private String rescourceDes;
	private String author;
	private String httpImage1;
	private String httpImage2;
	private String httpImage3;
	private String rescourceAdd;
	private Timestamp publishTime;
	private String resourceBasType;
	private String resourceCreateType;
	private Integer idEdit;
	private String resContent;
	private String notes;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(String resourceName, String author, String rescourceAdd,
			Timestamp publishTime, String resourceBasType,
			String resourceCreateType, Integer idEdit) {
		this.resourceName = resourceName;
		this.author = author;
		this.rescourceAdd = rescourceAdd;
		this.publishTime = publishTime;
		this.resourceBasType = resourceBasType;
		this.resourceCreateType = resourceCreateType;
		this.idEdit = idEdit;
	}

	/** full constructor */
	public Resource(String resourceName, String resourceBack,
			String rescourceDes, String author, String httpImage1,
			String httpImage2, String httpImage3, String rescourceAdd,
			Timestamp publishTime, String resourceBasType,
			String resourceCreateType, Integer idEdit, String resContent,
			String notes) {
		this.resourceName = resourceName;
		this.resourceBack = resourceBack;
		this.rescourceDes = rescourceDes;
		this.author = author;
		this.httpImage1 = httpImage1;
		this.httpImage2 = httpImage2;
		this.httpImage3 = httpImage3;
		this.rescourceAdd = rescourceAdd;
		this.publishTime = publishTime;
		this.resourceBasType = resourceBasType;
		this.resourceCreateType = resourceCreateType;
		this.idEdit = idEdit;
		this.resContent = resContent;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idResource", unique = true, nullable = false)
	public Integer getIdResource() {
		return this.idResource;
	}

	public void setIdResource(Integer idResource) {
		this.idResource = idResource;
	}

	@Column(name = "ResourceName", nullable = false, length = 45)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "ResourceBack", length = 150)
	public String getResourceBack() {
		return this.resourceBack;
	}

	public void setResourceBack(String resourceBack) {
		this.resourceBack = resourceBack;
	}

	@Column(name = "RescourceDes", length = 150)
	public String getRescourceDes() {
		return this.rescourceDes;
	}

	public void setRescourceDes(String rescourceDes) {
		this.rescourceDes = rescourceDes;
	}

	@Column(name = "Author", nullable = false, length = 150)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "HttpImage1", length = 150)
	public String getHttpImage1() {
		return this.httpImage1;
	}

	public void setHttpImage1(String httpImage1) {
		this.httpImage1 = httpImage1;
	}

	@Column(name = "HttpImage2", length = 150)
	public String getHttpImage2() {
		return this.httpImage2;
	}

	public void setHttpImage2(String httpImage2) {
		this.httpImage2 = httpImage2;
	}

	@Column(name = "HttpImage3", length = 150)
	public String getHttpImage3() {
		return this.httpImage3;
	}

	public void setHttpImage3(String httpImage3) {
		this.httpImage3 = httpImage3;
	}

	@Column(name = "RescourceAdd", nullable = false, length = 150)
	public String getRescourceAdd() {
		return this.rescourceAdd;
	}

	public void setRescourceAdd(String rescourceAdd) {
		this.rescourceAdd = rescourceAdd;
	}

	@Column(name = "PublishTime", nullable = false, length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "ResourceBasType", nullable = false, length = 45)
	public String getResourceBasType() {
		return this.resourceBasType;
	}

	public void setResourceBasType(String resourceBasType) {
		this.resourceBasType = resourceBasType;
	}

	@Column(name = "ResourceCreateType", nullable = false, length = 45)
	public String getResourceCreateType() {
		return this.resourceCreateType;
	}

	public void setResourceCreateType(String resourceCreateType) {
		this.resourceCreateType = resourceCreateType;
	}

	@Column(name = "idEdit", nullable = false)
	public Integer getIdEdit() {
		return this.idEdit;
	}

	public void setIdEdit(Integer idEdit) {
		this.idEdit = idEdit;
	}

	@Column(name = "ResContent", length = 100)
	public String getResContent() {
		return this.resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
	}

	@Column(name = "Notes", length = 100)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}