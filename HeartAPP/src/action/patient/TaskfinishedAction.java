package action.patient;

import java.util.ArrayList;
import java.util.List;

import server.CBoTask;
import server.CBoTaskfinished;

import com.opensymphony.xwork2.ActionSupport;

import dao.Taskfinished;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.6.28
 *    版本号：version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

public class TaskfinishedAction extends ActionSupport {
	// 任务完成action

	private static final long serialVersionUID = -1334001194378750965L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoTaskfinished> list;// 显示列表
	
	private String SidTask = "";// 搜索任务ID
	
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
	public List<DtoTaskfinished> getList() {
		return list;
	}
	public void setList(List<DtoTaskfinished> list) {
		this.list = list;
	}
	public String getSidTask() {
		return SidTask;
	}
	public void setSidTask(String sidTask) {
		SidTask = sidTask;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";
		
		// 检查是否有搜索词
		if (!SidTask.equals("")) {
			words = " where idTask = " + SidTask;
		}

		CBoTaskfinished cbo = new CBoTaskfinished();
		
		// 计算页数
		int temp = cbo.countTaskfinished(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Taskfinished列表
		List<Taskfinished> tList = cbo.searchTaskfinishedByWords(words, page);
		
		//查找任务类型
		CBoTask cboTask = new CBoTask();
		
		list = new ArrayList<DtoTaskfinished>();
		
		//存到dto列表中
		DtoTaskfinished dto;
		for(Taskfinished a:tList){
			dto = new DtoTaskfinished();
			dto.taskfinished = a;
			dto.DTaskType = cboTask.searchTaskById(a.getIdTask()).getTaskType();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoTaskfinished{
		Taskfinished taskfinished;
		String DTaskType;
		
		// 必须有get，set方法，否则会出错
		public Taskfinished getTaskfinished() {
			return taskfinished;
		}
		public void setTaskfinished(Taskfinished taskfinished) {
			this.taskfinished = taskfinished;
		}
		public String getDTaskType() {
			return DTaskType;
		}
		public void setDTaskType(String dTaskType) {
			DTaskType = dTaskType;
		}
	}
}
