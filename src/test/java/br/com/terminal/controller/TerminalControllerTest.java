package br.com.terminal.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import java.util.Arrays;

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
	public void test_save_success() throws Exception {
		Terminal expectedTerminal = mock(Terminal.class);
		when(terminalService.save(REQUEST)).thenReturn(expectedTerminal);
		assertEquals(expectedTerminal, terminalController.save(REQUEST).getBody());
		assertEquals(OK, terminalController.save(REQUEST).getStatusCode());
	}
	
	@Test (expected=RuntimeException.class)
	public void test_error_when_save() throws Exception {
		when(terminalService.save(REQUEST)).thenThrow(new RuntimeException());
		terminalController.save(REQUEST);
		
	}
	
	@Test
	public void test_getAll_success() throws Exception {
		Terminal expectedTerminal = mock(Terminal.class);
		when(terminalService.getAll()).thenReturn(Arrays.asList(expectedTerminal));
		assertEquals(1, terminalService.getAll().size());
	}
	
	@Test
	public void test_getAll_fail() throws Exception {
		when(terminalService.getAll()).thenReturn(Arrays.asList());
		assertEquals(0, terminalService.getAll().size());
	}
	
	@Test
	public void test_findById_success() throws Exception {
		Terminal expectedTerminal = mock(Terminal.class);
		when(terminalService.findById(10)).thenReturn(expectedTerminal);
		assertEquals(expectedTerminal, terminalService.findById(10));
	}
	
	@Test
	public void test_findById_fail() throws Exception {
		Terminal expectedTerminal = mock(Terminal.class);
		when(terminalService.findById(11)).thenReturn(expectedTerminal);
		assertNotEquals(expectedTerminal, terminalService.findById(10));
	}
	
	@Test
	public void test_update_success() throws Exception {
		String json = "{'logic':10}";
		assertNotEquals(OK, terminalService.update(json, 10));
	}
}


