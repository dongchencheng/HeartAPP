package server;

import java.util.List;

import dao.Nuserrecommened;

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
 *    该类是用户推荐的类，对应表Nuserrecommened
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNuserrecommened
 *             功能： 添加推荐
 *             传入参数：Nuserrecommened对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNuserrecommened
 *             功能： 更新推荐信息
 *             传入参数：Nuserrecommened对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNuserrecommenedById
 *             功能： 通过id查找推荐信息
 *             传入参数：Int id
 *             返回值：Nuserrecommened对象
 *        方法4：  deleteNuserrecommenedById
 *             功能： 通过id删除推荐
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNuserrecommened
 *             功能：按条件统计推荐行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNuserrecommenedByWords
 *             功能：按条件搜索推荐数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nuserrecommened>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNuserrecommened {
	
	// 添加推荐
	public void insertNuserrecommened(Nuserrecommened nuserrecommened) {
		try {
			CommonTools.insert(nuserrecommened);
		} catch (Exception e) {
			System.out.println("添加推荐出错");
			e.printStackTrace();
		}
	}
	
	// 修改推荐信息
	public void updateNuserrecommened(Nuserrecommened nuserrecommened) {
		try {
			CommonTools.update(nuserrecommened);
		} catch (Exception e) {
			System.out.println("修改推荐出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找推荐信息
	public Nuserrecommened searchNuserrecommenedById(int id) {
		Nuserrecommened nuserrecommened = null;
		try {
			nuserrecommened = (Nuserrecommened)CommonTools.searchById(Nuserrecommened.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找推荐出错");
			e.printStackTrace();
			return null;
		}
		return nuserrecommened;
	}
	
	// 通过ID删除推荐
	public void deleteNuserrecommenedById(int id) {
		try {
			Nuserrecommened nuserrecommened = new Nuserrecommened();
			nuserrecommened.setIdUserRecommened(id);
			CommonTools.delete(nuserrecommened);
		} catch (Exception e) {
			System.out.println("删除推荐出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计推荐行数
	public int countNuserrecommened(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nuserrecommened";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计推荐出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索推荐数据
	@SuppressWarnings("unchecked")
	public List<Nuserrecommened> searchNuserrecommenedByWords(String postfix,
			int page) {
		List<Nuserrecommened> result;
		try {
			String hql = "from Nuserrecommened";
			result = (List<Nuserrecommened>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索推荐出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
