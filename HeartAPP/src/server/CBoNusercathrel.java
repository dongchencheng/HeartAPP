package server;

import java.util.List;

import dao.Nusercathrel;

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
 *    该类是用户宣泄的类，对应表Nusercathrel
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNusercathrel
 *             功能： 添加宣泄
 *             传入参数：Nusercathrel对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNusercathrel
 *             功能： 更新宣泄信息
 *             传入参数：Nusercathrel对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNusercathrelById
 *             功能： 通过id查找宣泄信息
 *             传入参数：Int id
 *             返回值：Nusercathrel对象
 *        方法4：  deleteNusercathrelById
 *             功能： 通过id删除宣泄
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNusercathrel
 *             功能：按条件统计宣泄行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNusercathrelByWords
 *             功能：按条件搜索宣泄数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nusercathrel>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNusercathrel {
	
	// 添加宣泄
	public void insertNusercathrel(Nusercathrel nusercathrel) {
		try {
			CommonTools.insert(nusercathrel);
		} catch (Exception e) {
			System.out.println("添加宣泄出错");
			e.printStackTrace();
		}
	}
	
	// 修改宣泄信息
	public void updateNusercathrel(Nusercathrel nusercathrel) {
		try {
			CommonTools.update(nusercathrel);
		} catch (Exception e) {
			System.out.println("修改宣泄出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找宣泄信息
	public Nusercathrel searchNusercathrelById(int id) {
		Nusercathrel nusercathrel = null;
		try {
			nusercathrel = (Nusercathrel)CommonTools.searchById(Nusercathrel.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找宣泄出错");
			e.printStackTrace();
			return null;
		}
		return nusercathrel;
	}
	
	// 通过ID删除宣泄
	public void deleteNusercathrelById(int id) {
		try {
			Nusercathrel nusercathrel = new Nusercathrel();
			nusercathrel.setIdNuserCathRel(id);
			CommonTools.delete(nusercathrel);
		} catch (Exception e) {
			System.out.println("删除宣泄出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计宣泄行数
	public int countNusercathrel(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nusercathrel";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计宣泄出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索宣泄数据
	@SuppressWarnings("unchecked")
	public List<Nusercathrel> searchNusercathrelByWords(String postfix,
			int page) {
		List<Nusercathrel> result;
		try {
			String hql = "from Nusercathrel";
			result = (List<Nusercathrel>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索宣泄出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
