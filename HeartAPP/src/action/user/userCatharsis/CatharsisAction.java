package action.user.userCatharsis;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.CBoNormaluser;
import server.CBoCatharsis;
import server.CommonTools;

import com.opensymphony.xwork2.ActionSupport;

import dao.Catharsis;
import dao.HibernateSessionFactory;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.20
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class CatharsisAction extends ActionSupport {
	// 宣泄信息action
	
	private static final long serialVersionUID = 1582283593430487889L;
	
	private int idCatharsis;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoCatharsis> list;// 显示列表
	
	public int getIdCatharsis() {
		return idCatharsis;
	}
	public void setIdCatharsis(int idCatharsis) {
		this.idCatharsis = idCatharsis;
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
	public List<DtoCatharsis> getList() {
		return list;
	}
	public void setList(List<DtoCatharsis> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoCatharsis cbo = new CBoCatharsis();
		CBoNormaluser cboUser = new CBoNormaluser();
		
		// 计算页数
		int temp = cbo.countCatharsis(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Catharsis列表
		List<Catharsis> tList = cbo.searchCatharsisByWords(words, page);
		
		list = new ArrayList<DtoCatharsis>();
		
		// 存到dto列表中
		DtoCatharsis dto;
		for(Catharsis a:tList){
			dto = new DtoCatharsis();
			dto.catharsis = a;
			
			// 查找每用户名
			dto.DUserName = cboUser.searchNormaluserById(a.getIdNuser()).getNickName();
			
			// 统计宣泄关系数目
			try {
				String hql = "select count(*) from Nusercathrel where idCatharsis="+a.getIdCatharsis();
				dto.DNusercathrelNum = CommonTools.count(hql);
			} catch (Exception e) {
				System.out.println("统计宣泄关系数目出错");
				e.printStackTrace();
			}
			
			list.add(dto);
		}
		
		return "success";
	}
	
	// 删除
	public String delete() {

		// 删除相关宣泄关系
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			String hql = "delete from Nusercathrel where idCatharsis="+idCatharsis;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("删除相关宣泄关系出错");
			e.printStackTrace();
			return execute();
		}

		// 删除宣泄信息
		CBoCatharsis cbo = new CBoCatharsis();
		cbo.deleteCatharsisById(idCatharsis);

		// 查询记录个数
		int temp = cbo.countCatharsis("");
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
	public class DtoCatharsis{
		Catharsis catharsis;
		String DUserName;	// 用户名
		int DNusercathrelNum;	// 宣泄关系数目
		// 必须有get，set方法，否则会出错
		public Catharsis getCatharsis() {
			return catharsis;
		}
		public void setCatharsis(Catharsis catharsis) {
			this.catharsis = catharsis;
		}
		public String getDUserName() {
			return DUserName;
		}
		public void setDUserName(String dUserName) {
			DUserName = dUserName;
		}
		public int getDNusercathrelNum() {
			return DNusercathrelNum;
		}
		public void setDNusercathrelNum(int dNusercathrelNum) {
			DNusercathrelNum = dNusercathrelNum;
		}
	}
}
