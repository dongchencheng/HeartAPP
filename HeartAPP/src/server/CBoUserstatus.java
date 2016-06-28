package server;

import java.util.List;

import dao.Userstatus;

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
 *    该类是用户状态的类，对应表Userstatus
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertUserstatus
 *             功能： 添加状态
 *             传入参数：Userstatus对象(不设置id值)
 *             返回值：无
 *        方法2：  updateUserstatus
 *             功能： 更新状态
 *             传入参数：Userstatus对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchUserstatusById
 *             功能： 通过id查找状态
 *             传入参数：Int id
 *             返回值：Userstatus对象
 *        方法4：  deleteUserstatusById
 *             功能： 通过id删除状态
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countUserstatus
 *             功能：按条件统计状态行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchUserstatusByWords
 *             功能：按条件搜索状态数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Userstatus>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoUserstatus {
	
	// 添加状态
	public void insertUserstatus(Userstatus userstatus) {
		try {
			CommonTools.insert(userstatus);
		} catch (Exception e) {
			System.out.println("添加状态出错");
			e.printStackTrace();
		}
	}
	
	// 修改状态
	public void updateUserstatus(Userstatus userstatus) {
		try {
			CommonTools.update(userstatus);
		} catch (Exception e) {
			System.out.println("修改状态出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找状态
	public Userstatus searchUserstatusById(int id) {
		Userstatus userstatus = null;
		try {
			userstatus = (Userstatus)CommonTools.searchById(Userstatus.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找状态出错");
			e.printStackTrace();
			return null;
		}
		return userstatus;
	}
	
	// 通过ID删除状态
	public void deleteUserstatusById(int id) {
		try {
			Userstatus userstatus = new Userstatus();
			userstatus.setIdUserStatus(id);
			CommonTools.delete(userstatus);
		} catch (Exception e) {
			System.out.println("删除状态出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计状态行数
	public int countUserstatus(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Userstatus";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计状态出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索状态数据
	@SuppressWarnings("unchecked")
	public List<Userstatus> searchUserstatusByWords(String postfix,
			int page) {
		List<Userstatus> result;
		try {
			String hql = "from Userstatus";
			result = (List<Userstatus>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索状态出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
