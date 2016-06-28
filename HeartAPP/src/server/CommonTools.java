package server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateSessionFactory;

/*------------------ 开发者信息 --------------------*/
/**   开发者：董晨程
 *    开发日期：2016.5.22
 *    版本号：Version 1.1
 *    修改日期：
 *    修改人：
 *    修改内容：
 */
/*------------------ 开发者信息 --------------------*/

/*------------------ 类功能描述 --------------------*/
/**
 *    该类是数据库操作方法类，各表操作通过调用此类方法进行增删改查
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insert
 *             功能： 添加
 *             传入参数：任意数据库表对象(不设置id值)
 *             返回值：无
 *        方法2：  update
 *             功能： 更新
 *             传入参数：任意数据库表对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchById
 *             功能： 通过id查找
 *             传入参数：Int id
 *             返回值：Object对象
 *        方法4：  deleteById
 *             功能： 通过id删除
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  count
 *             功能：按条件统计数据行数
 *             传入参数：hql语句
 *             返回值：Int 个数
 *        方法6：  searchByWords
 *             功能：按条件返回数据行
 *             传入参数：hql语句，页数
 *             返回值：List
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/

public class CommonTools {

	// 添加对象
	public static void insert(Object o) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}

	// 修改对象
	public static void update(Object o) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(o);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}

	// 通过ID搜索对象
	public static Object searchById(Class<?> table, int id) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			return session.get(table, id);
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	// 通过ID删除对象
	public static void delete(Object o) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}
	
	// 按条件统计行数
	public static int count(String hql) throws Exception {
		int result = -1;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			List<?> list = query.list();
			result = ((Long) list.get(0)).intValue();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}
	
	// 按条件返回数据行
	public static List<?> searchByWords(String hql, int page) throws Exception {
		List<?> list;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * 10); // 设置查询起始
			query.setMaxResults(10); // 设置查询个数
			list = query.list();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return list;
	}
}
