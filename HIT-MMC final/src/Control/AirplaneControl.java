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
import Factory.HibernateSessionFactory;


//@Entity
public class AirplaneControl {
	/*	AirplaneControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	//@OneToOne(mappedBy = "control")
	private static AirplaneControl control = null; 
	public static AirplaneControl getAirplaneControl(){
		if(null==control){
			control = new AirplaneControl();
		}
		return control;
	}

	/* AirplaneDAO
	 * AirplanelevelDAO
	 * HibernateSession
	 */
	private AirplaneDAO AirplaneDao = null;
	private Session session = null;
	
	public AirplaneControl(){
		AirplaneDao = new AirplaneDAO();
		session = HibernateSessionFactory.getSession();
	}

	/* 类方法
	 *
	*/
	public Airplane saveAirplane(Integer aieplaneId, String aieplaneType, String aieplaneName){
		Airplane airplane = new Airplane(aieplaneId,aieplaneType, aieplaneName);
		AirplaneDao.save(airplane);
		session.flush();
		return airplane;
	}
	public Airplane deleteAirplane(Integer aieplaneId){
		Airplane airplane =  new AirplaneDAO().findById(aieplaneId);
		AirplaneDao.delete(airplane);
		session.flush();
		return airplane;
	}
	public Airplane findAirplane(Integer aieplaneId){
		//
		//new AirplaneDAO().findByAieplaneType(aieplaneType);
		new Airplane().setAieplaneId(aieplaneId);
		Airplane airplane =  new AirplaneDAO().findById(aieplaneId);
		session.flush();
		return airplane;
	}
	public List findAllAirplane(){
		List list = new AirplaneDAO().findAll();
		return list;
	}
	public List findAirplaneTypeFix(){
		List list = new AirplaneDAO().findByAieplaneType("固定翼");
		return list;
	}
	public List findAirplaneTypeHli(){
		List list = new AirplaneDAO().findByAieplaneType("直升机");
		return list;
	}
	public List findAirplaneTypeMul(){
		List list = new AirplaneDAO().findByAieplaneType("多旋翼");
		return list;
	}
	public void changePlane(Integer aieplaneId, String aieplaneType,
			String aieplaneName){
		Airplane airplane = new AirplaneDAO().findById(aieplaneId);
		airplane.setAieplaneType(aieplaneType);
		airplane.setAieplaneName(aieplaneName);
		AirplaneDao.save(airplane);
	}

}
