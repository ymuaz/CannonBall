import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(600, 600);
		final GameScene gameScene = new GameScene();
		f.add(gameScene);
		f.setVisible(true);
		gameScene.StartScene();
		f.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					gameScene.addSceneObject(new Ball(new Point2D.Double(MouseInfo.getPointerInfo().getLocation().x,
							MouseInfo.getPointerInfo().getLocation().y)));
					break;
				}

			}
		});
	}
}
