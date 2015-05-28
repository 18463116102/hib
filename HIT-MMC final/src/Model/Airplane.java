package Model;

/**
 * Airplane entity. @author MyEclipse Persistence Tools
 */
public class Airplane extends AbstractAirplane implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Airplane() {
	}

	/** full constructor */
	public Airplane(Integer aieplaneId, String aieplaneType, String aieplaneName) {
		super(aieplaneId, aieplaneType, aieplaneName);
	}

}
