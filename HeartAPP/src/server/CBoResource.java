package server;

import java.util.List;

import dao.Resource;

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
 *    该类是资源的类，对应表Resource
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertResource
 *             功能： 添加资源
 *             传入参数：Resource对象(不设置id值)
 *             返回值：无
 *        方法2：  updateResource
 *             功能： 更新资源
 *             传入参数：Resource对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchResourceById
 *             功能： 通过id查找资源
 *             传入参数：Int id
 *             返回值：Resource对象
 *        方法4：  deleteResourceById
 *             功能： 通过id删除资源
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countResource
 *             功能：按条件统计资源行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchResourceByWords
 *             功能：按条件搜索资源数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Resource>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoResource {
	
	// 添加资源
	public void insertResource(Resource resource) {
		try {
			CommonTools.insert(resource);
		} catch (Exception e) {
			System.out.println("添加资源出错");
			e.printStackTrace();
		}
	}
	
	// 修改资源信息
	public void updateResource(Resource resource) {
		try {
			CommonTools.update(resource);
		} catch (Exception e) {
			System.out.println("修改资源出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找资源信息
	public Resource searchResourceById(int id) {
		Resource resource = null;
		try {
			resource = (Resource)CommonTools.searchById(Resource.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找资源出错");
			e.printStackTrace();
			return null;
		}
		return resource;
	}
	
	// 通过ID删除资源
	public void deleteResourceById(int id) {
		try {
			Resource resource = new Resource();
			resource.setIdResource(id);
			CommonTools.delete(resource);
		} catch (Exception e) {
			System.out.println("删除资源出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计资源行数
	public int countResource(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Resource";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计资源出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索资源数据
	@SuppressWarnings("unchecked")
	public List<Resource> searchResourceByWords(String postfix,
			int page) {
		List<Resource> result;
		try {
			String hql = "from Resource";
			result = (List<Resource>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索资源出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
