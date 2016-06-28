package action.patient;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNuserclicked;
import server.CBoResource;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nuserclicked;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.28
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class TaskAction extends ActionSupport {
	// 用户点击action

	private static final long serialVersionUID = -6171313746166834463L;

	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNuserclicked> list;// 显示列表
	
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
	public List<DtoNuserclicked> getList() {
		return list;
	}
	public void setList(List<DtoNuserclicked> list) {
		this.list = list;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		CBoNuserclicked cbo = new CBoNuserclicked();
		
		// 计算页数
		int temp = cbo.countNuserclicked(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nuserclicked列表
		List<Nuserclicked> tList = cbo.searchNuserclickedByWords(words, page);
		
		//查找每用户名和资源名
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoResource cboResource = new CBoResource();
		
		list = new ArrayList<DtoNuserclicked>();
		
		//存到dto列表中
		DtoNuserclicked dto;
		for(Nuserclicked a:tList){
			dto = new DtoNuserclicked();
			dto.nuserclicked = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdUser()).getNickName();
			dto.DResourceName = cboResource.searchResourceById(a.getIdResource()).getResourceName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNuserclicked{
		Nuserclicked nuserclicked;
		String DUserName;
		String DResourceName;
		// 必须有get，set方法，否则会出错
		public Nuserclicked getNuserclicked() {
			return nuserclicked;
		}
		public void setNuserclicked(Nuserclicked nuserclicked) {
			this.nuserclicked = nuserclicked;
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
