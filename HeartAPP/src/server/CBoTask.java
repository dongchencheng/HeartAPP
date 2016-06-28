package server;

import java.util.List;

import dao.Task;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.5.28
 *    版本号：Version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

/*------------------ 类功能描述 --------------------*/
/**
 *    该类是任务信息的类，对应表Task
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertTask
 *             功能： 添加任务
 *             传入参数：Task对象(不设置id值)
 *             返回值：无
 *        方法2：  updateTask
 *             功能： 更新任务
 *             传入参数：Task对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchTaskById
 *             功能： 通过id查找任务
 *             传入参数：Int id
 *             返回值：Task对象
 *        方法4：  deleteTaskById
 *             功能： 通过id删除任务
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countTask
 *             功能：按条件统计任务行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchTaskByWords
 *             功能：按条件搜索任务数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Task>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoTask {
	
	// 添加任务
	public void insertTask(Task task) {
		try {
			CommonTools.insert(task);
		} catch (Exception e) {
			System.out.println("添加任务出错");
			e.printStackTrace();
		}
	}
	
	// 修改任务
	public void updateTask(Task task) {
		try {
			CommonTools.update(task);
		} catch (Exception e) {
			System.out.println("修改任务出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找任务信息
	public Task searchTaskById(int id) {
		Task task = null;
		try {
			task = (Task)CommonTools.searchById(Task.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找任务出错");
			e.printStackTrace();
			return null;
		}
		return task;
	}
	
	// 通过ID删除任务
	public void deleteTaskById(int id) {
		try {
			Task task = new Task();
			task.setIdTask(id);
			CommonTools.delete(task);
		} catch (Exception e) {
			System.out.println("删除任务出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计任务行数
	public int countTask(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Task";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计任务出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索任务数据
	@SuppressWarnings("unchecked")
	public List<Task> searchTaskByWords(String postfix,
			int page) {
		List<Task> result;
		try {
			String hql = "from Task";
			result = (List<Task>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索任务出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
