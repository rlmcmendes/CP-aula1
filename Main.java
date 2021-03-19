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
		
	}


	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		long timeInitial=System.currentTimeMillis();
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int nPoints=in.nextInt();
		int nThreads=in.nextInt();
		Exercise[] t=new Exercise[nThreads];
		int nInside=0;
		for(int i=0;i<nThreads;i++) {
			Exercise e=new Exercise((int ) (nPoints/nThreads));
			t[i]=e;
			t[i].start();
		}
		for(int i=0;i<nThreads;i++) {
			t[i].join();
			nInside+=t[i].getPointsInside();
		}
		double ro= ((double ) nInside/ (double )nPoints);
		double pi=4.0*ro;
		long timefinal=System.currentTimeMillis();
		System.out.println("numero do pi: "+pi);
		System.out.println("total time: "+((timefinal-timeInitial)*0.001)+" segundos");
		
	}

}
