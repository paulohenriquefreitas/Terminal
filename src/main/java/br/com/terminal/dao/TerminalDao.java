package br.com.terminal.dao;

import java.util.List;

import br.com.terminal.model.Terminal;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface TerminalDao {

	String save(Terminal terminal) throws JsonProcessingException;
	List<Terminal> getAll();
	Terminal findById(int logicId);
	String update(Terminal terminal, int logicId) throws JsonProcessingException;

}
