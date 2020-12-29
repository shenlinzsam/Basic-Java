package Wang;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Body implements KeyListener{
	private int x;
	private int y;
	private static final int r=10;
	public Body(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("响应了键盘事件");
		if(e.getKeyCode()==e.VK_UP) {
			System.out.println("按了上");
			y--;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
