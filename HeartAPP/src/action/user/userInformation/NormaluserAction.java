package action.user.userInformation;

import java.util.List;

import server.CBoNormaluser;

import com.opensymphony.xwork2.ActionSupport;

import dao.Normaluser;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.14
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NormaluserAction extends ActionSupport {
	// 普通用户action

	private static final long serialVersionUID = 8609933483625363482L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<Normaluser> list;// 显示列表

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
	public List<Normaluser> getList() {
		return list;
	}
	public void setList(List<Normaluser> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNormaluser cbo = new CBoNormaluser();
		int temp = cbo.countNormaluser(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		setList(cbo.searchNormaluserByWords(words, page));
		return "success";
	}
	
}
