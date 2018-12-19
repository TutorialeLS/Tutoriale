package pl.javastart.device;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

	private DeviceRepository deviceRepository;
	@Autowired	
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository=deviceRepository;
	}
	
	public void create(Device readDevice) {
		deviceRepository.save(readDevice);		
	}

	public void remove(Long id) {
		Optional<Device> device=deviceRepository.findById(id);
		device.ifPresent(deviceRepository::delete);	
	}
	
	public Device read(Long id) {
		Optional<Device> device=deviceRepository.findById(id);
		return 	device.isPresent()?device.get():null;
	}

	public void update(Device deviceToRent) {
		if (deviceRepository.findById(deviceToRent.getId()).isPresent()) {
			System.out.println("Zapisuję urzadzenie");
			deviceRepository.save(deviceToRent);
		}
	}

	public Optional<List<Device>> search(String name) {
		return deviceRepository.findByNameContainingIgnoreCase(name);
		
		
	}



}
