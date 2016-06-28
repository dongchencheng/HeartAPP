package server;

import java.util.List;

import dao.Administrator;

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
 *    该类是管理员的类，对应表Administrator
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertAdministrator
 *             功能： 添加管理员
 *             传入参数：Administrator对象(不设置id值)
 *             返回值：无
 *        方法2：  updateAdministrator
 *             功能： 更新管理员信息
 *             传入参数：Administrator对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchAdministratorById
 *             功能： 通过id查找管理员信息
 *             传入参数：Int id
 *             返回值：Administrator对象
 *        方法4：  deleteAdministratorById
 *             功能： 通过id删除管理员
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countAdministrator
 *             功能：按条件统计管理员行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchAdministratorByWords
 *             功能：按条件搜索管理员数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Administrator>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoAdministrator {
	
	// 添加管理员
	public void insertAdministrator(Administrator administrator) {
		try {
			CommonTools.insert(administrator);
		} catch (Exception e) {
			System.out.println("添加管理员出错");
			e.printStackTrace();
		}
	}
	
	// 修改管理员信息
	public void updateAdministrator(Administrator administrator) {
		try {
			CommonTools.update(administrator);
		} catch (Exception e) {
			System.out.println("修改管理员出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找管理员信息
	public Administrator searchAdministratorById(int id) {
		Administrator administrator = null;
		try {
			administrator = (Administrator)CommonTools.searchById(Administrator.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找管理员出错");
			e.printStackTrace();
			return null;
		}
		return administrator;
	}
	
	// 通过ID删除管理员
	public void deleteAdministratorById(int id) {
		try {
			Administrator administrator = new Administrator();
			administrator.setIdAdministrator(id);
			CommonTools.delete(administrator);
		} catch (Exception e) {
			System.out.println("删除管理员出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计管理员行数
	public int countAdministrator(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Administrator";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计管理员出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索管理员数据
	@SuppressWarnings("unchecked")
	public List<Administrator> searchAdministratorByWords(String postfix,
			int page) {
		List<Administrator> result;
		try {
			String hql = "from Administrator";
			result = (List<Administrator>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索管理员出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
