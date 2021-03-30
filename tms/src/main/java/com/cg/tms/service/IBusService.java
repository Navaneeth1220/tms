package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Bus;
import com.cg.tms.exceptions.BusNotFoundException;

public interface IBusService {
	public Bus addBus(Bus bus);

	public Bus searchBus(Integer busId) throws BusNotFoundException;

	public List<Bus> viewBusList();

}
