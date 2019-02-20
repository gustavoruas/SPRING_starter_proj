package oracle.starterSPRING.hr.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location {
		
	@Id    //USING oracle sequence sequenceName = "DEPARTMENTS_SEQ"
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq" )
	@SequenceGenerator(sequenceName = "LOCATIONS_SEQ", allocationSize = 1, name = "location_seq")
	@Column(name = "LOCATION_ID")
	private long locationID;
    
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CITY")
	private String city;
	
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	
	@Column(name="COUNTRY_ID")
	private String countryId;


	public long getLocationID() {
		return locationID;
	}
	

	
	
	public Location( long location_id,  String street,  String postal_code,  String city, 
			String state_province , String country_id)
	{
		this.locationID = location_id;
		this.streetAddress = street;
		this.postalCode = postal_code;
		this.city = city;
		this.stateProvince = state_province;
		this.countryId = country_id;	
		
	}
	
	//Default constructor null needed
	public Location() {
		
	}



	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStateProvince() {
		return stateProvince;
	}


	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}


	public String getCountryId() {
		return countryId;
	}


	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	
	
	
	
	

}
