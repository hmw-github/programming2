package chapter8;

interface Lamp {
	void setStatus(double value);
	void setColor(int value);
}

interface Switch {
	double getStatus();
}

interface TemperatureSensor {
	double getTemperature();
}

abstract class Device {
	private String name;
	
	public Device(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public double[] getValues();
}

class LampWithSwitch extends Device implements Switch, Lamp {
	private double status;
	private int color;
	
	public LampWithSwitch(String name, double status, int color) {
		super(name);
		this.status = status;
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public double[] getValues() {
		return new double[] { status, color };
	}

	@Override
	public void setStatus(double value) {
		status = value;	
	}

	@Override
	public void setColor(int value) {
		color = value;
		
	}

	@Override
	public double getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "LampWithSwitch [status=" + status + ", color=" 
				+ Integer.toHexString(color) + ", name=" + getName() + "]";
	}
}

class SmartRubberDuck extends LampWithSwitch implements TemperatureSensor {
	private double temperature;
	
	public SmartRubberDuck() {
		this("Duck", 0.0, 0x000000, 0.0);
	}
	
	public SmartRubberDuck(String name, double status, int color, double temperature) {
		super(name, status, color);
		this.temperature = temperature;
	}

	public double[] getValues() {
		double[] values = super.getValues();
		return new double[] { values[0], values[1], temperature };
	}

	@Override
	public double getTemperature() {
		return temperature;
	}

	@Override
	public String toString() {
		return "SmartRubberDuck [temperature=" + temperature + ", toString()=" + super.toString() + "]";
	}

}

public class Controller {

	public static void main(String[] args) {
		/*
		SmartRubberDuck device1 = new SmartRubberDuck("Duck", 0.75, 0xFFFFFF, 28.0);
		_______ device2 = new LampWithSwitch("Table", 1, 0xFFFFFF);
		_______ device3 = new LampWithSwitch("Stand", 0.5, 0xFFFFFF);
		_______ sensor = device1;
		_______ deviceList1 = new _______ { device1, device2, device3 };
		_______ deviceList2 = new _______ { device1, device2, device3 };

		// Change colour to match the temperature
		for(_______ g1 : deviceList1) {
			if (sensor.getTemperature() > 20.0) {
				g1.setColor(0xFF0000); // rot
			} else {
				g1.setColor(0x0000FF); // blau				
			}
		}
		
		// Synchronise the lamp circuit
		double value = 0;
		
		for (_______ g2 : deviceList2) {
			value = Math.max(value, g2.getStatus());
		}
		for (_______ g3 : deviceList2) {
			g3.setStatus(value);
		}
		
		for(Lamp l : deviceList1) {
			System.out.println(l);
		}
		*/
	}

}
