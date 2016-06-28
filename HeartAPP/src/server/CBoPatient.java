package server;

import java.util.List;

import dao.Patient;

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
 *    该类是患者信息的类，对应表Patient
 */
/**               @@@@@ 类方法描述  @@@@@                    **/
/**       方法1：insertPatient
 *             功能： 添加患者
 *             传入参数：Patient对象(不设置id值)
 *             返回值：无
 *        方法2：  updatePatient
 *             功能： 更新患者信息
 *             传入参数：Patient对象(设置修改对象的id)
 *             返回值：无
 *        方法3：  searchPatientById
 *             功能： 通过id查找患者信息
 *             传入参数：Int id
 *             返回值：Patient对象
 *        方法4：  deletePatientById
 *             功能： 通过id删除患者
 *             传入参数：Int id
 *             返回值：无
 *        方法5：  countPatient
 *             功能：按条件统计患者行数
 *             传入参数：查询后缀
 *             返回值：Int 个数
 *        方法6：  searchPatientByWords
 *             功能：按条件搜索患者数据
 *             传入参数：查询后缀，页数
 *             返回值：List<Patient>
 */  
/**               @@@@@ 类方法描述  @@@@@                    **/
/*------------------ 类功能描述 --------------------*/


public class CBoPatient {
	
	// 添加患者
	public void insertPatient(Patient patient) {
		try {
			CommonTools.insert(patient);
		} catch (Exception e) {
			System.out.println("添加患者出错");
			e.printStackTrace();
		}
	}
	
	// 修改患者信息
	public void updatePatient(Patient patient) {
		try {
			CommonTools.update(patient);
		} catch (Exception e) {
			System.out.println("修改患者出错");
			e.printStackTrace();
		}
	}
	
	// 通过ID查找患者信息
	public Patient searchPatientById(int id) {
		Patient patient = null;
		try {
			patient = (Patient)CommonTools.searchById(Patient.class, id);
		} catch (Exception e) {
			System.out.println("通过id查找患者出错");
			e.printStackTrace();
			return null;
		}
		return patient;
	}
	
	// 通过ID删除患者
	public void deletePatientById(int id) {
		try {
			Patient patient = new Patient();
			patient.setIdPatient(id);
			CommonTools.delete(patient);
		} catch (Exception e) {
			System.out.println("删除患者出错");
			e.printStackTrace();
		}
	}
	
	// 按条件统计患者行数
	public int countPatient(String postfix) {
		int result = -1;
		try {
			String hql = "select count(*) from Patient";
			result = CommonTools.count(hql + postfix);
		} catch (Exception e) {
			System.out.println("按条件统计患者出错");
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	// 按条件搜索患者数据
	@SuppressWarnings("unchecked")
	public List<Patient> searchPatientByWords(String postfix,
			int page) {
		List<Patient> result;
		try {
			String hql = "from Patient";
			result = (List<Patient>) CommonTools.searchByWords(hql
					+ postfix, page);
		} catch (Exception e) {
			System.out.println("按条件搜索患者出错");
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
