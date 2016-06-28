package server;

import java.util.List;

import dao.Resandcategory;

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
 *    该类是资源和大类关系的类，对应表Resandcategory
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertResandcategory
 *             功能： 添加关系
 *             传入参数：Resandcategory对象(不设置id值)
 *             返回值：无
 *        方法2：  updateResandcategory
 *             功能： 更新关系
 *             传入参数：Resandcategory对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchResandcategoryById
 *             功能： 通过id查找关系
 *             传入参数：Int id
 *             返回值：Resandcategory对象
 *        方法4：  deleteResandcategoryById
 *             功能： 通过id删除关系
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countResandcategory
 *             功能：按条件统计关系行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchResandcategoryByWords
 *             功能：按条件搜索关系数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Resandcategory>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoResandcategory {
	
	// 添加关系
	public void insertResandcategory(Resandcategory resandcategory) {
		try {
			CommonTools.insert(resandcategory);
		} catch (Exception e) {
			System.out.println("添加关系出错");
			e.printStackTrace();
		}
	}
	
	// 修改关系
	public void updateResandcategory(Resandcategory resandcategory) {
		try {
			CommonTools.update(resandcategory);
		} catch (Exception e) {
			System.out.println("修改关系出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找关系
	public Resandcategory searchResandcategoryById(int id) {
		Resandcategory resandcategory = null;
		try {
			resandcategory = (Resandcategory)CommonTools.searchById(Resandcategory.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找关系出错");
			e.printStackTrace();
			return null;
		}
		return resandcategory;
	}
	
	// 通过ID删除关系
	public void deleteResandcategoryById(int id) {
		try {
			Resandcategory resandcategory = new Resandcategory();
			resandcategory.setIdResAndCategory(id);
			CommonTools.delete(resandcategory);
		} catch (Exception e) {
			System.out.println("删除关系出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计关系行数
	public int countResandcategory(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Resandcategory";
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
	public List<Resandcategory> searchResandcategoryByWords(String postfix,
			int page) {
		List<Resandcategory> result;
		try {
			String hql = "from Resandcategory";
			result = (List<Resandcategory>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索关系出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
