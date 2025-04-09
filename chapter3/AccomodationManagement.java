package programming2.chapter3;

class Accomodation {
	private Address address;
	private Room[] rooms;
	
	public Accomodation(int nrRooms, Address address) {
		this.address = address;
		
		// create rooms
		rooms = new Room[nrRooms];
		for (int nr = 1; nr <= nrRooms; ++nr) {
			rooms[nr-1] = new Room(nr);
		}
	}
	
	public String toString() {
		String result = address + ":\n";
		for (Room r : rooms) {
			result += " " + r;
		}
		return result;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
}

class Hotel extends Accomodation {
	private String name;
	
	public Hotel(int nrRooms, Address address, String name) {
		super(nrRooms, address);
		this.name = name;
	}

	@Override
	public String toString() {
		//return "Hotel [name=" + name + super.toString() + "]";
		return "Hotel [name=" + name + ", #rooms = " + getRooms().length + "]";
	}

}

class Motel {
}

class Restaurant {
	private Address address;

	public Restaurant(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [address=" + address + "]";
	}
}

class Address {
	private int postalCode;
	private String city, street;
	private int nr;
	
	public Address(int postalCode, String city, String street, int nr) {
		this.postalCode = postalCode;
		this.city = city;
		this.street = street;
		this.nr = nr;
	}

	@Override
	public String toString() {
		return "Address [postalCode=" + postalCode + ", city=" + city + ", street=" + street + ", nr=" + nr + "]";
	}
}

class Room {
	private int nr;

	public Room(int nr) {
		this.nr = nr;
	}

	@Override
	public String toString() {
		return "Room [nr=" + nr + "]";
	}
}

public class AccomodationManagement {
	public static void main(String[] args) {
		/**
		 * Hotel with 20 rooms in Ing. Esplanade 10 Restaurant in Ing. Esplanade 10
		 */
		Address adr = new Address(85049, "Ingolstadt", "Esplanade", 10);
		Hotel hotel = new Hotel(2, adr, "THI Hotel"); // 2 rooms
		Restaurant reimanns = new Restaurant(adr);
		System.out.println(hotel);
		System.out.println(reimanns);
	}
}
