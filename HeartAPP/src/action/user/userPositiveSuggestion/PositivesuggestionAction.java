package action.user.userPositiveSuggestion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.CBoPositivesuggestion;
import server.CBoResource;
import action.RegEx;
import com.opensymphony.xwork2.ActionSupport;

import dao.HibernateSessionFactory;
import dao.Positivesuggestion;
import dao.Resource;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.25
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class PositivesuggestionAction extends ActionSupport {
	// 积极暗示action

	private static final long serialVersionUID = 1028899832910014459L;
	
	private int idPositiveSuggestion;
	private String positiveContent;
	private String positiveImage;
	private int idResource;
	private String notes;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoPositivesuggestion> list;// 显示列表
	private Positivesuggestion positivesuggestion;// 返回给修改界面
	private List<Resource> resourceList;// 资源列表
	
	private String SpositiveContent = "";// 搜索积极暗示文字

	public int getIdPositiveSuggestion() {
		return idPositiveSuggestion;
	}
	public void setIdPositiveSuggestion(int idPositiveSuggestion) {
		this.idPositiveSuggestion = idPositiveSuggestion;
	}
	public String getPositiveContent() {
		return positiveContent;
	}
	public void setPositiveContent(String positiveContent) {
		this.positiveContent = positiveContent;
	}
	public String getPositiveImage() {
		return positiveImage;
	}
	public void setPositiveImage(String positiveImage) {
		this.positiveImage = positiveImage;
	}
	public int getIdResource() {
		return idResource;
	}
	public void setIdResource(int idResource) {
		this.idResource = idResource;
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
	public List<DtoPositivesuggestion> getList() {
		return list;
	}
	public void setList(List<DtoPositivesuggestion> list) {
		this.list = list;
	}
	public Positivesuggestion getPositivesuggestion() {
		return positivesuggestion;
	}
	public void setPositivesuggestion(Positivesuggestion positivesuggestion) {
		this.positivesuggestion = positivesuggestion;
	}
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public String getSpositiveContent() {
		return SpositiveContent;
	}
	public void setSpositiveContent(String spositiveContent) {
		SpositiveContent = spositiveContent;
	}

	// 添加验证
	public String validateInsert() {
		if (positiveContent.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (positiveContent.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}

	// 添加
	public String insert() {

		// 新建Positivesuggestion对象并赋值
		Positivesuggestion positivesuggestion = new Positivesuggestion();
		positivesuggestion.setPositiveContent(positiveContent);
		positivesuggestion.setPositiveImage(positiveImage);
		positivesuggestion.setIdResource(idResource);
		positivesuggestion.setNotes(notes);

		CBoPositivesuggestion cbo = new CBoPositivesuggestion();
		cbo.insertPositivesuggestion(positivesuggestion);
		
		//查询记录个数并跳转最后一页
		int temp = cbo.countPositivesuggestion("");
		if(temp%10==0){
			page = temp/10;
		}else{
			page = temp/10+1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Positivesuggestion对象并赋值
		Positivesuggestion positivesuggestion = new Positivesuggestion();
		positivesuggestion.setIdPositiveSuggestion(idPositiveSuggestion);
		positivesuggestion.setPositiveContent(positiveContent);
		positivesuggestion.setPositiveImage(positiveImage);
		positivesuggestion.setIdResource(idResource);
		positivesuggestion.setNotes(notes);

		CBoPositivesuggestion cbo = new CBoPositivesuggestion();
		cbo.updatePositivesuggestion(positivesuggestion);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		// 检查是否有搜索词
		if(!(SpositiveContent.equals(""))){
			
			// 删除特殊字符
			SpositiveContent = RegEx.deleteSpecial(SpositiveContent);
			
			words = " where positiveContent like '%" + SpositiveContent + "%'";
		}

		CBoPositivesuggestion cbo = new CBoPositivesuggestion();
		CBoResource cboResource = new CBoResource();
		
		int temp = cbo.countPositivesuggestion(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Positivesuggestion列表
		List<Positivesuggestion> tList = cbo.searchPositivesuggestionByWords(words, page);
		
		list = new ArrayList<DtoPositivesuggestion>();
		
		// 存到dto列表中
		DtoPositivesuggestion dto;
		for(Positivesuggestion a:tList){
			dto = new DtoPositivesuggestion();
			
			dto.positivesuggestion = a;
			// 查找资源名
			dto.DResourceName = cboResource.searchResourceById(a.getIdResource()).getResourceName();
			
			list.add(dto);
		}
		
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoPositivesuggestion cbo = new CBoPositivesuggestion();
		positivesuggestion = cbo.searchPositivesuggestionById(idPositiveSuggestion);
		searchResource();
		return "searchById";
	}
	
	// 查找资源列表
	@SuppressWarnings("unchecked")
	public String searchResource() {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Resource");
			resourceList = (List<Resource>) query.list();
		} catch (Exception e) {
			System.out.println("查找资源列表出错");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "searchResource";
	}

	// 删除
	public String delete() {
		
		Session session = null;
		Transaction tx = null;
		
		// 删除相关宣泄关系
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "delete from Nusercathrel where idPositiveSuggestion=" + idPositiveSuggestion;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("删除相关宣泄关系出错");
			e.printStackTrace();
			return execute();
		}
		
		// 删除相关暗示关系
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "delete from Nusersugrel where idPositive=" + idPositiveSuggestion;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("删除相关暗示关系出错");
			e.printStackTrace();
			return execute();
		}

		CBoPositivesuggestion cbo = new CBoPositivesuggestion();
		cbo.deletePositivesuggestionById(idPositiveSuggestion);
		
		// 搜索关键词
		String words = "";
		
		/**
		 * 这里添加搜索词的原因是防止页数发生错误
		 * 
		 * 因为在删除后返回界面时，显示的是使用搜索词过滤后的列表，
		 * 而这里若果不用搜索词返回页数，会出现BUG
		 * */
		// 检查是否有搜索词
		if (!(SpositiveContent.equals(""))) {

			// 删除特殊字符
			SpositiveContent = RegEx.deleteSpecial(SpositiveContent);

			words = " where positiveContent like '%" + SpositiveContent + "%'";
		}

		// 查询记录个数
		int temp = cbo.countPositivesuggestion(words);
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
	public class DtoPositivesuggestion {
		Positivesuggestion positivesuggestion;
		String DResourceName; // 资源名
		
		// 必须有get，set方法，否则会出错
		public Positivesuggestion getPositivesuggestion() {
			return positivesuggestion;
		}
		public void setPositivesuggestion(Positivesuggestion positivesuggestion) {
			this.positivesuggestion = positivesuggestion;
		}
		public String getDResourceName() {
			return DResourceName;
		}
		public void setDResourceName(String dResourceName) {
			DResourceName = dResourceName;
		}
	}
	
}
