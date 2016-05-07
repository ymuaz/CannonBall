import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScene extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer gameSync;
	private List<Ball> sceneObjectList;

	public GameScene() {
		// TODO Auto-generated constructor stub
		gameSync = new Timer(1, this);
		sceneObjectList =  Collections.synchronizedList(new ArrayList<Ball>());
		sceneObjectList.add(new Ball(new Point2D.Double(MouseInfo.getPointerInfo().getLocation().x,
				MouseInfo.getPointerInfo().getLocation().y)));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D graphicSpace = (Graphics2D) g;
		graphicSpace.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		synchronized (sceneObjectList) 
		{
			Iterator<Ball> iterator = sceneObjectList.iterator();
			while (iterator.hasNext()) 
			{
				Ball currentBall=iterator.next();
				currentBall.Draw(g);
			}
		}
	}
	
	public void addSceneObject(Ball b)
	{
		sceneObjectList.add(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void StartScene() {
		gameSync.start();
	}

	public void PauseScene() {
		gameSync.stop();
	}

	public void RestartScene() {
		gameSync.restart();
	}
}