package server;

import java.util.List;

import dao.Resattributes;

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
 *    该类是资源属性的类，对应表Resattributes
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertResattributes
 *             功能： 添加资源属性
 *             传入参数：Resattributes对象(不设置id值)
 *             返回值：无
 *        方法2：  updateResattributes
 *             功能： 更新资源属性
 *             传入参数：Resattributes对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchResattributesById
 *             功能： 通过id查找资源属性
 *             传入参数：Int id
 *             返回值：Resattributes对象
 *        方法4：  deleteResattributesById
 *             功能： 通过id删除资源属性
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countResattributes
 *             功能：按条件统计资源属性行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchResattributesByWords
 *             功能：按条件搜索资源属性数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Resattributes>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoResattributes {
	
	// 添加资源属性
	public void insertResattributes(Resattributes resattributes) {
		try {
			CommonTools.insert(resattributes);
		} catch (Exception e) {
			System.out.println("添加资源属性员出错");
			e.printStackTrace();
		}
	}
	
	// 修改资源属性
	public void updateResattributes(Resattributes resattributes) {
		try {
			CommonTools.update(resattributes);
		} catch (Exception e) {
			System.out.println("修改资源属性出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找资源属性
	public Resattributes searchResattributesById(int id) {
		Resattributes resattributes = null;
		try {
			resattributes = (Resattributes)CommonTools.searchById(Resattributes.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找资源属性出错");
			e.printStackTrace();
			return null;
		}
		return resattributes;
	}
	
	// 通过ID删除资源属性
	public void deleteResattributesById(int id) {
		try {
			Resattributes resattributes = new Resattributes();
			resattributes.setIdResAttributes(id);
			CommonTools.delete(resattributes);
		} catch (Exception e) {
			System.out.println("删除资源属性出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计资源属性行数
	public int countResattributes(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Resattributes";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计资源属性出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索资源属性数据
	@SuppressWarnings("unchecked")
	public List<Resattributes> searchResattributesByWords(String postfix,
			int page) {
		List<Resattributes> result;
		try {
			String hql = "from Resattributes";
			result = (List<Resattributes>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索资源属性出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
