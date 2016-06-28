package action.user.userInformation;

import java.util.List;

import server.CBoUserlevel;

import com.opensymphony.xwork2.ActionSupport;

import dao.Userlevel;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.14
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class UserlevelAction extends ActionSupport {
	// 用户级别action

	private static final long serialVersionUID = -2063218636566757831L;
	
	private int idUserLevel;
	private String userLevelName;
	private String userLevelDes;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Userlevel> list;// 显示列表
	private Userlevel userlevel;// 返回给修改界面
	
	public int getIdUserLevel() {
		return idUserLevel;
	}
	public void setIdUserLevel(int idUserLevel) {
		this.idUserLevel = idUserLevel;
	}
	public String getUserLevelName() {
		return userLevelName;
	}
	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}
	public String getUserLevelDes() {
		return userLevelDes;
	}
	public void setUserLevelDes(String userLevelDes) {
		this.userLevelDes = userLevelDes;
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
	public List<Userlevel> getList() {
		return list;
	}
	public void setList(List<Userlevel> list) {
		this.list = list;
	}
	public Userlevel getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(Userlevel userlevel) {
		this.userlevel = userlevel;
	}

	// 添加验证
	public String validateInsert() {
		if (userLevelName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (userLevelName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}
	
	// 添加
	public String insert() {

		// 新建Userlevel对象并赋值
		Userlevel userlevel = new Userlevel();
		userlevel.setUserLevelName(userLevelName);
		userlevel.setUserLevelDes(userLevelDes);

		CBoUserlevel cbo = new CBoUserlevel();
		cbo.insertUserlevel(userlevel);

		// 查询记录个数并跳转最后一页
		int temp = cbo.countUserlevel("");
		if (temp % 10 == 0) {
			page = temp / 10;
		} else {
			page = temp / 10 + 1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Userlevel对象并赋值
		Userlevel userlevel = new Userlevel();
		userlevel.setIdUserLevel(idUserLevel);
		userlevel.setUserLevelName(userLevelName);
		userlevel.setUserLevelDes(userLevelDes);

		CBoUserlevel cbo = new CBoUserlevel();
		cbo.updateUserlevel(userlevel);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		CBoUserlevel cbo = new CBoUserlevel();
		int temp = cbo.countUserlevel(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchUserlevelByWords(words, page));
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoUserlevel cbo = new CBoUserlevel();
		userlevel = cbo.searchUserlevelById(idUserLevel);
		return "searchById";
	}

	// 删除
	public String delete() {

		CBoUserlevel cbo = new CBoUserlevel();
		cbo.deleteUserlevelById(idUserLevel);

		// 查询记录个数
		int temp = cbo.countUserlevel("");
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
