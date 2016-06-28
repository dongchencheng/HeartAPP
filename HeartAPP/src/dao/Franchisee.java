package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Franchisee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "franchisee", catalog = "heartapp")
public class Franchisee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6033945055447563927L;
	private Integer idFranchisee;
	private String adminName;
	private String adminTel;
	private String frName;
	private String frCountry;
	private String frProvience;
	private String frDes;
	private String frAddress;
	private String frIcon;
	private String frImage1;
	private String frImage2;
	private String frImage3;
	private String notes;

	// Constructors

	/** default constructor */
	public Franchisee() {
	}

	/** full constructor */
	public Franchisee(String adminName, String adminTel, String frName,
			String frCountry, String frProvience, String frDes,
			String frAddress, String frIcon, String frImage1, String frImage2,
			String frImage3, String notes) {
		this.adminName = adminName;
		this.adminTel = adminTel;
		this.frName = frName;
		this.frCountry = frCountry;
		this.frProvience = frProvience;
		this.frDes = frDes;
		this.frAddress = frAddress;
		this.frIcon = frIcon;
		this.frImage1 = frImage1;
		this.frImage2 = frImage2;
		this.frImage3 = frImage3;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFranchisee", unique = true, nullable = false)
	public Integer getIdFranchisee() {
		return this.idFranchisee;
	}

	public void setIdFranchisee(Integer idFranchisee) {
		this.idFranchisee = idFranchisee;
	}

	@Column(name = "AdminName", length = 30)
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "AdminTel", length = 30)
	public String getAdminTel() {
		return this.adminTel;
	}

	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}

	@Column(name = "FrName", length = 50)
	public String getFrName() {
		return this.frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Column(name = "FrCountry", length = 30)
	public String getFrCountry() {
		return this.frCountry;
	}

	public void setFrCountry(String frCountry) {
		this.frCountry = frCountry;
	}

	@Column(name = "FrProvience", length = 30)
	public String getFrProvience() {
		return this.frProvience;
	}

	public void setFrProvience(String frProvience) {
		this.frProvience = frProvience;
	}

	@Column(name = "FrDes", length = 100)
	public String getFrDes() {
		return this.frDes;
	}

	public void setFrDes(String frDes) {
		this.frDes = frDes;
	}

	@Column(name = "FrAddress", length = 100)
	public String getFrAddress() {
		return this.frAddress;
	}

	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}

	@Column(name = "FrICON", length = 160)
	public String getFrIcon() {
		return this.frIcon;
	}

	public void setFrIcon(String frIcon) {
		this.frIcon = frIcon;
	}

	@Column(name = "FrImage1", length = 160)
	public String getFrImage1() {
		return this.frImage1;
	}

	public void setFrImage1(String frImage1) {
		this.frImage1 = frImage1;
	}

	@Column(name = "FrImage2", length = 160)
	public String getFrImage2() {
		return this.frImage2;
	}

	public void setFrImage2(String frImage2) {
		this.frImage2 = frImage2;
	}

	@Column(name = "FrImage3", length = 160)
	public String getFrImage3() {
		return this.frImage3;
	}

	public void setFrImage3(String frImage3) {
		this.frImage3 = frImage3;
	}

	@Column(name = "Notes", length = 150)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}