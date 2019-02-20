package oracle.starterSPRING.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oracle.starterSPRING.hr.models.Location;

import oracle.starterSPRING.hr.services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	private LocationService locationService;
	
	@Autowired
	public LocationController(LocationService loc) {
		this.locationService = loc;
	}
	
	@RequestMapping("/list")
	public List<Location> getLocations(){
		return locationService.locationList();
	}
	
	@RequestMapping("/{id}")
	public Location getLocationById(@PathVariable Long id) {
		return locationService.getLocation(id);
	}
	
	@RequestMapping("/add")
	//RequestBody receives Json request object
	public Location addLocation(@RequestBody Location loc) {
		return locationService.saveLocation(loc);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteLocation(@PathVariable Long id) {
		return locationService.deleteLocation(id);
	}
	
	
	
}
