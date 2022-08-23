package tw.hibernateDemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friend {
	@Id
	@Column(name = "friends_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer friendId;
	
	@Column(name = "friendName")
	private String friendName;
	
	@ManyToMany(mappedBy = "friends")
	private Set<MyGroup> myGroups =new HashSet<MyGroup>() ;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Set<MyGroup> getMyGroups() {
		return myGroups;
	}

	public void setMyGroups(Set<MyGroup> myGroups) {
		this.myGroups = myGroups;
	}
	
	

}
