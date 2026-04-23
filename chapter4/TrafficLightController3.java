package chapter4;

public class TrafficLightController3 {
    private String state;
    private int elapsedTime;
    
    private final String SHOWING_RED = "showing red";
    private final String SHOWING_RED_YELLOW = "showing red/yellow";
    private final String SHOWING_GREEN = "showing green";
    private final String SHOWING_YELLOW = "showing yellow";
    
    private void wait(int seconds) {
        try {
        	elapsedTime += seconds;
	   	    Thread.sleep(seconds * 1000); // milliseconds
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        state = SHOWING_RED;
        elapsedTime = 0;
        
        while (elapsedTime < 20) {
            switch (state) {
                case SHOWING_RED:                
                    System.out.println("Showing red...");
                    wait(3);
                    state = SHOWING_RED_YELLOW;
                    break;
                case SHOWING_RED_YELLOW:                
                    System.out.println("Showing red/yellow...");
                    wait(1);
                    state = SHOWING_GREEN;
                    break;
                case SHOWING_GREEN:                
                    System.out.println("Showing green...");
                    wait(5);
                    state = SHOWING_YELLOW;
                    break;
                case SHOWING_YELLOW:                
                    System.out.println("Showing yellow...");
                    wait(2);
                    state = SHOWING_RED;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController3 ctrl = new TrafficLightController3();
        ctrl.run();
    }
}
