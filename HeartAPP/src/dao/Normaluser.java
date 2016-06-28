package dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Normaluser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "normaluser", catalog = "heartapp")
public class Normaluser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3974537481926472838L;
	private Integer idUser;
	private String userName;
	private String nickName;
	private String passWord;
	private String deviceId;
	private String cpuid;
	private Timestamp createTime;
	private Timestamp birthDay;
	private Integer age;
	private String country;
	private String province;
	private String city;
	private String zone;
	private Integer idUserLevel;
	private Integer userScore;
	private String idStatus;
	private String curPic;
	private Integer idCreateType;
	private String notes;

	// Constructors

	/** default constructor */
	public Normaluser() {
	}

	/** minimal constructor */
	public Normaluser(String deviceId, String cpuid, Integer idUserLevel,
			Integer userScore, String idStatus, Integer idCreateType) {
		this.deviceId = deviceId;
		this.cpuid = cpuid;
		this.idUserLevel = idUserLevel;
		this.userScore = userScore;
		this.idStatus = idStatus;
		this.idCreateType = idCreateType;
	}

	/** full constructor */
	public Normaluser(String userName, String nickName, String passWord,
			String deviceId, String cpuid, Timestamp createTime,
			Timestamp birthDay, Integer age, String country, String province,
			String city, String zone, Integer idUserLevel, Integer userScore,
			String idStatus, String curPic, Integer idCreateType, String notes) {
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.deviceId = deviceId;
		this.cpuid = cpuid;
		this.createTime = createTime;
		this.birthDay = birthDay;
		this.age = age;
		this.country = country;
		this.province = province;
		this.city = city;
		this.zone = zone;
		this.idUserLevel = idUserLevel;
		this.userScore = userScore;
		this.idStatus = idStatus;
		this.curPic = curPic;
		this.idCreateType = idCreateType;
		this.notes = notes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "UserName", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "NickName", length = 30)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "PassWord", length = 20)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "DeviceID", nullable = false, length = 45)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "CPUID", nullable = false, length = 45)
	public String getCpuid() {
		return this.cpuid;
	}

	public void setCpuid(String cpuid) {
		this.cpuid = cpuid;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "BirthDay", length = 19)
	public Timestamp getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name = "Age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "Country", length = 30)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Province", length = 30)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "City", length = 30)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Zone", length = 30)
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "idUserLevel", nullable = false)
	public Integer getIdUserLevel() {
		return this.idUserLevel;
	}

	public void setIdUserLevel(Integer idUserLevel) {
		this.idUserLevel = idUserLevel;
	}

	@Column(name = "UserScore", nullable = false)
	public Integer getUserScore() {
		return this.userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	@Column(name = "idStatus", nullable = false, length = 45)
	public String getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	@Column(name = "CurPic", length = 45)
	public String getCurPic() {
		return this.curPic;
	}

	public void setCurPic(String curPic) {
		this.curPic = curPic;
	}

	@Column(name = "idCreateType", nullable = false)
	public Integer getIdCreateType() {
		return this.idCreateType;
	}

	public void setIdCreateType(Integer idCreateType) {
		this.idCreateType = idCreateType;
	}

	@Column(name = "Notes", length = 100)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}