package action.user.userResource;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNuservisited;
import server.CBoResource;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nuservisited;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.17
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NuservisitedAction extends ActionSupport {
	// 用户访问action

	private static final long serialVersionUID = -6171313746166834463L;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNuservisited> list;// 显示列表
	
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
	public List<DtoNuservisited> getList() {
		return list;
	}
	public void setList(List<DtoNuservisited> list) {
		this.list = list;
	}
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNuservisited cbo = new CBoNuservisited();
		
		// 计算页数
		int temp = cbo.countNuservisited(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nuservisited列表
		List<Nuservisited> tList = cbo.searchNuservisitedByWords(words, page);
		
		//查找每用户名和资源名
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoResource cboResource = new CBoResource();
		
		list = new ArrayList<DtoNuservisited>();
		
		//存到dto列表中
		DtoNuservisited dto;
		for(Nuservisited a:tList){
			dto = new DtoNuservisited();
			dto.nuservisited = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdUser()).getNickName();
			dto.DResourceName = cboResource.searchResourceById(a.getIdResource()).getResourceName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNuservisited{
		Nuservisited nuservisited;
		String DUserName;
		String DResourceName;
		// 必须有get，set方法，否则会出错
		public Nuservisited getNuservisited() {
			return nuservisited;
		}
		public void setNuservisited(Nuservisited nuservisited) {
			this.nuservisited = nuservisited;
		}
		public String getDUserName() {
			return DUserName;
		}
		public void setDUserName(String dUserName) {
			DUserName = dUserName;
		}
		public String getDResourceName() {
			return DResourceName;
		}
		public void setDResourceName(String dResourceName) {
			DResourceName = dResourceName;
		}
	}
}
