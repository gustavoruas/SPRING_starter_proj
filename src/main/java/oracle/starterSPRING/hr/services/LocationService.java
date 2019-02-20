package oracle.starterSPRING.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import oracle.starterSPRING.hr.models.Location;
import oracle.starterSPRING.hr.repositories.LocationRepository;

@Service
public class LocationService implements LocationServInterface {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationService(LocationRepository locrep) {
		this.locationRepository = locrep;
	}
	
	@Override
	public List<Location> locationList() {
		
		return locationRepository.findAll();
	}

	@Override
	public Location getLocation(Long id) {
		
		return locationRepository.getOne(id);
	}

	@Override
	public Location saveLocation(Location location) {
		
		if(locationRepository.existsById(location.getLocationID())) {
			return locationRepository.save(location);
		}else {
			Location loc = location;
			return locationRepository.save(loc);
		}

	}

	@Override
	public String deleteLocation(Long id) {
		
		try {
			locationRepository.deleteById(id);
			return "{Deleted location successfully}";
		}catch(JpaSystemException jpaE) {
			return "Unable to delete Location - " + id.toString() +"<BR>";
		}

	}

}
