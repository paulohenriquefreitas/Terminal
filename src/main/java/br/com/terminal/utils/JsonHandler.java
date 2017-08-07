package br.com.terminal.utils;

import br.com.terminal.model.Terminal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class  JsonHandler {

	public static Terminal parseJsonToTerminal(String json) throws IOException{
		return new ObjectMapper().readValue(json, Terminal.class);
	}
	
	public static String parseTerminalToJson(Terminal terminal) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(terminal);
	}

}
