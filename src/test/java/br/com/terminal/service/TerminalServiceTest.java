package br.com.terminal.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TerminalServiceTest {
	
	
    @SuppressWarnings("unused")
	private TerminalService terminalService;    
	
	@Before
	public void setUp() {
		terminalService = new TerminalService();		
	}
	
	/*TODO Pelo escopo do projeto não há necessidade de testar a classe TerminalService, pois a mesma
	não possui métodos funcionais que precisem ser testados.*/
		

}
