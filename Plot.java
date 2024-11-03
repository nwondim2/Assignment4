
public class Plot {
	// Attributes
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// Constructors
	Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	Plot(int x, int y, int width, int depth){
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setDepth(depth);
	}
	
	Plot(Plot otherPlot){
		x = otherPlot.getX();
		y = otherPlot.getY();
		width = otherPlot.getWidth();
		depth = otherPlot.getDepth();
	}
	
	// Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// Methods
	public boolean overlaps(Plot otherPlot) {
		int otherX = otherPlot.getX();
		int otherY = otherPlot.getY();
		int otherWidth = otherPlot.getWidth();
		int otherDepth = otherPlot.getDepth();
	
		
		if(x + width <= otherX || otherX + otherWidth <= x || y + depth <= otherY || otherY + otherDepth < y) {
			return false;
		}
		return true;
	}
	
	public boolean encompasses(Plot otherPlot) {
		int otherX = otherPlot.getX();
		int otherY = otherPlot.getY();
		int otherWidth = otherPlot.getWidth();
		int otherDepth = otherPlot.getDepth();
		
		if(x <= otherX && y <= otherY && x + width >= otherX + otherWidth && y + depth >= otherY + otherDepth) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "" + x + "," + y + "," + width + "," + depth;
	}
}
