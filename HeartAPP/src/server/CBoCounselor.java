package server;

import java.util.List;

import dao.Counselor;

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
 *    该类是咨询师的类，对应表Counselor
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertCounselor
 *             功能： 添加咨询师
 *             传入参数：Counselor对象(不设置id值)
 *             返回值：无
 *        方法2：  updateCounselor
 *             功能： 更新咨询师信息
 *             传入参数：Counselor对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchCounselorById
 *             功能： 通过id查找咨询师信息
 *             传入参数：Int id
 *             返回值：Counselor对象
 *        方法4：  deleteCounselorById
 *             功能： 通过id删除咨询师
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countCounselor
 *             功能：按条件统计咨询师行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchCounselorByWords
 *             功能：按条件搜索咨询师数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Counselor>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoCounselor {
	
	// 添加咨询师
	public void insertCounselor(Counselor counselor) {
		try {
			CommonTools.insert(counselor);
		} catch (Exception e) {
			System.out.println("添加咨询师出错");
			e.printStackTrace();
		}
	}
	
	// 修改咨询师信息
	public void updateCounselor(Counselor counselor) {
		try {
			CommonTools.update(counselor);
		} catch (Exception e) {
			System.out.println("修改咨询师出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找咨询师信息
	public Counselor searchCounselorById(int id) {
		Counselor counselor = null;
		try {
			counselor = (Counselor)CommonTools.searchById(Counselor.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找咨询师出错");
			e.printStackTrace();
			return null;
		}
		return counselor;
	}
	
	// 通过ID删除咨询师
	public void deleteCounselorById(int id) {
		try {
			Counselor counselor = new Counselor();
			counselor.setIdCounselor(id);
			CommonTools.delete(counselor);
		} catch (Exception e) {
			System.out.println("删除咨询师出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计咨询师行数
	public int countCounselor(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Counselor";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计咨询师出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索咨询师数据
	@SuppressWarnings("unchecked")
	public List<Counselor> searchCounselorByWords(String postfix,
			int page) {
		List<Counselor> result;
		try {
			String hql = "from Counselor";
			result = (List<Counselor>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索咨询师出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
