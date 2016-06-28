package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Catharsis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "catharsis", catalog = "heartapp")
public class Catharsis implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1876538469445217251L;
	private Integer idCatharsis;
	private Integer idNuser;
	private Timestamp createTime;
	private String style;
	private String content;
	private String address;
	private String notes;

	// Constructors

	/** default constructor */
	public Catharsis() {
	}

	/** minimal constructor */
	public Catharsis(Integer idNuser, Timestamp createTime, String style) {
		this.idNuser = idNuser;
		this.createTime = createTime;
		this.style = style;
	}

	/** full constructor */
	public Catharsis(Integer idNuser, Timestamp createTime, String style,
			String content, String address, String notes) {
		this.idNuser = idNuser;
		this.createTime = createTime;
		this.style = style;
		this.content = content;
		this.address = address;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCatharsis", unique = true, nullable = false)
	public Integer getIdCatharsis() {
		return this.idCatharsis;
	}

	public void setIdCatharsis(Integer idCatharsis) {
		this.idCatharsis = idCatharsis;
	}

	@Column(name = "idNuser", nullable = false)
	public Integer getIdNuser() {
		return this.idNuser;
	}

	public void setIdNuser(Integer idNuser) {
		this.idNuser = idNuser;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Style", nullable = false, length = 45)
	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "Content", length = 45)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "Address", length = 150)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}