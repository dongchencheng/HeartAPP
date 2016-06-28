package server;

import java.util.List;

import dao.Usercollect;

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
 *    该类是用户收藏的类，对应表Usercollect
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertUsercollect
 *             功能： 添加收藏
 *             传入参数：Usercollect对象(不设置id值)
 *             返回值：无
 *        方法2：  updateUsercollect
 *             功能： 更新收藏
 *             传入参数：Usercollect对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchUsercollectById
 *             功能： 通过id查找收藏
 *             传入参数：Int id
 *             返回值：Usercollect对象
 *        方法4：  deleteUsercollectById
 *             功能： 通过id删除收藏
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countUsercollect
 *             功能：按条件统计收藏行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchUsercollectByWords
 *             功能：按条件搜索收藏数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Usercollect>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoUsercollect {
	
	// 添加收藏
	public void insertUsercollect(Usercollect usercollect) {
		try {
			CommonTools.insert(usercollect);
		} catch (Exception e) {
			System.out.println("添加收藏出错");
			e.printStackTrace();
		}
	}
	
	// 修改收藏信息
	public void updateUsercollect(Usercollect usercollect) {
		try {
			CommonTools.update(usercollect);
		} catch (Exception e) {
			System.out.println("修改收藏出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找收藏信息
	public Usercollect searchUsercollectById(int id) {
		Usercollect usercollect = null;
		try {
			usercollect = (Usercollect)CommonTools.searchById(Usercollect.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找收藏出错");
			e.printStackTrace();
			return null;
		}
		return usercollect;
	}
	
	// 通过ID删除收藏
	public void deleteUsercollectById(int id) {
		try {
			Usercollect usercollect = new Usercollect();
			usercollect.setIdUserCollect(id);
			CommonTools.delete(usercollect);
		} catch (Exception e) {
			System.out.println("删除收藏出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计收藏行数
	public int countUsercollect(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Usercollect";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计收藏出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索收藏数据
	@SuppressWarnings("unchecked")
	public List<Usercollect> searchUsercollectByWords(String postfix,
			int page) {
		List<Usercollect> result;
		try {
			String hql = "from Usercollect";
			result = (List<Usercollect>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索收藏出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
