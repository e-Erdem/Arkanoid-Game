package Arkanoid;

import java.text.SimpleDateFormat;
import java.util.Date;

public class playerData {
	
	private String name;
	private int score;
	private String date;
	
	public playerData(String name1, int score1, String date1)
	{
		 name = name1;
		 score = score1;
		 date = date1;
	}
	
	public String toString()
	{
		return ("NAME:"+name+":SCORE:"+score+":DATE:"+date+"\n");
	}
	public String printonList()
	{
		return("Name: "+name+" Score: "+score+" Date: "+date);
	}
	
	public String getDate()
	{
		return date;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	

}
