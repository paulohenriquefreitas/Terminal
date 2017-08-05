package br.com.terminal.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.terminal.mock.TerminalMock;
import br.com.terminal.model.Terminal;

@RunWith(MockitoJUnitRunner.class)
public class TerminalDaoTest {
	
	
	private TerminalDao terminalDao;
	
	@Before
	public void setUp() {
		terminalDao = new TerminalDaoImpl();	
	}
	
	
	@Test
	public void test_save_terminal_success() {
		terminalDao.save(TerminalMock.createTerminalStub());
		assertEquals(terminalDao.findById(10),TerminalMock.createTerminalStub());
	}
	
	@Test
	public void test_save_terminal_not_find() {
		terminalDao.save(TerminalMock.createTerminalStub());
		assertNotEquals(terminalDao.findById(11),TerminalMock.createTerminalStub());
	}
	
	@Test
	public void test_getAll_success() {
		terminalDao.save(TerminalMock.createTerminalStub());
		assertEquals(1,terminalDao.getAll().size());
	}
	
	@Test
	public void test_getAll_fail() {
		terminalDao.save(TerminalMock.createTerminalStub());
		assertNotEquals(2,terminalDao.getAll().size());
	}
	
	@Test
	public void test_update_success() {
		Terminal terminal = TerminalMock.createTerminalStub();
		terminalDao.save(terminal);
		terminal.setVERFM("UPDATEDVALUE");
		terminalDao.update(terminal, 10);
		assertEquals(1,terminalDao.getAll().size());
		assertEquals("UPDATEDVALUE",terminalDao.findById(10).getVERFM());
	}
	
}
