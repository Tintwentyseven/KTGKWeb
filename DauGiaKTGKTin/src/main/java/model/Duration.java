package model;

import java.util.Calendar;

public class Duration {
	private int days;
	private int hours;
	private int minutes;
	private int seconds;

	public Duration(Calendar start, Calendar end) {
		long miliseconds = Math.abs(end.getTimeInMillis() - start.getTimeInMillis());
		this.days = (int)(miliseconds / 86400000);
		miliseconds %= 86400000;
		this.hours = (int)(miliseconds / 3600000);
		miliseconds %= 3600000;
		this.minutes = (int)(miliseconds / 60000);
		miliseconds %= 60000;
		this.seconds = (int) miliseconds;
	}

	public Duration(int days, int hours, int minutes, int seconds) {
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
	public String toString(){
		return (this.days == 0 ? "" : this.days + " ngày ") 
			+ (this.hours == 0 ? "" : this.hours + " giờ ")
			+ (this.minutes == 0 ? "" : this.minutes + " phút ")
			+ (this.seconds == 0 ? "" : this.seconds + " giây");
	}

}
