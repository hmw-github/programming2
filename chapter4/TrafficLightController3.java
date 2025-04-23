package programming2.chapter4;

enum TrafficLightStatePlus {
    INACTIVE(0, 0), 
    SHOW_RED(0xff0000, 2), 
    SHOW_RED_YELLOW(0xffffff, 1), 
    SHOW_GREEN(0x00ff00, 4), 
    SHOW_YELLOW(0xffff00, 1);
	
	private int rgb, duration;
	
	private TrafficLightStatePlus(int rgb, int duration) {
		this.rgb = rgb;
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public String toString() {
		return name() + "(" + ordinal() + "): rgb=" + rgb + ", duration=" + duration; 
	}
}

/**
 * state transitions: red - red/yellow - green - yellow - red ...
 */
public class TrafficLightController3 {
    private TrafficLightStatePlus state;
    
    private void wait(int seconds) {
        try {
	   	    Thread.sleep(seconds * 1000); // milliseconds
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        state = TrafficLightStatePlus.SHOW_RED;
        
        for (;;) {
        	System.out.println(state);
        	wait(state.getDuration());

        	switch (state) {
	        case SHOW_RED: 
	        	state = TrafficLightStatePlus.SHOW_RED_YELLOW;
	        	break;
	        case SHOW_RED_YELLOW: 
	        	state = TrafficLightStatePlus.SHOW_GREEN;
	        	break;
	        case SHOW_GREEN: 
	        	state = TrafficLightStatePlus.SHOW_YELLOW;
	        	break;
	        case SHOW_YELLOW: 
	        	state = TrafficLightStatePlus.SHOW_RED;
	        	break;
	        default:
	        	throw new RuntimeException("Invalid state: " + state);
	        }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController3 ctrl = new TrafficLightController3();
        ctrl.run();
    }
}
