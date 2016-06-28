package action.user.userInformation;

import java.util.List;

import server.CBoUserstatus;

import com.opensymphony.xwork2.ActionSupport;

import dao.Userstatus;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.14
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class UserstatusAction extends ActionSupport {
	// 用户状态action
	
	private static final long serialVersionUID = -8445904151742122423L;
	
	private int idUserStatus;
	private String userStatusName;
	private String userStatusDes;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Userstatus> list;// 显示列表
	private Userstatus userstatus;// 返回给修改界面
	
	public int getIdUserStatus() {
		return idUserStatus;
	}
	public void setIdUserStatus(int idUserStatus) {
		this.idUserStatus = idUserStatus;
	}
	public String getUserStatusName() {
		return userStatusName;
	}
	public void setUserStatusName(String userStatusName) {
		this.userStatusName = userStatusName;
	}
	public String getUserStatusDes() {
		return userStatusDes;
	}
	public void setUserStatusDes(String userStatusDes) {
		this.userStatusDes = userStatusDes;
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
	public List<Userstatus> getList() {
		return list;
	}
	public void setList(List<Userstatus> list) {
		this.list = list;
	}
	public Userstatus getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(Userstatus userstatus) {
		this.userstatus = userstatus;
	}
	
	// 添加验证
	public String validateInsert() {
		if (userStatusName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (userStatusName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}
	
	// 添加
	public String insert() {

		// 新建Userstatus对象并赋值
		Userstatus userstatus = new Userstatus();
		userstatus.setUserStatusName(userStatusName);
		userstatus.setUserStatusDes(userStatusDes);

		CBoUserstatus cbo = new CBoUserstatus();
		cbo.insertUserstatus(userstatus);

		// 查询记录个数并跳转最后一页
		int temp = cbo.countUserstatus("");
		if (temp % 10 == 0) {
			page = temp / 10;
		} else {
			page = temp / 10 + 1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Userstatus对象并赋值
		Userstatus userstatus = new Userstatus();
		userstatus.setIdUserStatus(idUserStatus);
		userstatus.setUserStatusName(userStatusName);
		userstatus.setUserStatusDes(userStatusDes);

		CBoUserstatus cbo = new CBoUserstatus();
		cbo.updateUserstatus(userstatus);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		CBoUserstatus cbo = new CBoUserstatus();
		int temp = cbo.countUserstatus(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchUserstatusByWords(words, page));
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoUserstatus cbo = new CBoUserstatus();
		userstatus = cbo.searchUserstatusById(idUserStatus);
		return "searchById";
	}

	// 删除
	public String delete() {

		CBoUserstatus cbo = new CBoUserstatus();
		cbo.deleteUserstatusById(idUserStatus);

		// 查询记录个数
		int temp = cbo.countUserstatus("");
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
