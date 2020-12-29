package Wang;

import java.awt.Color;
import Wang.Direction;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements Runnable,KeyListener{
//	private Body body=new Body(400, 300);
	private Snake snake;
	private Body random=new Body(20,20);
	private boolean flag=false;
	private boolean pause=false;
	
	public MyFrame() {
		snake=new Snake();
		this.setVisible(true);
		this.setSize(400, 300);
		this.setTitle("GreedSnake");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		this.addKeyListener(this);
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(flag==false) {
			createRandom();
		}
		drawRandom(g);
//		g.setColor(Color.blue);
//		g.drawOval(400, 300, 200, 200);
//		g.fillOval((int)body.getX(), (int)body.getY(), 10, 10);
		drawSnake(g);
		
	}
	public void drawSnake(Graphics g) {
		g.setColor(Color.RED);
		List<Body> list=snake.getSnk();
		Body head=snake.getHead();
		g.fillOval(head.getX(), head.getY(), 10, 10);
		for(int i=1;i<list.size();i++) {
			g.setColor(Color.BLUE);
			Body tmp=list.get(i);
			g.fillOval(tmp.getX(), tmp.getY(), 10, 10);
		}
	}
	
	public void createRandom( ) {
		random=new Body((int)(Math.random()*570), (int)(Math.random()*570));
//		random=new Body(400, 300);
		System.out.println(random.getX()+","+random.getY());
		
	}
	public void drawRandom(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(random.getX(), random.getY(), 10, 10);
		flag=true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub\
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
//			body.setX(body.getX()-5);
			if(pause==false) {
				gameover();
				move();
				gameover();
				this.update(getGraphics());
				
			}
			
		}
		
	}
	
	public void gameover() {
		// TODO Auto-generated method stub
		List<Body> list=snake.getSnk();
		for(int i=1;i<list.size();i++) {
			if((snake.getHead().getX()==list.get(i).getX()&&
					snake.getHead().getY()==list.get(i).getY())||
					snake.getHead().getX()<=0||
					snake.getHead().getY()<=0||
			snake.getHead().getX()>600||
			snake.getHead().getY()>600){
				new JOptionPane().showMessageDialog(null, "GameOver");
				System.exit(0);
			}
		}
	}
	public void move() {
//		System.out.println(snake.getHead().getX()+","+snake.getHead().getY());
		if(snake.getDirection().equals(Direction.UP)) {
			snake.keyup();
		}
		if(snake.getDirection().equals(Direction.DOWN)) {
			snake.keydown();
		}
		if(snake.getDirection().equals(Direction.LEFT)) {
			snake.keyleft();
		}
		if(snake.getDirection().equals(Direction.RIGHT)) {
			snake.keyright();
		}
		if(isCollapse(snake.getHead(), random)) {
			snake.getLonger();
//			System.out.println("撞上了");
			flag=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("jianpan"+e.getKeyCode());
//		System.out.println("keychar"+e.getKeyChar());
//		if(e.getKeyChar()=='w') {
//			body.setY(body.getY()-5);
//		}
//		if(e.getKeyChar()=='w') {
//			snake.keyup();
//		}
//		if(e.getKeyChar()=='s') {
//			snake.keydown();
//		}
//		if(e.getKeyChar()=='a') {
//			snake.keyleft();
//		}
//		if(e.getKeyChar()=='d') {
//			snake.keyright();
//		}
		if(e.getKeyChar()=='w') {
			snake.setDirection(Direction.UP);
		}
		if(e.getKeyChar()=='s') {
			snake.setDirection(Direction.DOWN);
		}
		if(e.getKeyChar()=='a') {
			snake.setDirection(Direction.LEFT);
		}
		if(e.getKeyChar()=='d') {
			snake.setDirection(Direction.RIGHT);
		}
		if(e.getKeyChar()=='p') {
			pause=!pause;
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
	public boolean isCollapse(Body pt1,Body pt2) {
		if(Math.pow(Math.abs(pt1.getX()-pt2.getX()), 2)+Math.pow(Math.abs(pt1.getY()-pt2.getY()), 2)<100){
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		MyFrame myFrame=new MyFrame();
		Thread t=new Thread(myFrame);
		t.start();
	}
	
	
}
