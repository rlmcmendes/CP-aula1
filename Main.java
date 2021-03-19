import java.util.Scanner;

/**
 * 
 */

/**
 * @author Principal
 *
 */
public class Main {
	public static volatile double counter=0;
	public static volatile float numberOfThread=1;
	/**
	 * 
	 */
	public Main() {
		
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner in=new Scanner(System.in);
		int nPoints=in.nextInt();
		int nThreads=in.nextInt();
		Exercise e=new Exercise(nPoints,nThreads);
		e.makeThreads();
		System.out.println(e.results());
	}

}
