package application;

public class  Flight implements Comparable<Flight> {
	private String flightNum;
	private String airline;
	private String source;
	private String destination;
	private int capacity;
	LinkList<Passenger> passengers=new LinkList<>();
	
	public Flight(String flightNum, String airline, String source, String destination, int capacity) {
		super();
		this.flightNum = flightNum;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNum=" + flightNum + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", capacity=" + capacity + "]";
	}

	@Override
	public int compareTo(Flight o) {
		return flightNum.compareTo(o.getFlightNum());
	}	
}
