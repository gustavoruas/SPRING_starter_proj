package oracle.starterSPRING.hr.services;

import java.util.List;

import oracle.starterSPRING.hr.models.Location;

public interface LocationServInterface {

	List<Location> locationList();

	Location getLocation(Long id);

	Location saveLocation(Location location);
	
	String deleteLocation(Long id);
	
	
}
