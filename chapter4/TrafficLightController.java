package chapter4;

public class TrafficLightController {
    private int state;
    private int elapsedTime;
    
    private void wait(int seconds) {
        try {
        	elapsedTime += seconds;
	   	    Thread.sleep(seconds * 1000); // milliseconds
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        state = 0; // red
        elapsedTime = 0;
        
        while (elapsedTime < 20) {
            switch (state) {
                case 0:                
                    System.out.println("Showing red...");
                    wait(3);
                    state = 1;
                    break;
                case 1:                
                    System.out.println("Showing red/yellow...");
                    wait(1);
                    state = 2;
                    break;
                case 2:                
                    System.out.println("Showing green...");
                    wait(5);
                    state = 3;
                    break;
                case 3:                
                    System.out.println("Showing yellow...");
                    wait(2);
                    state = 0;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController ctrl = new TrafficLightController();
        ctrl.run();
    }
}
