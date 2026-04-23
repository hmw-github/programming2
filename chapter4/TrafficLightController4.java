package chapter4;

enum TrafficLightStates {
	SHOWING_RED, SHOWING_RED_YELLOW, SHOWING_GREEN, SHOWING_YELLOW
}

public class TrafficLightController4 {
    private TrafficLightStates state;
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
        state = TrafficLightStates.SHOWING_RED;
        elapsedTime = 0;
                
        while (elapsedTime < 20) {
        	System.out.printf("state before waiting: %s (%d)\n",
        			state.name(), state.ordinal());
        	
            switch (state) {
                case SHOWING_RED:                
                    System.out.println("Showing red...");
                    wait(3);
                    state = TrafficLightStates.SHOWING_RED_YELLOW;
                    break;
                case SHOWING_RED_YELLOW:                
                    System.out.println("Showing red/yellow...");
                    wait(1);
                    state = TrafficLightStates.SHOWING_GREEN;
                    break;
                case SHOWING_GREEN:                
                    System.out.println("Showing green...");
                    wait(5);
                    state = TrafficLightStates.SHOWING_YELLOW;
                    break;
                case SHOWING_YELLOW:                
                    System.out.println("Showing yellow...");
                    wait(2);
                    state = TrafficLightStates.SHOWING_RED;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController4 ctrl = new TrafficLightController4();
        ctrl.run();
    }
}
