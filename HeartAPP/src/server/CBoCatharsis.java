package server;

import java.util.List;

import dao.Catharsis;

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
 *    该类是宣泄信息的类，对应表Catharsis
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertCatharsis
 *             功能： 添加宣泄信息
 *             传入参数：Catharsis对象(不设置id值)
 *             返回值：无
 *        方法2：  updateCatharsis
 *             功能： 更新宣泄信息
 *             传入参数：Catharsis对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchCatharsisById
 *             功能： 通过id查找宣泄信息
 *             传入参数：Int id
 *             返回值：Catharsis对象
 *        方法4：  deleteCatharsisById
 *             功能： 通过id删除宣泄信息
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countCatharsis
 *             功能：按条件统计宣泄信息行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchCatharsisByWords
 *             功能：按条件搜索宣泄信息数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Catharsis>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoCatharsis {
	
	// 添加宣泄信息
	public void insertCatharsis(Catharsis catharsis) {
		try {
			CommonTools.insert(catharsis);
		} catch (Exception e) {
			System.out.println("添加宣泄信息出错");
			e.printStackTrace();
		}
	}
	
	// 修改宣泄信息
	public void updateCatharsis(Catharsis catharsis) {
		try {
			CommonTools.update(catharsis);
		} catch (Exception e) {
			System.out.println("修改宣泄信息出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找宣泄信息
	public Catharsis searchCatharsisById(int id) {
		Catharsis catharsis = null;
		try {
			catharsis = (Catharsis)CommonTools.searchById(Catharsis.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找宣泄信息出错");
			e.printStackTrace();
			return null;
		}
		return catharsis;
	}
	
	// 通过ID删除宣泄信息
	public void deleteCatharsisById(int id) {
		try {
			Catharsis catharsis = new Catharsis();
			catharsis.setIdCatharsis(id);
			CommonTools.delete(catharsis);
		} catch (Exception e) {
			System.out.println("删除宣泄信息出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计宣泄信息行数
	public int countCatharsis(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Catharsis";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计宣泄信息出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索宣泄信息数据
	@SuppressWarnings("unchecked")
	public List<Catharsis> searchCatharsisByWords(String postfix,
			int page) {
		List<Catharsis> result;
		try {
			String hql = "from Catharsis";
			result = (List<Catharsis>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索宣泄信息出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
