package Model;

/**
 * AbstractAirplane entity provides the base persistence definition of the
 * Airplane entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAirplane implements java.io.Serializable {

	// Fields

	private Integer aieplaneId;
	private String aieplaneType;
	private String aieplaneName;

	// Constructors

	/** default constructor */
	public AbstractAirplane() {
	}

	/** full constructor */
	public AbstractAirplane(Integer aieplaneId, String aieplaneType,
			String aieplaneName) {
		this.aieplaneId = aieplaneId;
		this.aieplaneType = aieplaneType;
		this.aieplaneName = aieplaneName;
	}

	// Property accessors

	public Integer getAieplaneId() {
		return this.aieplaneId;
	}

	public void setAieplaneId(Integer aieplaneId) {
		this.aieplaneId = aieplaneId;
	}

	public String getAieplaneType() {
		return this.aieplaneType;
	}

	public void setAieplaneType(String aieplaneType) {
		this.aieplaneType = aieplaneType;
	}

	public String getAieplaneName() {
		return this.aieplaneName;
	}

	public void setAieplaneName(String aieplaneName) {
		this.aieplaneName = aieplaneName;
	}

}