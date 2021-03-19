
public class Exercise extends Thread {
	private int counter=0;
	private int numberOfPointsInThread;
	public Exercise(int numberOfPointsInThreads)
	{
		this.numberOfPointsInThread=numberOfPointsInThreads;
	}
	

		@Override
		public void run() {
			for(int j=0;j< numberOfPointsInThread;j++) {
				double x=Math.random();
				double y=Math.random();
				if((Math.pow(x, 2)+Math.pow(y, 2))<=1) {

					counter++;
				}
			}
			
		}
		public int getPointsInside()
		{
			return counter;
		}

	
}
