package chapter3;

class Room {
	private int nr;

	public Room(int nr) {
		this.nr = nr;
	}
}

class Address {
	private int postcode;
	private String street, city;
	
	public Address(int postcode, String street, String city) {
		this.postcode = postcode;
		this.street = street;
		this.city = city;
	}
	
	
}

class Accomodation {
	// an accomodation has 0..* rooms
	private Room[] rooms;
	// an accomodation has one address
	private Address address;
	
	public Accomodation(Room[] rooms, Address address) {
		this.rooms = rooms;
		this.address = address;
	}
	
}

class Motel extends Accomodation {
	public Motel(Room[] rooms, Address address) {
		super(rooms, address);
	}	
}

class Hotel extends Accomodation {
	public Hotel(Room[] rooms, Address address) {
		super(rooms, address);
	}
}

class Restaurant {
	// a restaurant has one address
	private Address address;
}

public class InheritanceVSAggregation {

	public static void main(String[] args) {
		Hotel h = new Hotel(
				new Room[] { new Room(1), new Room(2) }, 
				new Address(85049, "Ingolstadt", "Esplanade 10"));
	}

}
