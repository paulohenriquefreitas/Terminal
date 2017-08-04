package br.com.terminal.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.terminal.model.Terminal;

@RunWith(MockitoJUnitRunner.class)
public class TerminalServiceTest {
	
	private static final String REQUEST = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
    private TerminalService terminalService;    
	
	@Before
	public void setUp() {
		terminalService = new TerminalService();		
	}
	
	@Test
	public void test_get_Terminal_from_string(){
		Terminal terminal = terminalService.getTerminalFromString(REQUEST);
		assertEquals(44332211,terminal.getLogic());
		assertEquals("123",terminal.getSerial());
		assertEquals("PWWIN",terminal.getModel());
		assertEquals(0,terminal.getSam());
		assertEquals("F04A2E4088B",terminal.getPtid());
		assertEquals(4,terminal.getPlat());
		assertEquals("8.00b3",terminal.getVersion());
		assertEquals(0,terminal.getMxr());
		assertEquals(16777216,terminal.getMxf());
		assertEquals("PWWIN",terminal.getVERFM());
		
	}

}
