package blog.models;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long id;
	private String userName;
	private String pwHash;
	private String fullName;
	private Set<Post> posts = new HashSet<Post>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwHash() {
		return pwHash;
	}
	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwHash=" + pwHash + ", fullName=" + fullName + "]";
	}
	
	public User() {
		
	}
	public User(Long id, String userName, String fullName) {
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
	}
	
}
