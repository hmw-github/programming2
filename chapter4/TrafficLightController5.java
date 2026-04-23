package chapter4;

import java.util.Scanner;

enum TrafficLightStatesWithDuration {
	SHOWING_RED(3), SHOWING_RED_YELLOW(1), 
	SHOWING_GREEN(5), SHOWING_YELLOW(2);
	
	private int duration;
	
	private TrafficLightStatesWithDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
}

public class TrafficLightController5 {
    private TrafficLightStatesWithDuration state;
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
        state = TrafficLightStatesWithDuration.SHOWING_RED;
        elapsedTime = 0;
        
        // output all values
        for (TrafficLightStatesWithDuration s : TrafficLightStatesWithDuration.values()) {
        	System.out.printf("state: %s (%d), duration = %d\n",
        			s.name(), s.ordinal(), s.getDuration());
        }
        
        TrafficLightStatesWithDuration stateFor2 =  TrafficLightStatesWithDuration.values()[2];
        
        Scanner scanner = new Scanner(System.in);
        String stateName;
        
        System.out.print("Initial state: ");
        stateName = scanner.nextLine();
        state = TrafficLightStatesWithDuration.valueOf(stateName);
                
        while (elapsedTime < 20) {
        	System.out.printf("state before waiting: %s (%d)\n",
        			state.name(), state.ordinal());
        	
            switch (state) {
                case SHOWING_RED:                
                    System.out.println("Showing red...");
                    wait(state.getDuration());
                    state = TrafficLightStatesWithDuration.SHOWING_RED_YELLOW;
                    break;
                case SHOWING_RED_YELLOW:                
                    System.out.println("Showing red/yellow...");
                    wait(state.getDuration());
                    state = TrafficLightStatesWithDuration.SHOWING_GREEN;
                    break;
                case SHOWING_GREEN:                
                    System.out.println("Showing green...");
                    wait(state.getDuration());
                    state = TrafficLightStatesWithDuration.SHOWING_YELLOW;
                    break;
                case SHOWING_YELLOW:                
                    System.out.println("Showing yellow...");
                    wait(state.getDuration());
                    state = TrafficLightStatesWithDuration.SHOWING_RED;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController5 ctrl = new TrafficLightController5();
        ctrl.run();
    }
}
