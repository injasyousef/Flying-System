package application;

public class Passenger implements Comparable<Passenger> {
	private String flightNum;
	private String ticketNum;
	private String name;
	private String passportNum;
	private String nationality;
	private String birthDate;
	
	
	public Passenger(String flightNum,String ticketNum, String name, String passportNum, String nationality, String birthDate) {
		super();
		this.flightNum=flightNum;
		this.ticketNum = ticketNum;
		this.name = name;
		this.passportNum = passportNum;
		this.nationality = nationality;
		this.birthDate = birthDate;
	}


	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Passenger [flightNum=" + flightNum + ", ticketNum=" + ticketNum + ", name=" + name + ", passportNum="
				+ passportNum + ", nationality=" + nationality + ", birthDate=" + birthDate + "]";
	}

	@Override
	public int compareTo(Passenger o) {
		return this.name.compareTo(o.getName());
	}
}
