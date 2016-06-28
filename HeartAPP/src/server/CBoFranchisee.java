package server;

import java.util.List;

import dao.Franchisee;

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
 *    该类是加盟商的类，对应表Franchisee
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertFranchisee
 *             功能： 添加加盟商
 *             传入参数：Franchisee对象(不设置id值)
 *             返回值：无
 *        方法2：  updateFranchisee
 *             功能： 更新加盟商信息
 *             传入参数：Franchisee对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchFranchiseeById
 *             功能： 通过id查找加盟商信息
 *             传入参数：Int id
 *             返回值：Franchisee对象
 *        方法4：  deleteFranchiseeById
 *             功能： 通过id删除加盟商
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countFranchisee
 *             功能：按条件统计加盟商行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchFranchiseeByWords
 *             功能：按条件搜索加盟商数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Franchisee>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoFranchisee {
	
	// 添加加盟商
	public void insertFranchisee(Franchisee franchisee) {
		try {
			CommonTools.insert(franchisee);
		} catch (Exception e) {
			System.out.println("添加加盟商出错");
			e.printStackTrace();
		}
	}
	
	// 修改加盟商信息
	public void updateFranchisee(Franchisee franchisee) {
		try {
			CommonTools.update(franchisee);
		} catch (Exception e) {
			System.out.println("修改加盟商出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找加盟商信息
	public Franchisee searchFranchiseeById(int id) {
		Franchisee franchisee = null;
		try {
			franchisee = (Franchisee)CommonTools.searchById(Franchisee.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找加盟商出错");
			e.printStackTrace();
			return null;
		}
		return franchisee;
	}
	
	// 通过ID删除加盟商
	public void deleteFranchiseeById(int id) {
		try {
			Franchisee franchisee = new Franchisee();
			franchisee.setIdFranchisee(id);
			CommonTools.delete(franchisee);
		} catch (Exception e) {
			System.out.println("删除加盟商出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计加盟商行数
	public int countFranchisee(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Franchisee";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计加盟商出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索加盟商数据
	@SuppressWarnings("unchecked")
	public List<Franchisee> searchFranchiseeByWords(String postfix,
			int page) {
		List<Franchisee> result;
		try {
			String hql = "from Franchisee";
			result = (List<Franchisee>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索加盟商出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
