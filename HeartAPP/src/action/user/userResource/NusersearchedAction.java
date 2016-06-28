package action.user.userResource;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNusersearched;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nusersearched;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.17
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NusersearchedAction extends ActionSupport {
	// 用户搜索action

	private static final long serialVersionUID = -6171313746166834463L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNusersearched> list;// 显示列表
	
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
	public List<DtoNusersearched> getList() {
		return list;
	}
	public void setList(List<DtoNusersearched> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNusersearched cbo = new CBoNusersearched();
		
		// 计算页数
		int temp = cbo.countNusersearched(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nusersearched列表
		List<Nusersearched> tList = cbo.searchNusersearchedByWords(words, page);
		
		//查找每用户名
		CBoNormaluser cboUser = new CBoNormaluser();
		
		list = new ArrayList<DtoNusersearched>();
		
		//存到dto列表中
		DtoNusersearched dto;
		for(Nusersearched a:tList){
			dto = new DtoNusersearched();
			dto.nusersearched = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdUser()).getNickName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNusersearched{
		Nusersearched nusersearched;
		String DUserName;
		// 必须有get，set方法，否则会出错
		public Nusersearched getNusersearched() {
			return nusersearched;
		}
		public void setNusersearched(Nusersearched nusersearched) {
			this.nusersearched = nusersearched;
		}
		public String getDUserName() {
			return DUserName;
		}
		public void setDUserName(String dUserName) {
			DUserName = dUserName;
		}
	}
}
