package br.com.terminal.utils;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.terminal.mock.TerminalMock;

@RunWith(MockitoJUnitRunner.class)
public class JsonHandlerTest {
	
	@Test
	public void test_parseJsonToTerminal_success() throws JsonParseException, JsonMappingException, IOException{
		assertTrue(TerminalMock.createTerminalStub().equals(JsonHandler.parseJsonToTerminal(TerminalMock.createTerminalJson())));
	}
	
	@Test
	public void test_parseTerminalJson_success() throws JsonProcessingException{
		assertTrue(TerminalMock.createTerminalJson().equals(JsonHandler.parseTerminalToJson(TerminalMock.createTerminalStub())));
	}
}
