package model;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampToDateLogic {
	public Date timestampToDate(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		return date;
	}
}
