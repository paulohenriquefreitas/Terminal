package br.com.terminal.service;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.terminal.dao.TerminalDao;
import br.com.terminal.model.Terminal;
import br.com.terminal.utils.JsonHandler;
import br.com.terminal.utils.TerminalConverter;
@Service
public class TerminalService {
	
	@Autowired
	private TerminalDao terminalDao;	

	public String save(Terminal terminal) throws JsonProcessingException {
		return terminalDao.save(terminal);
	}

	public List<Terminal> getAll() {
		return terminalDao.getAll();
	}

	public Terminal findById(Integer logicId) {
		return terminalDao.findById(logicId);
	}
	
	public String  update (String request, Integer logicId) throws IOException{
		terminalDao.update(JsonHandler.parseJsonToTerminal(request), logicId);
		return request;
	}

}
