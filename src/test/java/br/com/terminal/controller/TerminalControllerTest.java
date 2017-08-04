package br.com.terminal.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.terminal.model.Terminal;
import br.com.terminal.service.TerminalService;

@RunWith(MockitoJUnitRunner.class)
public class TerminalControllerTest {
	
	private static final String REQUEST = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";

	@InjectMocks
	private TerminalController terminalController;
	
	@Mock
	private TerminalService terminalService;
	
	@Test
	public void test_success() throws Exception {
		Terminal expectedTerminal = mock(Terminal.class);
		when(terminalService.save(REQUEST)).thenReturn(expectedTerminal);
		assertEquals(expectedTerminal, terminalController.post(REQUEST).getBody());
		assertEquals(OK, terminalController.post(REQUEST).getStatusCode());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_save() throws Exception {
		when(terminalService.save(REQUEST)).thenThrow(new RuntimeException());
		terminalController.post(REQUEST);
		
	}
}


