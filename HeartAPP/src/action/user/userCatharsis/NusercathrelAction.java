package action.user.userCatharsis;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import server.CBoNormaluser;
import server.CBoNusercathrel;
import server.CBoPositivesuggestion;

import com.opensymphony.xwork2.ActionSupport;

import dao.HibernateSessionFactory;
import dao.Nusercathrel;
import dao.Positivesuggestion;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.24
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NusercathrelAction extends ActionSupport {
	// 宣泄关系action

	private static final long serialVersionUID = -1717045578273433153L;
	
	private int idNuserCathRel;
	private int idNuser;
	private int idCatharsis;
	private int idPositiveSuggestion;
	private String notes;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNusercathrel> list;// 显示列表
	private Nusercathrel nusercathrel;// 返回给修改界面
	private List<Positivesuggestion> positiveList;// 积极暗示列表
	
	private String SidCatharsis = "";// 搜索宣泄信息ID
	
	public int getIdNuserCathRel() {
		return idNuserCathRel;
	}
	public void setIdNuserCathRel(int idNuserCathRel) {
		this.idNuserCathRel = idNuserCathRel;
	}
	public int getIdNuser() {
		return idNuser;
	}
	public void setIdNuser(int idNuser) {
		this.idNuser = idNuser;
	}
	public int getIdCatharsis() {
		return idCatharsis;
	}
	public void setIdCatharsis(int idCatharsis) {
		this.idCatharsis = idCatharsis;
	}
	public int getIdPositiveSuggestion() {
		return idPositiveSuggestion;
	}
	public void setIdPositiveSuggestion(int idPositiveSuggestion) {
		this.idPositiveSuggestion = idPositiveSuggestion;
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
	public List<DtoNusercathrel> getList() {
		return list;
	}
	public void setList(List<DtoNusercathrel> list) {
		this.list = list;
	}
	public Nusercathrel getNusercathrel() {
		return nusercathrel;
	}
	public void setNusercathrel(Nusercathrel nusercathrel) {
		this.nusercathrel = nusercathrel;
	}
	public String getSidCatharsis() {
		return SidCatharsis;
	}
	public void setSidCatharsis(String sidCatharsis) {
		SidCatharsis = sidCatharsis;
	}
	public List<Positivesuggestion> getPositiveList() {
		return positiveList;
	}
	public void setPositiveList(List<Positivesuggestion> positiveList) {
		this.positiveList = positiveList;
	}
	
	// 添加
	public String insert() {

		// 新建Nusercathrel对象并赋值
		Nusercathrel nusercathrel = new Nusercathrel();
		nusercathrel.setIdNuser(idNuser);
		nusercathrel.setIdCatharsis(idCatharsis);
		nusercathrel.setIdPositiveSuggestion(idPositiveSuggestion);
		nusercathrel.setResponseTime(new Timestamp(System.currentTimeMillis()));
		nusercathrel.setNotes(notes);

		CBoNusercathrel cbo = new CBoNusercathrel();
		cbo.insertNusercathrel(nusercathrel);
		
		//查询记录个数并跳转最后一页
		int temp = cbo.countNusercathrel("");
		if(temp%10==0){
			page = temp/10;
		}else{
			page = temp/10+1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Nusercathrel对象并赋值
		Nusercathrel nusercathrel = new Nusercathrel();
		nusercathrel.setIdNuserCathRel(idNuserCathRel);
		nusercathrel.setIdNuser(idNuser);
		nusercathrel.setIdCatharsis(idCatharsis);
		nusercathrel.setIdPositiveSuggestion(idPositiveSuggestion);
		nusercathrel.setResponseTime(new Timestamp(System.currentTimeMillis()));
		nusercathrel.setNotes(notes);

		CBoNusercathrel cbo = new CBoNusercathrel();
		cbo.updateNusercathrel(nusercathrel);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		// 检查是否有搜索词
		if(!SidCatharsis.equals("")){
			words=" where idCatharsis = "+SidCatharsis;
		}

		CBoNusercathrel cbo = new CBoNusercathrel();
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoPositivesuggestion cboPo = new CBoPositivesuggestion();
		
		int temp = cbo.countNusercathrel(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}

		// 获得Nusercathrel列表
		List<Nusercathrel> tList = cbo.searchNusercathrelByWords(words, page);
		
		list = new ArrayList<DtoNusercathrel>();
		
		// 存到dto列表中
		DtoNusercathrel dto;
		for(Nusercathrel a:tList){
			dto = new DtoNusercathrel();
			dto.nusercathrel = a;
			
			// 查找用户名
			dto.DUserName = cboUser.searchNormaluserById(a.getIdNuser()).getNickName();
			// 查找积极暗示文字
			dto.DpositiveContent = cboPo.searchPositivesuggestionById(a.getIdPositiveSuggestion()).getPositiveContent();
			
			list.add(dto);
		}

		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoNusercathrel cbo = new CBoNusercathrel();
		nusercathrel = cbo.searchNusercathrelById(idNuserCathRel);
		searchPositive();
		
		return "searchById";
	}
	
	// 查找积极暗示列表
	@SuppressWarnings("unchecked")
	public String searchPositive() {
		// 查找积极暗示列表
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Positivesuggestion");
			positiveList = (List<Positivesuggestion>) query.list();
		} catch (Exception e) {
			System.out.println("查找积极暗示列表出错");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "searchPositive";
	}

	// 删除
	public String delete() {

		CBoNusercathrel cbo = new CBoNusercathrel();
		cbo.deleteNusercathrelById(idNuserCathRel);
		
		// 搜索关键词
		String words = "";
		
		/**
		 * 这里添加搜索词的原因是防止页数发生错误
		 * 
		 * 因为在删除后返回界面时，显示的是使用搜索词过滤后的列表，
		 * 而这里若果不用搜索词返回页数，会出现BUG
		 * */
		// 检查是否有搜索词
		if(!SidCatharsis.equals("")){
			words=" where idCatharsis = "+SidCatharsis;
		}

		// 查询记录个数
		int temp = cbo.countNusercathrel(words);
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
	
	// dto类
	public class DtoNusercathrel{
		Nusercathrel nusercathrel;
		String DUserName;	// 用户名
		String DpositiveContent;	// 积极暗示文字
		// 必须有get，set方法，否则会出错
		public Nusercathrel getNusercathrel() {
			return nusercathrel;
		}
		public void setNusercathrel(Nusercathrel nusercathrel) {
			this.nusercathrel = nusercathrel;
		}
		public String getDUserName() {
			return DUserName;
		}
		public void setDUserName(String dUserName) {
			DUserName = dUserName;
		}
		public String getDpositiveContent() {
			return DpositiveContent;
		}
		public void setDpositiveContent(String dpositiveContent) {
			DpositiveContent = dpositiveContent;
		}
	}
	
}
