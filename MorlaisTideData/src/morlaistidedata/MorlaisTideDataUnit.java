package morlaistidedata;

import PamUtils.LatLong;
import PamUtils.PamCalendar;
import PamguardMVC.PamDataUnit;

public class MorlaisTideDataUnit extends PamDataUnit {
	
	private double vx, vy, free_surface, depth;

	public MorlaisTideDataUnit(long timeMilliseconds, double vx, double vy, double free_surface, double depth) {
		super(timeMilliseconds);
		this.vx = vx;
		this.vy = vy;
		this.free_surface = free_surface;
		this.depth = depth;				
	}
	
	/**
	 * Heading clockwise from N in radians. 
	 * @return
	 */
	public double getHeading() {
		return Math.atan2(vx, vy);
	}
	
	public double getSpeed() {
		return Math.sqrt(vx*vx + vy*vy);
	}

	/**
	 * @return the vx
	 */
	public double getVx() {
		return vx;
	}

	/**
	 * @return the vy
	 */
	public double getVy() {
		return vy;
	}

	/**
	 * @return the free_surface
	 */
	public double getFree_surface() {
		return free_surface;
	}

	/**
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}

	@Override
	public String getSummaryString() {
		String str = String.format("<html>%s<br>"
				+ "Heading %3.1f%s<br>"
				+ "Speed %3.2f m/s</html>",
				PamCalendar.formatDateTime(getTimeMilliseconds()),
				getHeading()*180./Math.PI, LatLong.deg, getSpeed());
		return str;
	}



}
