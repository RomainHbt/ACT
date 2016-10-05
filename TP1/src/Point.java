
public class Point {
	
	protected long x;
	protected long y;
	
	public Point(long x, long y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(long x){
		this.x = x;
	}
	
	public void setY(long y){
		this.y = y;
	}
	
	public long getX(){
		return this.x;
	}
	
	public long getY(){
		return this.y;
	}
	
}
