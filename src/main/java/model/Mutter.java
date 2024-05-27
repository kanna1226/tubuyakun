package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Mutter implements Serializable {
	private int id;
	private String userId;
	private String userName;
	private String text;
	private Timestamp timestamp;
	
	public Mutter() {}
	public Mutter(String userId, String userName, String text) {
		this.userId = userId;
		this.userName = userName;
		this.text = text;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	public Mutter(int id,String userId, String userName, String text, Timestamp timestamp) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public int getId() { return id; }
	public String getUserId() { return userId; }
	public String getUserName() { return userName; }
	public String getText() { return text; }
	public Timestamp getTimestamp() { return timestamp; }
}
