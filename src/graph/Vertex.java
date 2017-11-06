package graph;

import java.util.LinkedList;
import java.util.List;

import attributes.Colorable;
import attributes.Data;
import attributes.IntegerWeighted;
import attributes.PathTracer;
import attributes.TimeStamp;

public class Vertex extends Node implements Colorable, IntegerWeighted, PathTracer<Vertex>, TimeStamp{

	private Color color;
	private int weight ;
	private int distance;
	private Vertex parent;
	private TimeStamp timeStamp;
	private boolean isDistanceInfinite;
	
	private static class TimeStamp {
		long startingTime;
		long finishingTime;
		
		long getDuration(){
			return finishingTime - startingTime;
		}
		
	}
	
	
	public static class Info implements Data {
		private String id;
		
		public Info(String id){
			this.id = id;
		}
		
		@Override
		public String toString(){
			return id;
		}
	}
	
	
	
	
	public Vertex(Info attributes) {
		super(attributes);
		color = Color.NONE;
		weight = 0;
		isDistanceInfinite = true;
		distance = 0;
		parent = null;
		timeStamp.startingTime = 0;
		timeStamp.finishingTime = 0;
	}


	
	
	
	public Info getData(){
		return (Info)data;
	}
	

	@Override
	public long getStartingTimeStamp() {
		return timeStamp.startingTime;
	}





	@Override
	public void setStartingTime(long time) throws IllegalArgumentException {
		if(time < timeStamp.startingTime)
			throw new IllegalArgumentException("Argument time cannot be less than getStartingTimeStamp()");
		
		timeStamp.startingTime = time;
	}





	@Override
	public long getFinishingTime() {
		return timeStamp.finishingTime;
	}





	@Override
	public void setFinishingTime(long time) throws IllegalArgumentException {
		if(time < timeStamp.finishingTime || time < timeStamp.startingTime)
			throw new IllegalArgumentException("Argument time cannot be less than getFinishingTimeStamp()or getStartingTimeStamp()");
		
		timeStamp.finishingTime = time;
	}





	@Override
	public long getDuration() {
		return timeStamp.getDuration();
	}
	
	
	
	
	@Override
	public void resetTimeStamp(){
		timeStamp.startingTime = 0;
		timeStamp.finishingTime = 0;
	}





	@Override
	public AbstractNode getParent() {
		return parent;
	}





	@Override
	public void setParent(Vertex parent) {
		this.parent = parent;
	}





	@Override
	public int getDistance() {
		return distance;
	}





	@Override
	public void setDistance(int distance) {
		this.distance = distance;
		
	}





	@Override
	public boolean isDistanceInfinite() {
		return isDistanceInfinite;
	}





	@Override
	public void setDistanceInfinite(boolean isInfinite) {
		isDistanceInfinite = isInfinite;
		
	}





	@Override
	public List<Vertex> tracePath() {
		List<Vertex> path= new LinkedList<>();
		
		Vertex temp = this;
		while(temp != null){
			path.add(temp);
			temp = temp.parent;
		}
		
		return path;
	}





	@Override
	public int getWeight() {
		return weight;
	}





	@Override
	public void setWeight(int weight) {
		this.weight = weight;
		
	}





	@Override
	public Color getColor() {
		return color;
	}





	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}


}
