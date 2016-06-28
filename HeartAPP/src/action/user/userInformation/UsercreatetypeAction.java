package action.user.userInformation;

import java.util.List;

import server.CBoUsercreatetype;

import com.opensymphony.xwork2.ActionSupport;

import dao.Usercreatetype;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.14
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class UsercreatetypeAction extends ActionSupport {
	// 用户来源action
	
	private static final long serialVersionUID = 1978802280720685782L;
	
	private int idUserCreateType;
	private String userCreateTypeName;
	private String userCreateTypeDes;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Usercreatetype> list;// 显示列表
	private Usercreatetype usercreatetype;// 返回给修改界面
	
	public int getIdUserCreateType() {
		return idUserCreateType;
	}
	public void setIdUserCreateType(int idUserCreateType) {
		this.idUserCreateType = idUserCreateType;
	}
	public String getUserCreateTypeName() {
		return userCreateTypeName;
	}
	public void setUserCreateTypeName(String userCreateTypeName) {
		this.userCreateTypeName = userCreateTypeName;
	}
	public String getUserCreateTypeDes() {
		return userCreateTypeDes;
	}
	public void setUserCreateTypeDes(String userCreateTypeDes) {
		this.userCreateTypeDes = userCreateTypeDes;
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
	public List<Usercreatetype> getList() {
		return list;
	}
	public void setList(List<Usercreatetype> list) {
		this.list = list;
	}
	public Usercreatetype getUsercreatetype() {
		return usercreatetype;
	}
	public void setUsercreatetype(Usercreatetype usercreatetype) {
		this.usercreatetype = usercreatetype;
	}
	
	// 添加验证
	public String validateInsert() {
		if (userCreateTypeName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "insert";
	}

	// 修改验证
	public String validateUpdate() {
		if (userCreateTypeName.equals("")) {
			addActionError("带星号内容不能为空");
		}
		return "update";
	}
	
	// 添加
	public String insert() {

		// 新建Usercreatetype对象并赋值
		Usercreatetype usercreatetype = new Usercreatetype();
		usercreatetype.setUserCreateTypeName(userCreateTypeName);
		usercreatetype.setUserCreateTypeDes(userCreateTypeDes);

		CBoUsercreatetype cbo = new CBoUsercreatetype();
		cbo.insertUsercreatetype(usercreatetype);

		// 查询记录个数并跳转最后一页
		int temp = cbo.countUsercreatetype("");
		if (temp % 10 == 0) {
			page = temp / 10;
		} else {
			page = temp / 10 + 1;
		}
		return execute();
	}

	// 修改
	public String update() {

		// 新建Usercreatetype对象并赋值
		Usercreatetype usercreatetype = new Usercreatetype();
		usercreatetype.setIdUserCreateType(idUserCreateType);
		usercreatetype.setUserCreateTypeName(userCreateTypeName);
		usercreatetype.setUserCreateTypeDes(userCreateTypeDes);

		CBoUsercreatetype cbo = new CBoUsercreatetype();
		cbo.updateUsercreatetype(usercreatetype);
		return execute();
	}

	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words ="";
		
		CBoUsercreatetype cbo = new CBoUsercreatetype();
		int temp = cbo.countUsercreatetype(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchUsercreatetypeByWords(words, page));
		return "success";
	}

	// 通过ID搜索
	public String searchById() {

		CBoUsercreatetype cbo = new CBoUsercreatetype();
		usercreatetype = cbo.searchUsercreatetypeById(idUserCreateType);
		return "searchById";
	}

	// 删除
	public String delete() {

		CBoUsercreatetype cbo = new CBoUsercreatetype();
		cbo.deleteUsercreatetypeById(idUserCreateType);

		// 查询记录个数
		int temp = cbo.countUsercreatetype("");
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
