package action.counselor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import server.CBoCounselor;
import action.RegEx;
import com.opensymphony.xwork2.ActionSupport;

import dao.Counselor;
import dao.Franchisee;
import dao.HibernateSessionFactory;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.27
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class CounselorAction extends ActionSupport {
	// 心理咨询师action

	private static final long serialVersionUID = 1561280561794567554L;
	
	private int idCounselor;
	private int idFranchisee;
	private String couName;
	private String couCard;
	private String couTel;
	private String couDes;
	private String notes;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Counselor> list;// 显示列表
	private Counselor counselor;// 返回给修改界面
	private List<Franchisee> franchiseeList;// 资源列表
	
	private String SidFranchisee = "";// 搜索加盟商ID
	
	public int getIdCounselor() {
		return idCounselor;
	}
	public void setIdCounselor(int idCounselor) {
		this.idCounselor = idCounselor;
	}
	public int getIdFranchisee() {
		return idFranchisee;
	}
	public void setIdFranchisee(int idFranchisee) {
		this.idFranchisee = idFranchisee;
	}
	public String getCouName() {
		return couName;
	}
	public void setCouName(String couName) {
		this.couName = couName;
	}
	public String getCouCard() {
		return couCard;
	}
	public void setCouCard(String couCard) {
		this.couCard = couCard;
	}
	public String getCouTel() {
		return couTel;
	}
	public void setCouTel(String couTel) {
		this.couTel = couTel;
	}
	public String getCouDes() {
		return couDes;
	}
	public void setCouDes(String couDes) {
		this.couDes = couDes;
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
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public List<Counselor> getList() {
		return list;
	}
	public void setList(List<Counselor> list) {
		this.list = list;
	}
	public Counselor getCounselor() {
		return counselor;
	}
	public void setCounselor(Counselor counselor) {
		this.counselor = counselor;
	}
	public List<Franchisee> getFranchiseeList() {
		return franchiseeList;
	}
	public void setFranchiseeList(List<Franchisee> franchiseeList) {
		this.franchiseeList = franchiseeList;
	}
	public String getSidFranchisee() {
		return SidFranchisee;
	}
	public void setSidFranchisee(String sidFranchisee) {
		SidFranchisee = sidFranchisee;
	}

	// 添加验证
	public String validateInsert() {
		if (couName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (couName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}

	// 添加
	public String insert() {

		// 新建Counselor对象并赋值
		Counselor counselor = new Counselor();
		counselor.setIdFranchisee(idFranchisee);
		counselor.setCouName(couName);
		counselor.setCouCard(couCard);
		counselor.setCouTel(couTel);
		counselor.setCouDes(couDes);
		counselor.setNotes(notes);

		CBoCounselor cbo = new CBoCounselor();
		cbo.insertCounselor(counselor);
		
		//查询记录个数并跳转最后一页
		int temp = cbo.countCounselor("");
		if(temp%10==0){
			page = temp/10;
		}else{
			page = temp/10+1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Counselor对象并赋值
		Counselor counselor = new Counselor();
		counselor.setIdCounselor(idCounselor);
		counselor.setIdFranchisee(idFranchisee);
		counselor.setCouName(couName);
		counselor.setCouCard(couCard);
		counselor.setCouTel(couTel);
		counselor.setCouDes(couDes);
		counselor.setNotes(notes);

		CBoCounselor cbo = new CBoCounselor();
		cbo.updateCounselor(counselor);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		// 检查是否有搜索词
		if(!SidFranchisee.equals("")){
			
			// 删除特殊字符
			SidFranchisee = RegEx.deleteSpecial(SidFranchisee);
			
			words=" where idFranchisee = "+SidFranchisee;
		}

		CBoCounselor cbo = new CBoCounselor();
		int temp = cbo.countCounselor(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchCounselorByWords(words, page));
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoCounselor cbo = new CBoCounselor();
		counselor = cbo.searchCounselorById(idCounselor);
		searchFranchisee();
		return "searchById";
	}
	
	// 查找加盟商列表
	@SuppressWarnings("unchecked")
	public String searchFranchisee() {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Franchisee");
			franchiseeList = (List<Franchisee>) query.list();
		} catch (Exception e) {
			System.out.println("查找加盟商列表出错");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "searchFranchisee";
	}

	// 删除
	public String delete() {

		CBoCounselor cbo = new CBoCounselor();
		cbo.deleteCounselorById(idCounselor);
		
		// 搜索关键词
		String words = "";
		
		/**
		 * 这里添加搜索词的原因是防止页数发生错误
		 * 
		 * 因为在删除后返回界面时，显示的是使用搜索词过滤后的列表，
		 * 而这里若果不用搜索词返回页数，会出现BUG
		 * */
		// 检查是否有搜索词
		if (!SidFranchisee.equals("")) {

			// 删除特殊字符
			SidFranchisee = RegEx.deleteSpecial(SidFranchisee);

			words = " where idFranchisee = " + SidFranchisee;
		}

		// 查询记录个数
		int temp = cbo.countCounselor(words);
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
