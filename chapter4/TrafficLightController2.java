package chapter4;

public class TrafficLightController2 {
    private String state;
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
        state = "showing red";
        elapsedTime = 0;
        
        while (elapsedTime < 20) {
            switch (state) {
                case "showing red":                
                    System.out.println("Showing red...");
                    wait(3);
                    state = "showing red/yellow";
                    break;
                case "showing red yellow":                
                    System.out.println("Showing red/yellow...");
                    wait(1);
                    state = "showing green";
                    break;
                case "showing green":                
                    System.out.println("Showing green...");
                    wait(5);
                    state = "showing yellow";
                    break;
                case "showing yellow":                
                    System.out.println("Showing yellow...");
                    wait(2);
                    state = "showing red";
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        TrafficLightController2 ctrl = new TrafficLightController2();
        ctrl.run();
    }
}
