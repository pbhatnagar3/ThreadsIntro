import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The following class takes a jab on the philosophers problem and solves it by making sure that a philosopher puts
 * back the leftChopStick when he/she is unable to get hold of the right one.
 * NOTE: There are no major changes made to the ChopStick. Also, there are other ways to solving this problem. 
 * @author pbhatnagar
 *
 */
public class DiningPhilosophersProblemSolved {
	public class ChopStick{
		Lock lock;
		public ChopStick(){
			lock = new ReentrantLock();
		}
		public boolean pickUp(){
			//one can go fancy here and use another version of tryLock and add wait to try waiting for the lock to be free.
			return lock.tryLock();
		}
		public void putDown(){
			lock.unlock();
		}
		
	}
	ChopStick leftStick;
	ChopStick rightStick;
	
	int bites = 10;
	
	public PhilosopherProblemSolved(ChopStick leftStick, ChopStick rightStick){
		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	public void eat(){
		if(!pickUp()){
			System.out.println("Sorry, you cannot eat at the moment. There are no pair of chopsticks available near you");
			return;
		}
		putDown();
	}
	
	public boolean pickUp(){
		if(!leftStick.pickUp()){
			return false;
		}
		if(!rightStick.pickUp()){
			//In the first round of writing this solution, I forgot to take care of this case.
			//This is the case where one has the left chopstick but does not have access to a right one.
			leftStick.putDown();
			return false;
		}
		return true;
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
