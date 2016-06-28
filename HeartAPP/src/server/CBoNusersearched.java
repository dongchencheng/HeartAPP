package server;

import java.util.List;

import dao.Nusersearched;

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
 *    该类是用户搜索的类，对应表Nusersearched
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNusersearched
 *             功能： 添加搜索
 *             传入参数：Nusersearched对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNusersearched
 *             功能： 更新搜索信息
 *             传入参数：Nusersearched对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNusersearchedById
 *             功能： 通过id查找搜索信息
 *             传入参数：Int id
 *             返回值：Nusersearched对象
 *        方法4：  deleteNusersearchedById
 *             功能： 通过id删除搜索
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNusersearched
 *             功能：按条件统计搜索行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNusersearchedByWords
 *             功能：按条件搜索搜索数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nusersearched>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNusersearched {
	
	// 添加搜索
	public void insertNusersearched(Nusersearched nusersearched) {
		try {
			CommonTools.insert(nusersearched);
		} catch (Exception e) {
			System.out.println("添加搜索出错");
			e.printStackTrace();
		}
	}
	
	// 修改搜索信息
	public void updateNusersearched(Nusersearched nusersearched) {
		try {
			CommonTools.update(nusersearched);
		} catch (Exception e) {
			System.out.println("修改搜索出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找搜索信息
	public Nusersearched searchNusersearchedById(int id) {
		Nusersearched nusersearched = null;
		try {
			nusersearched = (Nusersearched)CommonTools.searchById(Nusersearched.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找搜索出错");
			e.printStackTrace();
			return null;
		}
		return nusersearched;
	}
	
	// 通过ID删除搜索
	public void deleteNusersearchedById(int id) {
		try {
			Nusersearched nusersearched = new Nusersearched();
			nusersearched.setIdUserSearched(id);
			CommonTools.delete(nusersearched);
		} catch (Exception e) {
			System.out.println("删除搜索出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计搜索行数
	public int countNusersearched(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nusersearched";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计搜索出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索搜索数据
	@SuppressWarnings("unchecked")
	public List<Nusersearched> searchNusersearchedByWords(String postfix,
			int page) {
		List<Nusersearched> result;
		try {
			String hql = "from Nusersearched";
			result = (List<Nusersearched>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索搜索出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
