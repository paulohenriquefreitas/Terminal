package br.com.terminal.dao;

import java.util.List;

import br.com.terminal.model.Terminal;

public interface TerminalDao {

	void save(Terminal terminal);
	List<Terminal> getAll();
	Terminal findById(int logicId);
	void update(Terminal terminal, int logicId);

}
