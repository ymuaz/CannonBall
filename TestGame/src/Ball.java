import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Ball {
	private Point2D location;
	public Ball(Point2D initialLocation)
	{
		location=initialLocation;
	}
		public void Draw(Graphics g) {
			Graphics2D graphicDevice = (Graphics2D) g;
			Ellipse2D.Double shape = new Ellipse2D.Double(location.getX(), location.getY(), 50, 50);
			graphicDevice.setColor(Color.orange);
			graphicDevice.fill(shape);
		}
		Point2D getLocation() {
			return location;
		}
		void setLocation(Point2D location) {
			this.location = location;
		}
		
	}