import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Using the lock instead of synchronization. This is  a really basic implementation written for learning and fun purposes.
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D 
 */
public class LockedATM {
	private Lock lock;
	private int balance;

	public LockedATM(){
		lock = new ReentrantLock();
	}
	public int withdraw(int value){
		lock.lock();
		//now only one thread, the one that calls this method, will have access
		//to all the resources
		int temp = balance - value;
		// I am adding a Thread sleep to see if there is going to be an exception at anytime
		try{
			System.out.println("You are currently in the withdraw transaction and the system will be sleeping for 1/2 of a sec");
			Thread.sleep(500);
			balance = temp;
		}catch(InterruptedException e){
			System.out.println("something went wrong with the withdrawing transaction");
			e.printStackTrace();
		}
		lock.unlock();
		return balance;
	}
	
	public int deposit(int value){
		lock.lock();
		int temp = balance + value;
		try{
			System.out.println("You are currently in the deposit transaction and the system will sleep for 1/2 a sec");
			Thread.sleep(500);
			balance = temp;
		}catch(InterruptedException e){
			System.out.println("Something went wrong with the deposit transaction");
			e.printStackTrace();
		}
		lock.unlock();
		return balance;
	}
}
