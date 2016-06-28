package server;

import java.util.List;

import dao.Resandattribute;

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
 *    该类是资源和属性关系的类，对应表Resandattribute
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertResandattribute
 *             功能： 添加关系
 *             传入参数：Resandattribute对象(不设置id值)
 *             返回值：无
 *        方法2：  updateResandattribute
 *             功能： 更新关系
 *             传入参数：Resandattribute对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchResandattributeById
 *             功能： 通过id查找关系
 *             传入参数：Int id
 *             返回值：Resandattribute对象
 *        方法4：  deleteResandattributeById
 *             功能： 通过id删除关系
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countResandattribute
 *             功能：按条件统计关系行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchResandattributeByWords
 *             功能：按条件搜索关系数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Resandattribute>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoResandattribute {
	
	// 添加关系
	public void insertResandattribute(Resandattribute resandattribute) {
		try {
			CommonTools.insert(resandattribute);
		} catch (Exception e) {
			System.out.println("添加关系出错");
			e.printStackTrace();
		}
	}
	
	// 修改关系
	public void updateResandattribute(Resandattribute resandattribute) {
		try {
			CommonTools.update(resandattribute);
		} catch (Exception e) {
			System.out.println("修改关系出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找关系
	public Resandattribute searchResandattributeById(int id) {
		Resandattribute resandattribute = null;
		try {
			resandattribute = (Resandattribute)CommonTools.searchById(Resandattribute.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找关系出错");
			e.printStackTrace();
			return null;
		}
		return resandattribute;
	}
	
	// 通过ID删除关系
	public void deleteResandattributeById(int id) {
		try {
			Resandattribute resandattribute = new Resandattribute();
			resandattribute.setIdResAndAttribute(id);
			CommonTools.delete(resandattribute);
		} catch (Exception e) {
			System.out.println("删除关系出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计关系行数
	public int countResandattribute(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Resandattribute";
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
	public List<Resandattribute> searchResandattributeByWords(String postfix,
			int page) {
		List<Resandattribute> result;
		try {
			String hql = "from Resandattribute";
			result = (List<Resandattribute>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索关系出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
