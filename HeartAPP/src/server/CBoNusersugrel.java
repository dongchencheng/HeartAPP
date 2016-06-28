package server;

import java.util.List;

import dao.Nusersugrel;

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
 *    该类是用户暗示关系的类，对应表Nusersugrel
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNusersugrel
 *             功能： 添加关系
 *             传入参数：Nusersugrel对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNusersugrel
 *             功能： 更新关系信息
 *             传入参数：Nusersugrel对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNusersugrelById
 *             功能： 通过id查找关系信息
 *             传入参数：Int id
 *             返回值：Nusersugrel对象
 *        方法4：  deleteNusersugrelById
 *             功能： 通过id删除关系
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNusersugrel
 *             功能：按条件统计关系行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNusersugrelByWords
 *             功能：按条件搜索关系数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nusersugrel>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNusersugrel {
	
	// 添加关系
	public void insertNusersugrel(Nusersugrel nusersugrel) {
		try {
			CommonTools.insert(nusersugrel);
		} catch (Exception e) {
			System.out.println("添加关系出错");
			e.printStackTrace();
		}
	}
	
	// 修改关系信息
	public void updateNusersugrel(Nusersugrel nusersugrel) {
		try {
			CommonTools.update(nusersugrel);
		} catch (Exception e) {
			System.out.println("修改关系出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找关系信息
	public Nusersugrel searchNusersugrelById(int id) {
		Nusersugrel nusersugrel = null;
		try {
			nusersugrel = (Nusersugrel)CommonTools.searchById(Nusersugrel.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找关系出错");
			e.printStackTrace();
			return null;
		}
		return nusersugrel;
	}
	
	// 通过ID删除关系
	public void deleteNusersugrelById(int id) {
		try {
			Nusersugrel nusersugrel = new Nusersugrel();
			nusersugrel.setIdNuserSugRel(id);
			CommonTools.delete(nusersugrel);
		} catch (Exception e) {
			System.out.println("删除关系出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计关系行数
	public int countNusersugrel(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nusersugrel";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计关系出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索关系数据
	@SuppressWarnings("unchecked")
	public List<Nusersugrel> searchNusersugrelByWords(String postfix,
			int page) {
		List<Nusersugrel> result;
		try {
			String hql = "from Nusersugrel";
			result = (List<Nusersugrel>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索关系出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
