import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Here is the classic philosopher problem. The one where a group of philosophers are sitting on a circular table and 
 * there is a chopstick in between each of them and as a philosopher, although they need both the chopsticks to eat, 
 * they always go for picking up the left one
 * NOTE: this situation MAY CREATE A DEADLOCK (when all the philosophers pickup the left stick and are waiting for the right one).
 *  For a solution to this, see the other class called "PhilosopherProblemSolved.java" 
 * @author pbhatnagar
 *
 */
public class DiningPhilosophersProblem extends Thread{

	public class ChopStick{
		Lock lock;
		public ChopStick(){
			lock = new ReentrantLock();
		}
		public void pickUp(){
			lock.lock();
		}
		public void putDown(){
			lock.unlock();
		}
		
	}
	
	ChopStick leftStick;
	ChopStick rightStick;
	
	int bites = 10;
	
	public DiningPhilosophersProblem(ChopStick leftStick, ChopStick rightStick){
		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	public void eat(){
		pickUp();
		putDown();
	}
	
	public void pickUp(){
		leftStick.pickUp();
		rightStick.pickUp();
	}
	
	public void putDown(){
		leftStick.putDown();
		rightStick.putDown();
	}

	//When we do Thread.start(). the run function is automatically called	
	public void run(){
		while(bites > 0){
			try{
				eat();
				System.out.println("eating right now. Will take 1/2 a second to take a bite");
				Thread.sleep(500);
				bites--;
			}catch(InterruptedException e){
				System.out.println("There is some issue while I was eating :/");
			}
		}
	}
	
}
