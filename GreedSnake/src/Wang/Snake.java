package Wang;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int x;
	private int y;
	private Body head;
	private Body tail;
	private List<Body> snk;
	private Direction direction=Direction.LEFT;
	public Snake() {
		this.x=400;
		this.y=300;
		head=new Body(x, y);
		snk=new ArrayList<Body>();
		snk.add(head);
		for(int i=0;i<4;i++) {
			Body tmp=new Body(snk.get(snk.size()-1).getX()+10, y);
			snk.add(tmp);
		}
		
		
	}
	public Snake(int x,int y) {
		this.x=x;
		this.y=y;
		head=new Body(x, y);
		snk=new ArrayList<Body>();
		snk.add(head);
		for(int i=0;i<4;i++) {
			Body tmp=new Body(snk.get(snk.size()-1).getX()+10, y);
			snk.add(tmp);
		}
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
	public Body getHead() {
		return head;
	}
	public void setHead(Body head) {
		this.head = head;
	}
	public Body getTail() {
		return tail;
	}
	public void setTail(Body tail) {
		this.tail = tail;
	}
	public List<Body> getSnk() {
		return snk;
	}
	public void setSnk(List<Body> snk) {
		this.snk = snk;
	}
	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public void keyup() {
		
		if(snk.size()>1) {
			for(int i=snk.size()-1;i>0;i--) {
				snk.get(i).setX(snk.get(i-1).getX());
				snk.get(i).setY(snk.get(i-1).getY());
			}
		}
		head.setY(head.getY()-5);
		snk.get(0).setY(head.getY()-5);
		
	}
	public void keydown() {
		
		if(snk.size()>1) {
			for(int i=snk.size()-1;i>0;i--) {
				snk.get(i).setX(snk.get(i-1).getX());
				snk.get(i).setY(snk.get(i-1).getY());
			}
		}
		head.setY(head.getY()+5);
		snk.get(0).setY(head.getY()+5);
		
	}
	
	public void keyleft() {
		
		if(snk.size()>1) {
			for(int i=snk.size()-1;i>0;i--) {
				snk.get(i).setX(snk.get(i-1).getX());
				snk.get(i).setY(snk.get(i-1).getY());
			}
		}
		head.setX(head.getX()-5);
		snk.get(0).setX(head.getX()-5);
		
	}
	
	public void keyright() {
		
		if(snk.size()>1) {
			for(int i=snk.size()-1;i>0;i--) {
				snk.get(i).setX(snk.get(i-1).getX());
				snk.get(i).setY(snk.get(i-1).getY());
			}
		}
		head.setX(head.getX()+5);
		snk.get(0).setX(head.getX()+5);
		
	}
	public void getLonger() {
		// TODO Auto-generated method stub
		if(snk.size()>=2) {
			Body tmp1=snk.get(snk.size()-1);
			Body tmp2=snk.get(snk.size()-2);
			if(tmp1.getX()==tmp2.getX()&&tmp1.getY()>tmp2.getY()) {
				Body newadd=new Body(tmp1.getX(), tmp1.getY()+10);
				snk.add(newadd);
			}
			if(tmp1.getX()==tmp2.getX()&&tmp1.getY()<tmp2.getY()) {
				Body newadd=new Body(tmp1.getX(), tmp1.getY()-10);
				snk.add(newadd);
			}
			if(tmp1.getY()==tmp2.getY()&&tmp1.getX()>tmp2.getX()) {
				Body newadd=new Body(tmp1.getX()+10, tmp1.getY());
				snk.add(newadd);
			}
			if(tmp1.getY()==tmp2.getY()&&tmp1.getX()<tmp2.getX()) {
				Body newadd=new Body(tmp1.getX()-10, tmp1.getY());
				snk.add(newadd);
			}
		}
	}
	
	
	}
