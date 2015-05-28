package Model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userId) {
		super(userId);
	}

	/** full constructor */
	public User(Integer userId, String userKey) {
		super(userId, userKey);
	}

}
