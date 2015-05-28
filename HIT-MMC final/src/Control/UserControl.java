/**
 * @author zr_
 */
package Control;
import java.util.List;
import java.util.Set;









//import javax.persistence.Entity;
//import javax.persistence.OneToOne;
import org.hibernate.Session;

import Dao.AirplaneDAO;
import Model.Airplane;
import Model.AbstractAirplane;
import Model.User;
import Factory.HibernateSessionFactory;


//@Entity
public class UserControl {
	/*	AirplaneControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	//@OneToOne(mappedBy = "control")
	private static UserControl control = null; 
	public static UserControl getUserControl(){
		if(null==control){
			control = new UserControl();
		}
		return control;
	}

	/* AirplaneDAO
	 * AirplanelevelDAO
	 * HibernateSession
	 */
	private AirplaneDAO AirplaneDao = null;
	private Session session = null;
	
	public UserControl(){
		AirplaneDao = new AirplaneDAO();
		session = HibernateSessionFactory.getSession();
	}

	/* 类方法
	 *
	*/
	public int getuserID(){
		User user = new User();
		//int id;
		return user.getUserId();
		//return id;
	}
	public String getuserKey(){
		User user = new User();
		//String key;
		return user.getUserKey();
		//return key;
	}

}
