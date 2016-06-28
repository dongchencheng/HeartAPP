package action.franchisee;

import java.util.List;
import server.CBoFranchisee;
import action.RegEx;
import com.opensymphony.xwork2.ActionSupport;

import dao.Franchisee;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.3
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class FranchiseeAction extends ActionSupport {
	// 加盟商action

	private static final long serialVersionUID = 1561280561794567554L;
	
	private int idFranchisee;
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
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Franchisee> list;// 显示列表
	private Franchisee franchisee;// 返回给修改界面
	
	private String SadminName = "";// 搜索负责人字段
	private String SfrName = "";// 搜索加盟商字段

	public int getIdFranchisee() {
		return idFranchisee;
	}
	public void setIdFranchisee(int idFranchisee) {
		this.idFranchisee = idFranchisee;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminTel() {
		return adminTel;
	}
	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCountry() {
		return frCountry;
	}
	public void setFrCountry(String frCountry) {
		this.frCountry = frCountry;
	}
	public String getFrProvience() {
		return frProvience;
	}
	public void setFrProvience(String frProvience) {
		this.frProvience = frProvience;
	}
	public String getFrDes() {
		return frDes;
	}
	public void setFrDes(String frDes) {
		this.frDes = frDes;
	}
	public String getFrAddress() {
		return frAddress;
	}
	public void setFrAddress(String frAddress) {
		this.frAddress = frAddress;
	}
	public String getFrIcon() {
		return frIcon;
	}
	public void setFrIcon(String frIcon) {
		this.frIcon = frIcon;
	}
	public String getFrImage1() {
		return frImage1;
	}
	public void setFrImage1(String frImage1) {
		this.frImage1 = frImage1;
	}
	public String getFrImage2() {
		return frImage2;
	}
	public void setFrImage2(String frImage2) {
		this.frImage2 = frImage2;
	}
	public String getFrImage3() {
		return frImage3;
	}
	public void setFrImage3(String frImage3) {
		this.frImage3 = frImage3;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Franchisee> getList() {
		return list;
	}
	public void setList(List<Franchisee> list) {
		this.list = list;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public Franchisee getFranchisee() {
		return franchisee;
	}
	public void setFranchisee(Franchisee franchisee) {
		this.franchisee = franchisee;
	}
	public String getSadminName() {
		return SadminName;
	}
	public void setSadminName(String sadminName) {
		SadminName = sadminName;
	}
	public String getSfrName() {
		return SfrName;
	}
	public void setSfrName(String sfrName) {
		SfrName = sfrName;
	}

	// 添加验证
	public String validateInsert() {
		if (frName.equals("") || adminName.equals("") || adminTel.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (frName.equals("") || adminName.equals("") || adminTel.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}

	// 添加
	public String insert() {

		// 新建Franchisee对象并赋值
		Franchisee franchisee = new Franchisee();
		franchisee.setAdminName(adminName);
		franchisee.setAdminTel(adminTel);
		franchisee.setFrName(frName);
		franchisee.setFrCountry(frCountry);
		franchisee.setFrProvience(frProvience);
		franchisee.setFrDes(frDes);
		franchisee.setFrAddress(frAddress);
		franchisee.setNotes(notes);

		CBoFranchisee cbo = new CBoFranchisee();
		cbo.insertFranchisee(franchisee);
		
		//查询记录个数并跳转最后一页
		int temp = cbo.countFranchisee("");
		if(temp%10==0){
			page = temp/10;
		}else{
			page = temp/10+1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Franchisee对象并赋值
		Franchisee franchisee = new Franchisee();
		franchisee.setIdFranchisee(idFranchisee);
		franchisee.setAdminName(adminName);
		franchisee.setAdminTel(adminTel);
		franchisee.setFrName(frName);
		franchisee.setFrCountry(frCountry);
		franchisee.setFrProvience(frProvience);
		franchisee.setFrDes(frDes);
		franchisee.setFrAddress(frAddress);
		franchisee.setNotes(notes);

		CBoFranchisee cbo = new CBoFranchisee();
		cbo.updateFranchisee(franchisee);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		// 检查是否有搜索词
		if(!(SadminName.equals("")&&SfrName.equals(""))){
			
			// 删除特殊字符
			SadminName = RegEx.deleteSpecial(SadminName);
			SfrName = RegEx.deleteSpecial(SfrName);
			
			words=" where adminName like '%"+SadminName+"%'"+"and frName like '%"+SfrName+"%'";
		}

		CBoFranchisee cbo = new CBoFranchisee();
		int temp = cbo.countFranchisee(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchFranchiseeByWords(words, page));
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoFranchisee cbo = new CBoFranchisee();
		franchisee = cbo.searchFranchiseeById(idFranchisee);
		return "searchById";
	}

	// 删除
	public String delete() {

		CBoFranchisee cbo = new CBoFranchisee();
		cbo.deleteFranchiseeById(idFranchisee);
		
		// 搜索关键词
		String words = "";
		
		/**
		 * 这里添加搜索词的原因是防止页数发生错误
		 * 
		 * 因为在删除后返回界面时，显示的是使用搜索词过滤后的列表，
		 * 而这里若果不用搜索词返回页数，会出现BUG
		 * */
		// 检查是否有搜索词
		if (!(SadminName.equals("") && SfrName.equals(""))) {

			// 删除特殊字符
			SadminName = RegEx.deleteSpecial(SadminName);
			SfrName = RegEx.deleteSpecial(SfrName);

			words = " where adminName like '%" + SadminName + "%'"
					+ "and frName like '%" + SfrName + "%'";
		}

		// 查询记录个数
		int temp = cbo.countFranchisee(words);
		int lastpage;// 最后一页页数
		if (temp % 10 == 0) {
			lastpage = temp / 10;
		} else {
			lastpage = temp / 10 + 1;
		}

		// 如果删除的是最后一页最后一条记录，则跳转前一页
		if (lastpage < page) {
			page = lastpage;
		}
		return execute();
	}
	
}
