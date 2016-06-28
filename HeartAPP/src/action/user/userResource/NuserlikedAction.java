package action.user.userResource;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNuserliked;
import server.CBoResource;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nuserliked;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.17
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NuserlikedAction extends ActionSupport {
	// 用户喜欢action

	private static final long serialVersionUID = -6171313746166834463L;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNuserliked> list;// 显示列表
	
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
	public List<DtoNuserliked> getList() {
		return list;
	}
	public void setList(List<DtoNuserliked> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNuserliked cbo = new CBoNuserliked();
		
		// 计算页数
		int temp = cbo.countNuserliked(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nuserliked列表
		List<Nuserliked> tList = cbo.searchNuserlikedByWords(words, page);
		
		//查找每用户名和资源名
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoResource cboResource = new CBoResource();
		
		list = new ArrayList<DtoNuserliked>();
		
		//存到dto列表中
		DtoNuserliked dto;
		for(Nuserliked a:tList){
			dto = new DtoNuserliked();
			dto.nuserliked = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdUser()).getNickName();
			dto.DResourceName = cboResource.searchResourceById(a.getIdResource()).getResourceName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNuserliked{
		Nuserliked nuserliked;
		String DUserName;
		String DResourceName;
		// 必须有get，set方法，否则会出错
		public Nuserliked getNuserliked() {
			return nuserliked;
		}
		public void setNuserliked(Nuserliked nuserliked) {
			this.nuserliked = nuserliked;
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
