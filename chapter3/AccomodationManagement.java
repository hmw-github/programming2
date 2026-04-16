package chapter3;

class Room {
	private int nr;

	public Room(int nr) {
		this.nr = nr;
	}
}

class Address {
	private int postcode;
	private String city, street;
	private int nr;
	
	public Address(int postcode, String city, String street, int nr) {
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.nr = nr;
	}	
}

class Accomodation {
	// an accomodation has 0..* rooms
	private Room[] rooms;
	// an accomodation has one address
	private Address address;
	
	public Accomodation(int noOfRooms, Address address) {
		this.rooms = new Room[noOfRooms];
		for (int i = 0; i < noOfRooms; ++i) {
			rooms[i] = new Room(i);
		}
		this.address = address;
	}
	
}

class Motel extends Accomodation {
	public Motel(int noOfRooms, Address address) {
		super(noOfRooms, address);
	}	
}

class Hotel extends Accomodation {
	public Hotel(int noOfRooms, Address address) {
		super(noOfRooms, address);
	}
}

class Restaurant {
	// a restaurant has one address
	private Address address;

	public Restaurant(Address address) {
		this.address = address;
	}
}

public class AccomodationManagement {

	public static void main(String[] args) {
		/**
         * Hotel with 20 rooms in Ing. Esplanade 10
         * Restaurant in Ing. Esplanade 10
         */
        Address adr = new Address(85049, "Ingolstadt", "Esplanade", 10);
        Hotel hotel = new Hotel(20, adr); // 20 rooms
        Restaurant reimanns = new Restaurant(adr);
	}
}
