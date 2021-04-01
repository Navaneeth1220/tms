package com.cg.tms.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.BusNotFoundException;
import com.cg.tms.exceptions.InvalidBusException;
import com.cg.tms.repository.IBusRepository;

@ExtendWith(MockitoExtension.class)
public class BusServiceUnitTest {
	@Mock
	IBusRepository repository;

	@Spy
	@InjectMocks
	BusServiceImpl service;

	/*
	 * Add Route: Success Scenario
	 */

	@Test
	public void testAddBus1() {
		String busType = "AC Sleeper";
		String busNumber = "B1";
		int capacity = 15;
		Bus bus = mock(Bus.class);
		bus.setBusType(busType);
		bus.setBusNumber(busNumber);
		bus.setCapacity(capacity);
		when(repository.save(bus)).thenReturn(bus);
		doNothing().when(service).validateBus(bus);
		Bus result = service.addBus(bus);
		Assertions.assertSame(result, bus);
		verify(repository).save(bus);
		verify(service).validateBus(bus);

	}

	/*
	 * Add Route: Failure Scenario
	 */

	@Test
	public void testAddBus2() {

		String busType = "";
		Bus bus = mock(Bus.class);
		when(bus.getBusType()).thenReturn(busType);
		doThrow(InvalidBusException.class).when(service).validateBusType(busType);
		Executable executable = () -> service.addBus(bus);
		Assertions.assertThrows(InvalidBusException.class, executable);
		verify(repository, never()).save(bus);
	}

	/*
	 * Search Route: Success Scenario
	 */
	@Test
	public void testSearchBus_1() {

		int busId = 1;
		Bus bus = mock(Bus.class);
		Optional<Bus> optional = Optional.of(bus);
		when(repository.findById(busId)).thenReturn(optional);
		Bus result = service.searchBus(busId);
		Assertions.assertSame(bus, result);
		verify(repository).findById(busId);
	}

	/*
	 * Search Route: Failure Scenario
	 */
	@Test
	public void testSearchBus_2() {

		int busId = 40;
		Optional<Bus> optional = Optional.empty();
		when(repository.findById(busId)).thenReturn(optional);
		Executable executable = () -> service.searchBus(busId);
		Assertions.assertThrows(BusNotFoundException.class, executable);
	}

	/*
	 * View Route List: Success Scenario
	 */
	@Test
	public void testViewBusList() {
		List<Bus> buses = mock(List.class);
		when(repository.findAll()).thenReturn(buses);
		List<Bus> result = service.viewBusList();
		Assertions.assertSame(buses, result);
		verify(repository).findAll();

	}
}
