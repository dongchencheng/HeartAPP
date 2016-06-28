package server;

import java.util.List;

import dao.Positivesuggestion;

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
 *    该类是积极暗示信息的类，对应表Positivesuggestion
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertPositivesuggestion
 *             功能： 添加积极暗示
 *             传入参数：Positivesuggestion对象(不设置id值)
 *             返回值：无
 *        方法2：  updatePositivesuggestion
 *             功能： 更新积极暗示
 *             传入参数：Positivesuggestion对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchPositivesuggestionById
 *             功能： 通过id查找积极暗示
 *             传入参数：Int id
 *             返回值：Positivesuggestion对象
 *        方法4：  deletePositivesuggestionById
 *             功能： 通过id删除积极暗示
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countPositivesuggestion
 *             功能：按条件统计积极暗示行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchPositivesuggestionByWords
 *             功能：按条件搜索积极暗示数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Positivesuggestion>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoPositivesuggestion {
	
	// 添加积极暗示
	public void insertPositivesuggestion(Positivesuggestion positivesuggestion) {
		try {
			CommonTools.insert(positivesuggestion);
		} catch (Exception e) {
			System.out.println("添加积极暗示出错");
			e.printStackTrace();
		}
	}
	
	// 修改积极暗示
	public void updatePositivesuggestion(Positivesuggestion positivesuggestion) {
		try {
			CommonTools.update(positivesuggestion);
		} catch (Exception e) {
			System.out.println("修改积极暗示出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找积极暗示
	public Positivesuggestion searchPositivesuggestionById(int id) {
		Positivesuggestion positivesuggestion = null;
		try {
			positivesuggestion = (Positivesuggestion)CommonTools.searchById(Positivesuggestion.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找积极暗示出错");
			e.printStackTrace();
			return null;
		}
		return positivesuggestion;
	}
	
	// 通过ID删除积极暗示
	public void deletePositivesuggestionById(int id) {
		try {
			Positivesuggestion positivesuggestion = new Positivesuggestion();
			positivesuggestion.setIdPositiveSuggestion(id);
			CommonTools.delete(positivesuggestion);
		} catch (Exception e) {
			System.out.println("删除积极暗示出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计积极暗示行数
	public int countPositivesuggestion(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Positivesuggestion";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计积极暗示出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索积极暗示数据
	@SuppressWarnings("unchecked")
	public List<Positivesuggestion> searchPositivesuggestionByWords(String postfix,
			int page) {
		List<Positivesuggestion> result;
		try {
			String hql = "from Positivesuggestion";
			result = (List<Positivesuggestion>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索积极暗示出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
