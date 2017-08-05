package br.com.terminal.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.terminal.dao.TerminalDao;
import br.com.terminal.model.Terminal;
import br.com.terminal.utils.JsonHandler;
import br.com.terminal.utils.TerminalConverter;
@Service
public class TerminalService {
	
	@Autowired
	private TerminalDao terminalDao;	

	public Terminal save(String request) {
		Terminal terminal = TerminalConverter.getTerminalFromString(request);
		terminalDao.save(terminal);
		return terminal;
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
