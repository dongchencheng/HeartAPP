package server;

import java.util.List;

import dao.Normaluser;

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
 *    该类是普通用户的类，对应表Normaluser
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertNormaluser
 *             功能： 添加用户
 *             传入参数：Normaluser对象(不设置id值)
 *             返回值：无
 *        方法2：  updateNormaluser
 *             功能： 更新用户信息
 *             传入参数：Normaluser对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchNormaluserById
 *             功能： 通过id查找用户信息
 *             传入参数：Int id
 *             返回值：Normaluser对象
 *        方法4：  deleteNormaluserById
 *             功能： 通过id删除用户
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countNormaluser
 *             功能：按条件统计用户行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchNormaluserByWords
 *             功能：按条件搜索用户数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Normaluser>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoNormaluser {
	
	// 添加用户
	public void insertNormaluser(Normaluser normaluser) {
		try {
			CommonTools.insert(normaluser);
		} catch (Exception e) {
			System.out.println("添加用户出错");
			e.printStackTrace();
		}
	}
	
	// 修改用户信息
	public void updateNormaluser(Normaluser normaluser) {
		try {
			CommonTools.update(normaluser);
		} catch (Exception e) {
			System.out.println("修改用户出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找用户信息
	public Normaluser searchNormaluserById(int id) {
		Normaluser normaluser = null;
		try {
			normaluser = (Normaluser)CommonTools.searchById(Normaluser.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找用户出错");
			e.printStackTrace();
			return null;
		}
		return normaluser;
	}
	
	// 通过ID删除用户
	public void deleteNormaluserById(int id) {
		try {
			Normaluser normaluser = new Normaluser();
			normaluser.setIdUser(id);
			CommonTools.delete(normaluser);
		} catch (Exception e) {
			System.out.println("删除用户出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计用户行数
	public int countNormaluser(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Normaluser";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计用户出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索用户数据
	@SuppressWarnings("unchecked")
	public List<Normaluser> searchNormaluserByWords(String postfix,
			int page) {
		List<Normaluser> result;
		try {
			String hql = "from Normaluser";
			result = (List<Normaluser>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索用户出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
