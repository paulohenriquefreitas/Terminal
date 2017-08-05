package br.com.terminal.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.terminal.dao.TerminalDao;
import br.com.terminal.model.Terminal;
import br.com.terminal.utils.JsonHandler;
@Service
public class TerminalService {
	
	@Autowired
	private TerminalDao terminalDao;	

	public Terminal save(String request) {
		Terminal terminal = getTerminalFromString(request);
		terminalDao.save(terminal);
		return terminal;
	}

	public Terminal getTerminalFromString(String request) {
		List<String> reqList = new ArrayList<>(Arrays.asList(request.split(";")));	
		
		return  Terminal.builder()
						.logic(Integer.valueOf(reqList.get(0)))
						.serial(reqList.get(1))
						.model(reqList.get(2))
						.sam(Integer.valueOf(reqList.get(3)))
						.ptid(reqList.get(4))
						.plat(Integer.valueOf(reqList.get(5)))
						.version(reqList.get(6))
						.mxr(Integer.valueOf(reqList.get(7)))
						.mxf(Integer.valueOf(reqList.get(8)))
						.VERFM(reqList.get(9))
						.build();
	}

	public List<Terminal> getAll() {
		return terminalDao.getAll();
	}

	public Terminal findById(Integer logicId) {
		return terminalDao.findById(logicId);
	}
	
	public String  update (String request, Integer logicId){
		terminalDao.update(JsonHandler.parseJsonToTerminal(request), logicId);
		return request;
	}

}
