package action.user.userPositiveSuggestion;

import java.util.ArrayList;
import java.util.List;

import server.CBoNormaluser;
import server.CBoNusersugrel;
import server.CBoPositivesuggestion;

import com.opensymphony.xwork2.ActionSupport;

import dao.Nusersugrel;


/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.25
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class NusersugrelAction extends ActionSupport {
	// 积极暗示关系action

	private static final long serialVersionUID = -3165849715248824120L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoNusersugrel> list;// 显示列表
	
	private String SidNUser = "";// 搜索用户ID
	private String SidPositive = "";// 搜索积极暗示ID
	
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
	public List<DtoNusersugrel> getList() {
		return list;
	}
	public void setList(List<DtoNusersugrel> list) {
		this.list = list;
	}
	public String getSidNUser() {
		return SidNUser;
	}
	public void setSidNUser(String sidNUser) {
		SidNUser = sidNUser;
	}
	public String getSidPositive() {
		return SidPositive;
	}
	public void setSidPositive(String sidPositive) {
		SidPositive = sidPositive;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";

		// 检查是否有搜索词
		if(!SidNUser.equals("")&&!SidPositive.equals("")){
			words = " where idNUser = " + SidNUser + " and idPositive = " + SidPositive;
		}else if(SidNUser.equals("")&&!SidPositive.equals("")){
			words = " where idPositive = " + SidPositive;
		}else if(!SidNUser.equals("")&&SidPositive.equals("")){
			words = " where idNUser = " + SidNUser;
		}

		CBoNusersugrel cbo = new CBoNusersugrel();
		
		// 计算页数
		int temp = cbo.countNusersugrel(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Nusersugrel列表
		List<Nusersugrel> tList = cbo.searchNusersugrelByWords(words, page);
		
		//查找每用户名和积极暗示文字
		CBoNormaluser cboUser = new CBoNormaluser();
		CBoPositivesuggestion cboPositive = new CBoPositivesuggestion();
		
		list = new ArrayList<DtoNusersugrel>();
		
		//存到dto列表中
		DtoNusersugrel dto;
		for(Nusersugrel a:tList){
			dto = new DtoNusersugrel();
			dto.nusersugrel = a;
			dto.DUserName = cboUser.searchNormaluserById(a.getIdNuser()).getNickName();
			dto.DpositiveContent = cboPositive.searchPositivesuggestionById(a.getIdPositive()).getPositiveContent();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoNusersugrel{
		Nusersugrel nusersugrel;
		String DUserName;// 用户名
		String DpositiveContent;// 积极暗示文字
		
		// 必须有get，set方法，否则会出错
		public Nusersugrel getNusersugrel() {
			return nusersugrel;
		}
		public void setNusersugrel(Nusersugrel nusersugrel) {
			this.nusersugrel = nusersugrel;
		}
		public String getDUserName() {
			return DUserName;
		}
		public void setDUserName(String dUserName) {
			DUserName = dUserName;
		}
		public String getDpositiveContent() {
			return DpositiveContent;
		}
		public void setDpositiveContent(String dpositiveContent) {
			DpositiveContent = dpositiveContent;
		}
	}
}
