package action.patient;

import java.util.ArrayList;
import java.util.List;

import server.CBoCounselor;
import server.CBoPatient;
import server.CBoTask;

import com.opensymphony.xwork2.ActionSupport;

import dao.Task;

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
	// 任务信息action

	private static final long serialVersionUID = 954146994802482196L;
	
	private int page = 1;// 页数
	private int allpage = 1;// 总页数
	
	private List<DtoTask> list;// 显示列表
	
	private String SidCounselor = "";// 搜索咨询师ID
	private String SidPatient = "";// 搜索患者ID
	
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
	public List<DtoTask> getList() {
		return list;
	}
	public void setList(List<DtoTask> list) {
		this.list = list;
	}
	public String getSidCounselor() {
		return SidCounselor;
	}
	public void setSidCounselor(String sidCounselor) {
		SidCounselor = sidCounselor;
	}
	public String getSidPatient() {
		return SidPatient;
	}
	public void setSidPatient(String sidPatient) {
		SidPatient = sidPatient;
	}
	
	// 搜索全部
	public String execute() {
		// 搜索关键词
		String words = "";
		
		// 检查是否有搜索词
		if (!SidCounselor.equals("") && !SidPatient.equals("")) {
			words = " where idCounselor = " + SidCounselor + " and idPatient = "
					+ SidPatient;
		} else if (SidCounselor.equals("") && !SidPatient.equals("")) {
			words = " where idPatient = " + SidPatient;
		} else if (!SidCounselor.equals("") && SidPatient.equals("")) {
			words = " where idCounselor = " + SidCounselor;
		}

		CBoTask cbo = new CBoTask();
		
		// 计算页数
		int temp = cbo.countTask(words);
		if (temp % 10 == 0) {
			allpage = temp / 10;
		} else {
			allpage = temp / 10 + 1;
		}
		
		// 获得Task列表
		List<Task> tList = cbo.searchTaskByWords(words, page);
		
		//查找咨询师名和患者名
		CBoCounselor cboCounselor = new CBoCounselor();
		CBoPatient cboPatient = new CBoPatient();
		
		list = new ArrayList<DtoTask>();
		
		//存到dto列表中
		DtoTask dto;
		for(Task a:tList){
			dto = new DtoTask();
			dto.task = a;
			dto.DCouName = cboCounselor.searchCounselorById(a.getIdCounselor()).getCouName();
			dto.DPatientName = cboPatient.searchPatientById(a.getIdPatient()).getPatientName();
			list.add(dto);
		}
		return "success";
	}

	// dto类
	public class DtoTask{
		Task task;
		String DCouName;
		String DPatientName;
		// 必须有get，set方法，否则会出错
		public Task getTask() {
			return task;
		}
		public void setTask(Task task) {
			this.task = task;
		}
		public String getDCouName() {
			return DCouName;
		}
		public void setDCouName(String dCouName) {
			DCouName = dCouName;
		}
		public String getDPatientName() {
			return DPatientName;
		}
		public void setDPatientName(String dPatientName) {
			DPatientName = dPatientName;
		}
	}
}
