package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Bus;
import com.cg.tms.exceptions.BusNotFoundException;
import com.cg.tms.exceptions.InvalidBusException;
import com.cg.tms.repository.IBusRepository;

@Service
public class BusServiceImpl implements IBusService {
	@Autowired
	private IBusRepository busRepository;

	@Transactional
	@Override
	public Bus addBus(Bus bus) {
		validateBus(bus);
		Bus saved = busRepository.save(bus);
		return saved;

	}

	@Transactional
	@Override
	public Bus searchBus(Integer busId) throws BusNotFoundException {
		Optional<Bus> optional = busRepository.findById(busId);
		if (!optional.isPresent()) {

			throw new BusNotFoundException("Bus not found for Bus Id= " + busId);
		}
		return optional.get();
	}

	@Transactional
	@Override
	public List<Bus> viewBusList() {
		List<Bus> busList = busRepository.findAll();
		return busList;
	}

	public void validateBus(Bus bus) {
		validateBusType(bus.getBusType());
		validateBusNumber(bus.getBusNumber());
		validateCapacity(bus.getCapacity());
	}

	public void validateBusType(String busType) {
		if (busType == null || busType.isEmpty() || busType.trim().isEmpty()) {

			throw new InvalidBusException("Bus Type can't be null or empty");
		}
	}

	public void validateBusNumber(String busNumber) {
		if (busNumber == null || busNumber.isEmpty() || busNumber.trim().isEmpty()) {

			throw new InvalidBusException("Bus Number can't be null or empty");
		}
	}

	public void validateCapacity(int capacity) {
		if (capacity < 0) {
			throw new InvalidBusException("Capacity can't be negative");
		}
	}

}
