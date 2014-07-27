/**
 * 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class ExtendedThread extends Thread{

	int counter = 0;
	
	public void run(){
		System.out.println("The ExtendedThread thread has started");
		while(this.counter <= 7){
			System.out.println("Working on incrementing the count variable in the extended thread. Patience dude... :D");
			System.out.println("The ExtendedThread thread will be sleeping for 1/4 of a sec");
			try {
				Thread.sleep(250);
				counter++;
				System.out.println(String.format("The value of the counter variable is %d", counter));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Houston, we have an issue. :P The thread is somehow interupted");
				e.printStackTrace();
			}
		}
			System.out.println("Phew... So everything in the ExtendedThread thread worked out perfectly");
	}
}
