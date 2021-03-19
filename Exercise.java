
public class Exercise {
	private int nPoints,nThreads;
	private int counter=0;
	private int numberOfThread=1;
	private Thread[] tvec;
	public Exercise(int numberOfPoints,int numberOfThreads)
	{
		this.nPoints=numberOfPoints;
		this.nThreads=numberOfThreads;
		tvec=new Thread[nThreads];
	}
	public class runnable implements Runnable {

		@Override
		public void run() {
			for(int j=0;j< (float ) (nPoints/ nThreads)*numberOfThread;j++) {
				double x=Math.random();
				double y=Math.random();
				if((Math.pow(x, 2)+Math.pow(y, 2))<=1) {

					counter++;
				}
			}
			
		}
		
	}
	public void makeThreads() throws InterruptedException {
		
		for(int i=0;i<nThreads;i++,numberOfThread++) {
		Thread t=new Thread(new Exercise(nPoints,nThreads).new runnable());
		t.start();
		tvec[(int) numberOfThread-1]=t;
		}
		for(int i=0;i<nThreads;i++) {
			tvec[i].join();
		}
	}
	private boolean anyThreadAlive() {
		for(int i=0;i<nThreads;i++) {
			if(tvec[i].isAlive()) return true;
		}
		return false;
	}
	public double results() {
		double res=0;
		while(anyThreadAlive()) {
			if(!anyThreadAlive()) {
				res=4.0*( (double) (counter/nPoints));
				break;
			}
		}
		return res;
	}
	
}
