import java.util.Scanner;

/**
 * Testing the thread implementation of the RunnableExample and for another class (name TBD) that extends the thread interface.
 * NOTE: This function was written to just see the very basic implementation of threads. There are tonnes of more efficient ways
 * of doing the same thing and writing this piece of code.0
 * @author pbhatnagar
 *If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D 
 */
public class Tester {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 0 for using the Runnable interface as the thread or any other number for using the ExtentedThread class");
		int mode = scan.nextInt();

		if(mode == 0){
			RunnableExample instance = new RunnableExample();
			Thread thread = new Thread(instance);
			thread.start();

			System.out.println("We have started the execution of the thread from the main function");
			while(instance.counter <= 7){
				System.out.println("The thread from the main method is going to sleep for 1/2 of a sec");
				try{
					Thread.sleep(500);
				}
				catch(InterruptedException e){
					System.out.println("ohh god. I think we have an issue and it is coming from the main method");
					e.printStackTrace();
				}
			}
			System.out.println("The thread execution from the main finished");
		}
		else{
			ExtendedThread instance = new ExtendedThread();
			instance.start();

			System.out.println("We have started the execution of the thread from the main function");
			while(instance.counter <= 7){
				System.out.println("The thread from the main method is going to sleep for 1/2 of a sec");
				try{
					Thread.sleep(500);
				}
				catch(InterruptedException e){
					System.out.println("ohh god. I think we have an issue and it is coming from the main method");
					e.printStackTrace();
				}
			}
			System.out.println("The thread execution from the main finished");
		}
	}
}

