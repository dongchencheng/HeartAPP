package server;

import java.util.List;

import dao.Nuserclicked;

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
 *    该类是用户点击的类，对应表Nuserclicked
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNuserclicked
 *             功能： 添加点击
 *             传入参数：Nuserclicked对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNuserclicked
 *             功能： 更新点击信息
 *             传入参数：Nuserclicked对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNuserclickedById
 *             功能： 通过id查找点击信息
 *             传入参数：Int id
 *             返回值：Nuserclicked对象
 *        方法4：  deleteNuserclickedById
 *             功能： 通过id删除点击
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNuserclicked
 *             功能：按条件统计点击行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNuserclickedByWords
 *             功能：按条件搜索点击数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nuserclicked>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNuserclicked {
	
	// 添加点击
	public void insertNuserclicked(Nuserclicked nuserclicked) {
		try {
			CommonTools.insert(nuserclicked);
		} catch (Exception e) {
			System.out.println("添加点击出错");
			e.printStackTrace();
		}
	}
	
	// 修改点击信息
	public void updateNuserclicked(Nuserclicked nuserclicked) {
		try {
			CommonTools.update(nuserclicked);
		} catch (Exception e) {
			System.out.println("修改点击出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找点击信息
	public Nuserclicked searchNuserclickedById(int id) {
		Nuserclicked nuserclicked = null;
		try {
			nuserclicked = (Nuserclicked)CommonTools.searchById(Nuserclicked.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找点击出错");
			e.printStackTrace();
			return null;
		}
		return nuserclicked;
	}
	
	// 通过ID删除点击
	public void deleteNuserclickedById(int id) {
		try {
			Nuserclicked nuserclicked = new Nuserclicked();
			nuserclicked.setIdUserClicked(id);
			CommonTools.delete(nuserclicked);
		} catch (Exception e) {
			System.out.println("删除点击出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计点击行数
	public int countNuserclicked(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nuserclicked";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计点击出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索点击数据
	@SuppressWarnings("unchecked")
	public List<Nuserclicked> searchNuserclickedByWords(String postfix,
			int page) {
		List<Nuserclicked> result;
		try {
			String hql = "from Nuserclicked";
			result = (List<Nuserclicked>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索点击出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
