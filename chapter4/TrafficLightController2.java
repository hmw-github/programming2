package programming2.chapter4;

enum TrafficLightState {
//  0         1         2                3           4
    INACTIVE, SHOW_RED, SHOW_RED_YELLOW, SHOW_GREEN, SHOW_YELLOW
}

/**
 * state transitions: red - red/yellow - green - yellow - red ...
 */
public class TrafficLightController2 {
    private TrafficLightState state;
    
    private void wait(int seconds) {
        try {
	   	    Thread.sleep(seconds * 1000); // milliseconds
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        state = TrafficLightState.SHOW_RED;
        
        for (;;) {
        	System.out.println(state);
	        switch (state) {
	        case SHOW_RED: 
	        	wait(2);
	        	state = TrafficLightState.SHOW_RED_YELLOW;
	        	break;
	        case SHOW_RED_YELLOW: 
	        	wait(1);
	        	state = TrafficLightState.SHOW_GREEN;
	        	break;
	        case SHOW_GREEN: 
	        	wait(4);
	        	state = TrafficLightState.SHOW_YELLOW;
	        	break;
	        case SHOW_YELLOW: 
	        	wait(1);
	        	state = TrafficLightState.SHOW_RED;
	        	break;
	        default:
	        	throw new RuntimeException("Invalid state: " + state);
	        }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController2 ctrl = new TrafficLightController2();
        ctrl.run();
    }
}
