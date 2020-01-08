package gr.hua.dit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//uniqueConstraints = @UniqueConstraint(
//columnNames = { "role", "user_id" }))

@Entity
@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = { "authority", "user_id" }))
public class Authorities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_id")
	private int auth_id;

	@Column(name = "authority")
	private String authority;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Authorities() {
		super();
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}