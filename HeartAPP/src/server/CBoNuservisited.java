package server;

import java.util.List;

import dao.Nuservisited;

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
 *    该类是用户访问的类，对应表Nuservisited
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNuservisited
 *             功能： 添加访问
 *             传入参数：Nuservisited对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNuservisited
 *             功能： 更新访问
 *             传入参数：Nuservisited对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNuservisitedById
 *             功能： 通过id查找访问
 *             传入参数：Int id
 *             返回值：Nuservisited对象
 *        方法4：  deleteNuservisitedById
 *             功能： 通过id删除访问
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNuservisited
 *             功能：按条件统计访问行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNuservisitedByWords
 *             功能：按条件搜索访问数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nuservisited>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNuservisited {
	
	// 添加访问
	public void insertNuservisited(Nuservisited nuservisited) {
		try {
			CommonTools.insert(nuservisited);
		} catch (Exception e) {
			System.out.println("添加访问出错");
			e.printStackTrace();
		}
	}
	
	// 修改访问信息
	public void updateNuservisited(Nuservisited nuservisited) {
		try {
			CommonTools.update(nuservisited);
		} catch (Exception e) {
			System.out.println("修改访问出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找访问信息
	public Nuservisited searchNuservisitedById(int id) {
		Nuservisited nuservisited = null;
		try {
			nuservisited = (Nuservisited)CommonTools.searchById(Nuservisited.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找访问出错");
			e.printStackTrace();
			return null;
		}
		return nuservisited;
	}
	
	// 通过ID删除访问
	public void deleteNuservisitedById(int id) {
		try {
			Nuservisited nuservisited = new Nuservisited();
			nuservisited.setIdUserVisited(id);
			CommonTools.delete(nuservisited);
		} catch (Exception e) {
			System.out.println("删除访问出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计访问行数
	public int countNuservisited(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nuservisited";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计访问出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索访问数据
	@SuppressWarnings("unchecked")
	public List<Nuservisited> searchNuservisitedByWords(String postfix,
			int page) {
		List<Nuservisited> result;
		try {
			String hql = "from Nuservisited";
			result = (List<Nuservisited>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索访问出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
