package server;

import java.util.List;

import dao.Userlevel;

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
 *    该类是用户级别的类，对应表Userlevel
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertUserlevel
 *             功能： 添加级别
 *             传入参数：Userlevel对象(不设置id值)
 *             返回值：无
 *        方法2：  updateUserlevel
 *             功能： 更新级别
 *             传入参数：Userlevel对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchUserlevelById
 *             功能： 通过id查找级别
 *             传入参数：Int id
 *             返回值：Userlevel对象
 *        方法4：  deleteUserlevelById
 *             功能： 通过id删除级别
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countUserlevel
 *             功能：按条件统计级别行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchUserlevelByWords
 *             功能：按条件搜索级别数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Userlevel>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoUserlevel {
	
	// 添加级别
	public void insertUserlevel(Userlevel userlevel) {
		try {
			CommonTools.insert(userlevel);
		} catch (Exception e) {
			System.out.println("添加级别出错");
			e.printStackTrace();
		}
	}
	
	// 修改级别信息
	public void updateUserlevel(Userlevel userlevel) {
		try {
			CommonTools.update(userlevel);
		} catch (Exception e) {
			System.out.println("修改级别出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找级别信息
	public Userlevel searchUserlevelById(int id) {
		Userlevel userlevel = null;
		try {
			userlevel = (Userlevel)CommonTools.searchById(Userlevel.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找级别出错");
			e.printStackTrace();
			return null;
		}
		return userlevel;
	}
	
	// 通过ID删除级别
	public void deleteUserlevelById(int id) {
		try {
			Userlevel userlevel = new Userlevel();
			userlevel.setIdUserLevel(id);
			CommonTools.delete(userlevel);
		} catch (Exception e) {
			System.out.println("删除级别出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计级别行数
	public int countUserlevel(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Userlevel";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计级别出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索级别数据
	@SuppressWarnings("unchecked")
	public List<Userlevel> searchUserlevelByWords(String postfix,
			int page) {
		List<Userlevel> result;
		try {
			String hql = "from Userlevel";
			result = (List<Userlevel>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索级别出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
