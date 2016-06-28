package server;

import java.util.List;

import dao.Usercreatetype;

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
 *    该类是用户注册来源的类，对应表Usercreatetype
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertUsercreatetype
 *             功能： 添加注册来源
 *             传入参数：Usercreatetype对象(不设置id值)
 *             返回值：无
 *        方法2：  updateUsercreatetype
 *             功能： 更新注册来源
 *             传入参数：Usercreatetype对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchUsercreatetypeById
 *             功能： 通过id查找注册来源
 *             传入参数：Int id
 *             返回值：Usercreatetype对象
 *        方法4：  deleteUsercreatetypeById
 *             功能： 通过id删除注册来源
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countUsercreatetype
 *             功能：按条件统计注册来源行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchUsercreatetypeByWords
 *             功能：按条件搜索注册来源数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Usercreatetype>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoUsercreatetype {
	
	// 添加注册来源
	public void insertUsercreatetype(Usercreatetype usercreatetype) {
		try {
			CommonTools.insert(usercreatetype);
		} catch (Exception e) {
			System.out.println("添加注册来源出错");
			e.printStackTrace();
		}
	}
	
	// 修改注册来源
	public void updateUsercreatetype(Usercreatetype usercreatetype) {
		try {
			CommonTools.update(usercreatetype);
		} catch (Exception e) {
			System.out.println("修改注册来源出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找注册来源
	public Usercreatetype searchUsercreatetypeById(int id) {
		Usercreatetype usercreatetype = null;
		try {
			usercreatetype = (Usercreatetype)CommonTools.searchById(Usercreatetype.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找注册来源出错");
			e.printStackTrace();
			return null;
		}
		return usercreatetype;
	}
	
	// 通过ID删除注册来源
	public void deleteUsercreatetypeById(int id) {
		try {
			Usercreatetype usercreatetype = new Usercreatetype();
			usercreatetype.setIdUserCreateType(id);
			CommonTools.delete(usercreatetype);
		} catch (Exception e) {
			System.out.println("删除注册来源出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计注册来源行数
	public int countUsercreatetype(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Usercreatetype";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计注册来源出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索注册来源数据
	@SuppressWarnings("unchecked")
	public List<Usercreatetype> searchUsercreatetypeByWords(String postfix,
			int page) {
		List<Usercreatetype> result;
		try {
			String hql = "from Usercreatetype";
			result = (List<Usercreatetype>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索注册来源出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
