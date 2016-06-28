package server;

import java.util.List;

import dao.Nuserliked;

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
 *    该类是用户喜欢的类，对应表Nuserliked
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNuserliked
 *             功能： 添加喜欢
 *             传入参数：Nuserliked对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNuserliked
 *             功能： 更新喜欢信息
 *             传入参数：Nuserliked对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNuserlikedById
 *             功能： 通过id查找喜欢信息
 *             传入参数：Int id
 *             返回值：Nuserliked对象
 *        方法4：  deleteNuserlikedById
 *             功能： 通过id删除喜欢
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNuserliked
 *             功能：按条件统计喜欢行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNuserlikedByWords
 *             功能：按条件搜索喜欢数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Nuserliked>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNuserliked {
	
	// 添加喜欢
	public void insertNuserliked(Nuserliked nuserliked) {
		try {
			CommonTools.insert(nuserliked);
		} catch (Exception e) {
			System.out.println("添加喜欢出错");
			e.printStackTrace();
		}
	}
	
	// 修改喜欢信息
	public void updateNuserliked(Nuserliked nuserliked) {
		try {
			CommonTools.update(nuserliked);
		} catch (Exception e) {
			System.out.println("修改喜欢出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找喜欢信息
	public Nuserliked searchNuserlikedById(int id) {
		Nuserliked nuserliked = null;
		try {
			nuserliked = (Nuserliked)CommonTools.searchById(Nuserliked.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找喜欢出错");
			e.printStackTrace();
			return null;
		}
		return nuserliked;
	}
	
	// 通过ID删除喜欢
	public void deleteNuserlikedById(int id) {
		try {
			Nuserliked nuserliked = new Nuserliked();
			nuserliked.setIdUserLiked(id);
			CommonTools.delete(nuserliked);
		} catch (Exception e) {
			System.out.println("删除喜欢出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计喜欢行数
	public int countNuserliked(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Nuserliked";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计喜欢出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索喜欢数据
	@SuppressWarnings("unchecked")
	public List<Nuserliked> searchNuserlikedByWords(String postfix,
			int page) {
		List<Nuserliked> result;
		try {
			String hql = "from Nuserliked";
			result = (List<Nuserliked>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索喜欢出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
