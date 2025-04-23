package programming2.chapter4;

/**
 * state transitions: red - red/yellow - green - yellow - red ...
 */
public class TrafficLightController1 {
    private String state;
    
    private void wait(int seconds) {
        try {
	   	    Thread.sleep(seconds * 1000); // milliseconds
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        state = "red";
        
        for (;;) {
        	System.out.println(state);
	        switch (state) {
	        case "red": 
	        	wait(2);
	        	state = "red/yellow";
	        	break;
	        case "red/yellow": 
	        	wait(1);
	        	state = "Green";
	        	break;
	        case "green": 
	        	wait(4);
	        	state = "yellow";
	        	break;
	        case "yellow": 
	        	wait(1);
	        	state = "red";
	        	break;
	        default:
	        	throw new RuntimeException("Invalid state: " + state);
	        }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController1 ctrl = new TrafficLightController1();
        ctrl.run();
    }
}
