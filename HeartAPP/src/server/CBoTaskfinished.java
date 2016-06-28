package server;

import java.util.List;

import dao.Taskfinished;

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
 *    该类是任务完成信息的类，对应表Taskfinished
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertTaskfinished
 *             功能： 添加完成信息
 *             传入参数：Taskfinished对象(不设置id值)
 *             返回值：无
 *        方法2：  updateTaskfinished
 *             功能： 更新完成信息
 *             传入参数：Taskfinished对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchTaskfinishedById
 *             功能： 通过id查找完成信息
 *             传入参数：Int id
 *             返回值：Taskfinished对象
 *        方法4：  deleteTaskfinishedById
 *             功能： 通过id删除完成信息
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countTaskfinished
 *             功能：按条件统计完成信息行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchTaskfinishedByWords
 *             功能：按条件搜索完成信息数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Taskfinished>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoTaskfinished {
	
	// 添加完成信息
	public void insertTaskfinished(Taskfinished taskfinished) {
		try {
			CommonTools.insert(taskfinished);
		} catch (Exception e) {
			System.out.println("添加完成信息出错");
			e.printStackTrace();
		}
	}
	
	// 修改完成信息信息
	public void updateTaskfinished(Taskfinished taskfinished) {
		try {
			CommonTools.update(taskfinished);
		} catch (Exception e) {
			System.out.println("修改完成信息出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找完成信息信息
	public Taskfinished searchTaskfinishedById(int id) {
		Taskfinished taskfinished = null;
		try {
			taskfinished = (Taskfinished)CommonTools.searchById(Taskfinished.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找完成信息出错");
			e.printStackTrace();
			return null;
		}
		return taskfinished;
	}
	
	// 通过ID删除完成信息
	public void deleteTaskfinishedById(int id) {
		try {
			Taskfinished taskfinished = new Taskfinished();
			taskfinished.setIdFinishedTask(id);
			CommonTools.delete(taskfinished);
		} catch (Exception e) {
			System.out.println("删除完成信息出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计完成信息行数
	public int countTaskfinished(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Taskfinished";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计完成信息出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索完成信息数据
	@SuppressWarnings("unchecked")
	public List<Taskfinished> searchTaskfinishedByWords(String postfix,
			int page) {
		List<Taskfinished> result;
		try {
			String hql = "from Taskfinished";
			result = (List<Taskfinished>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索完成信息出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
