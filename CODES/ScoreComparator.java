package Arkanoid;

import java.util.Comparator;

public class ScoreComparator implements Comparator<playerData> {

	@Override
	public int compare(playerData o1, playerData o2) {
		// TODO Auto-generated method stub
		
		int hello =	o1.getScore() - o2.getScore();
		if(hello != 0)
		{
			return -hello;
			
		}
		return 0;
	}
	
	

}
