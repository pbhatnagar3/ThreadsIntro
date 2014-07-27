/**
 * The following class will implement the Runnable interface and we will try to do some threading in our program 
 * @author pbhatnagar
 *If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D 
 */
public class RunnableExample implements Runnable{

	//always remember to initialize variable
	int counter = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("The runnable thread has started");
		while(this.counter <= 7){
			System.out.println("Working on incrementing the count variable in the runnable thread. Patience dude... :D");
			System.out.println("The runnable thread will be sleeping for 1/4 of a sec");
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
			System.out.println("Phew... So everything in the runnable thread worked out perfectly");
	}

	
	
}
