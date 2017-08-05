package br.com.terminal.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.terminal.mock.TerminalMock;

@RunWith(MockitoJUnitRunner.class)
public class JsonHandlerTest {
	
	@Test
	public void test_parseJsonToTerminal_success(){
		assertTrue(TerminalMock.createTerminalStub().equals(JsonHandler.parseJsonToTerminal(TerminalMock.createTerminalJson())));
	}
	
	@Test
	public void test_parseTerminalJson_success(){
		assertTrue(TerminalMock.createTerminalJson().equals(JsonHandler.parseTerminalToJson(TerminalMock.createTerminalStub())));
	}
}
