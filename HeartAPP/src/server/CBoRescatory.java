package server;

import java.util.List;

import dao.Rescatory;

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
 *    该类是资源大类的类，对应表Rescatory
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertRescatory
 *             功能： 添加资源大类
 *             传入参数：Rescatory对象(不设置id值)
 *             返回值：无
 *        方法2：  updateRescatory
 *             功能： 更新资源大类
 *             传入参数：Rescatory对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchRescatoryById
 *             功能： 通过id查找资源大类
 *             传入参数：Int id
 *             返回值：Rescatory对象
 *        方法4：  deleteRescatoryById
 *             功能： 通过id删除资源大类
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countRescatory
 *             功能：按条件统计资源大类行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchRescatoryByWords
 *             功能：按条件搜索资源大类数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Rescatory>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoRescatory {
	
	// 添加资源大类
	public void insertRescatory(Rescatory rescatory) {
		try {
			CommonTools.insert(rescatory);
		} catch (Exception e) {
			System.out.println("添加资源大类出错");
			e.printStackTrace();
		}
	}
	
	// 修改资源大类信息
	public void updateRescatory(Rescatory rescatory) {
		try {
			CommonTools.update(rescatory);
		} catch (Exception e) {
			System.out.println("修改资源大类出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找资源大类信息
	public Rescatory searchRescatoryById(int id) {
		Rescatory rescatory = null;
		try {
			rescatory = (Rescatory)CommonTools.searchById(Rescatory.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找资源大类出错");
			e.printStackTrace();
			return null;
		}
		return rescatory;
	}
	
	// 通过ID删除资源大类
	public void deleteRescatoryById(int id) {
		try {
			Rescatory rescatory = new Rescatory();
			rescatory.setIdResCatory(id);
			CommonTools.delete(rescatory);
		} catch (Exception e) {
			System.out.println("删除资源大类出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计资源大类行数
	public int countRescatory(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Rescatory";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计资源大类出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索资源大类数据
	@SuppressWarnings("unchecked")
	public List<Rescatory> searchRescatoryByWords(String postfix,
			int page) {
		List<Rescatory> result;
		try {
			String hql = "from Rescatory";
			result = (List<Rescatory>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索资源大类出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
