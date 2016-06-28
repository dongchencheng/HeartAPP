package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Positivesuggestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "positivesuggestion", catalog = "heartapp")
public class Positivesuggestion implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3042156617989339958L;
	private Integer idPositiveSuggestion;
	private String positiveContent;
	private String positiveImage;
	private Integer idResource;
	private String notes;

	// Constructors

	/** default constructor */
	public Positivesuggestion() {
	}

	/** minimal constructor */
	public Positivesuggestion(Integer idResource) {
		this.idResource = idResource;
	}

	/** full constructor */
	public Positivesuggestion(String positiveContent, String positiveImage,
			Integer idResource, String notes) {
		this.positiveContent = positiveContent;
		this.positiveImage = positiveImage;
		this.idResource = idResource;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPositiveSuggestion", unique = true, nullable = false)
	public Integer getIdPositiveSuggestion() {
		return this.idPositiveSuggestion;
	}

	public void setIdPositiveSuggestion(Integer idPositiveSuggestion) {
		this.idPositiveSuggestion = idPositiveSuggestion;
	}

	@Column(name = "PositiveContent", length = 100)
	public String getPositiveContent() {
		return this.positiveContent;
	}

	public void setPositiveContent(String positiveContent) {
		this.positiveContent = positiveContent;
	}

	@Column(name = "PositiveImage", length = 100)
	public String getPositiveImage() {
		return this.positiveImage;
	}

	public void setPositiveImage(String positiveImage) {
		this.positiveImage = positiveImage;
	}

	@Column(name = "idResource", nullable = false)
	public Integer getIdResource() {
		return this.idResource;
	}

	public void setIdResource(Integer idResource) {
		this.idResource = idResource;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}