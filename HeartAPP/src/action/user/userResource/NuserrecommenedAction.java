package action.user.userResource;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNuserrecommened;
import server.CBoResource;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nuserrecommened;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.17
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NuserrecommenedAction extends ActionSupport {
	// 用户推荐action

	private static final long serialVersionUID = -6171313746166834463L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNuserrecommened> list;// 显示列表
	
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
	public List<DtoNuserrecommened> getList() {
		return list;
	}
	public void setList(List<DtoNuserrecommened> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNuserrecommened cbo = new CBoNuserrecommened();
		
		// 计算页数
		int temp = cbo.countNuserrecommened(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nuserrecommened列表
		List<Nuserrecommened> tList = cbo.searchNuserrecommenedByWords(words, page);
		
		//查找每用户名和资源名
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoResource cboResource = new CBoResource();
		
		list = new ArrayList<DtoNuserrecommened>();
		
		//存到dto列表中
		DtoNuserrecommened dto;
		for(Nuserrecommened a:tList){
			dto = new DtoNuserrecommened();
			dto.nuserrecommened = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdUser()).getNickName();
			dto.DResourceName = cboResource.searchResourceById(a.getIdResource()).getResourceName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNuserrecommened{
		Nuserrecommened nuserrecommened;
		String DUserName;
		String DResourceName;
		// 必须有get，set方法，否则会出错
		public Nuserrecommened getNuserrecommened() {
			return nuserrecommened;
		}
		public void setNuserrecommened(Nuserrecommened nuserrecommened) {
			this.nuserrecommened = nuserrecommened;
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
