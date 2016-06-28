package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import server.CBoAdministrator;
import server.CBoCounselor;
import server.CBoFranchisee;
import server.CBoNormaluser;
import server.CBoResource;

import com.opensymphony.xwork2.ActionSupport;
import dao.Administrator;
import dao.HibernateSessionFactory;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.5.22
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class LoginAction extends ActionSupport implements ServletRequestAware {
	
	private static final long serialVersionUID = 1561280561794567554L;
	private HttpServletRequest request;
	
	//登录参数
	private String adminname; // 用户名
	private String password; // 密码

	// 修改密码参数
	private String oldpassword;// 旧密码
	private String newpassword;// 新密码
	
	@Override
	public void setServletRequest(HttpServletRequest hsr) {
		request = hsr;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	// 登录
	public String login() {

		Session session = null;
		List<?> list = null;// 存储返回结果
		Administrator admin;

		try {
			// 获取session并开启事务
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			// 通过用户名密码查询
			Criteria c = session.createCriteria(Administrator.class);
			c.add(Restrictions.eq("adminname", getAdminname()));
			c.add(Restrictions.eq("password", getPassword()));
			list = c.list();
		} catch (Exception e) {
			System.out.println("登录操作出错！");
			request.setAttribute("from", "登录操作");
			e.printStackTrace();
			return "false";
		} finally {
			session.close();
		}

		if (!list.isEmpty()) {
			admin = (Administrator) list.get(0);
			if (admin.getLevel() != 1) {
				request.setAttribute("success", "limit");
				return "limit"; // level不是1，权限受限
			}
		} else {
			request.setAttribute("success", "false");
			return "false"; // 查找为空，用户名或密码错误
		}

		// session中记录用户信息
		HttpSession s = request.getSession();
		s.setAttribute("id", admin.getIdAdministrator());
		s.setAttribute("adminname", admin.getAdminname());
		s.setAttribute("password", admin.getPassword());
		
		//session中存储用户数，资源数，加盟商数和咨询师数
		int temp = 0;
		CBoNormaluser cboNormaluser = new CBoNormaluser();
		temp = cboNormaluser.countNormaluser("");
		s.setAttribute("userNum", temp);
		
		CBoResource cboResource = new CBoResource();
		temp = cboResource.countResource("");
		s.setAttribute("resourceNum", temp);
		
		CBoFranchisee cboFranchisee = new CBoFranchisee();
		temp = cboFranchisee.countFranchisee("");
		s.setAttribute("franchiseeNum", temp);
		
		CBoCounselor cboCounselor = new CBoCounselor();
		temp = cboCounselor.countCounselor("");
		s.setAttribute("counselorNum", temp);
		
		return "true"; // 登录成功

	}

	// 修改密码
	public String update() {

		// 通过session获取管理员信息
		HttpSession s = request.getSession();
		String pass = (String) s.getAttribute("password");
		
		if (!getOldpassword().equals(pass)) {// 旧密码错误
			request.setAttribute("success", "failure");
			return "failure";
		} else {
			CBoAdministrator cbo = new CBoAdministrator();// administrator操作类
			Administrator admin = cbo.searchAdministratorById((Integer) s
					.getAttribute("id"));
			admin.setPassword(getNewpassword());
			cbo.updateAdministrator(admin);
			request.setAttribute("success", "update");
			s.removeAttribute("id");
			s.removeAttribute("adminname");
			s.removeAttribute("password");
			return "update";
		}
	}
	
	// 退出
	public String execute(){
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("adminname");
		session.removeAttribute("password");
		session.removeAttribute("userNum");
		session.removeAttribute("resourceNum");
		session.removeAttribute("franchiseeNum");
		session.removeAttribute("counselorNum");
		return "logout";
	}
}
