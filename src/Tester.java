/**
 * Testing the thread implementation of the RunnableExample and for another class (name TBD) that extends the thread interface
 * @author pbhatnagar
 *
 */
public class Tester {

	public static void main(String[] args){
		RunnableExample runnableInstance = new RunnableExample();
		Thread thread = new Thread(runnableInstance);
		thread.start();
		System.out.println("We have started the execution of the thread from the main function");
		while(runnableInstance.counter <= 7){
			System.out.println("The thread from the main method is going to sleep for 1/2 of a sec");
			try{
				thread.sleep(500);
			}
			catch(InterruptedException e){
				System.out.println("ohh god. I think we have an issue and it is coming from the main method");
				e.printStackTrace();
			}
		}
		System.out.println("The thread execution from the main finished");
	}
}
