package com.cg.tms.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.repository.ITravelsRespository;


@ExtendWith(MockitoExtension.class)
class TravelServiceImplUnitTest {

    @Mock
    ITravelsRespository repository;

    @Spy
    @InjectMocks
    TravelServiceImpl service;

    /**
     * scenario : travels created
     */
    @Test
    public void testAddTravels_1() {
        String name="nir";
        Travels travels = mock(Travels.class);
        Travels saved = mock(Travels.class);
        when(travels.getTravelsName()).thenReturn(name);
        doNothing().when(service).validateTravelsName(name);
        when(repository.save(travels)).thenReturn(saved);
        Travels result = service.addTravels(travels);
        assertSame(saved, result);
        verify(repository).save(travels);
        verify(service).validateTravelsName(name);
    }

	//travels found
    
    @Test
	void testFind_1() {
		int id=1;
		Travels travels = mock(Travels.class);
		Optional<Travels> optional = Optional.of(travels);
		when(repository.findById(id)).thenReturn(optional);
		Travels result = service.searchTravels(travels.getTravelsId());
		Assertions.assertSame(travels,result);
		verify(repository).findById(id);
	}


	

	
    /**
	 * Scenario Booking is not found
	 
	@Test
	void testFind_2() {
		int id=5;		
		Optional<Travels> optional = Optional.empty();
		when(repository.findById(id)).thenReturn(optional);
		Executable executable =()->service.searchTravels(id);
		Assertions.assertThrows(TravelsNotFoundException.class,executable);
		
	} */

	/**
	 * Viewing all travels
	 */

	@Test
	void testViewTravels() {
		List<Travels> travels = mock(List.class);
		when(repository.findAll()).thenReturn(travels);
		List<Travels> result = service.viewTravels();
		Assertions.assertEquals(travels, result);
		verify(repository).findAll();
	}
	
	/**
	 *  id not found for deleting
	 
	@Test
	void deleteTravelTest_3() {
		int id=1;
		Optional<Travels> optional = Optional.empty();
		when(repository.findById(id)).thenReturn(optional);
		Executable executable = () -> service.viewTravels(id);
		Assertions.assertThrows(TravelsNotFoundException.class, executable);
	}
	*/
	


}