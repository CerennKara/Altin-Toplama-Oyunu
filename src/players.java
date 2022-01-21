public class players {
	public int step=3;
	public int goldNumber;
	public int[][] location=new int[1][1];
	public int[][] goal=new int[1][1];
	public String name;
	public boolean haveGoal;
	public int x,total,move,target,stepnumber,spentGold;
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getGoldNumber() {
		return goldNumber;
	}

	public void setGoldNumber(int goldNumber) {
		this.goldNumber = goldNumber;
	}
	
}
class A extends players{
	public A() {
		location=new int[][] {{0,0}};
		goal=new int[][] {{0,0}};
		name="A";
		goldNumber=200;
		x=0;
		haveGoal=false;
		total=0;
		move=5;
		target=5;
		stepnumber=0;
		spentGold=0;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
}
class B extends players{
	public B() {
		location=new int[][] {{0,19}};
		goal=new int[][] {{0,0}};
		name="B";
		goldNumber=200;
		x=0;
		haveGoal=false;
		total=0;
		move=5;
		target=10;
		stepnumber=0;
		spentGold=0;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
}
class C extends players{
	public C() {
		location=new int[][] {{19,19}};
		goal=new int[][] {{0,0}};
		name="C";
		goldNumber=200;
		x=0;
		haveGoal=false;
		total=0;
		move=5;
		target=15;
		stepnumber=0;
		spentGold=0;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
}
class D extends players{
	public D() {
		location=new int[][] {{19,0}};
		goal=new int[][] {{0,0}};
		name="D";
		goldNumber=200;
		x=0;
		haveGoal=false;
		total=0;
		move=5;
		target=20;
		stepnumber=0;
		spentGold=0;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}	
}

