package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nusersearched entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nusersearched", catalog = "heartapp")
public class Nusersearched implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8172895061661580043L;
	private Integer idUserSearched;
	private Integer idUser;
	private String searchInfo;
	private String searchSql;
	private Integer searchResult;
	private Timestamp searchTime;
	private String notes;

	// Constructors

	/** default constructor */
	public Nusersearched() {
	}

	/** minimal constructor */
	public Nusersearched(Integer idUser, Timestamp searchTime) {
		this.idUser = idUser;
		this.searchTime = searchTime;
	}

	/** full constructor */
	public Nusersearched(Integer idUser, String searchInfo, String searchSql,
			Integer searchResult, Timestamp searchTime, String notes) {
		this.idUser = idUser;
		this.searchInfo = searchInfo;
		this.searchSql = searchSql;
		this.searchResult = searchResult;
		this.searchTime = searchTime;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUserSearched", unique = true, nullable = false)
	public Integer getIdUserSearched() {
		return this.idUserSearched;
	}

	public void setIdUserSearched(Integer idUserSearched) {
		this.idUserSearched = idUserSearched;
	}

	@Column(name = "idUser", nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "SearchInfo", length = 45)
	public String getSearchInfo() {
		return this.searchInfo;
	}

	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}

	@Column(name = "SearchSQL", length = 45)
	public String getSearchSql() {
		return this.searchSql;
	}

	public void setSearchSql(String searchSql) {
		this.searchSql = searchSql;
	}

	@Column(name = "SearchResult")
	public Integer getSearchResult() {
		return this.searchResult;
	}

	public void setSearchResult(Integer searchResult) {
		this.searchResult = searchResult;
	}

	@Column(name = "SearchTime", nullable = false, length = 19)
	public Timestamp getSearchTime() {
		return this.searchTime;
	}

	public void setSearchTime(Timestamp searchTime) {
		this.searchTime = searchTime;
	}

	@Column(name = "Notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}