package attributes;

import graph.InvalidTimeStampException;

public interface TimeStamp {
	
	long getStartingTimeStamp();
	
	void setStartingTime(long time) throws IllegalArgumentException;
	
	long getFinishingTime();
	
	void setFinishingTime(long time) throws IllegalArgumentException;
	
	long getDuration();
	
	void resetTimeStamp();
	
}
