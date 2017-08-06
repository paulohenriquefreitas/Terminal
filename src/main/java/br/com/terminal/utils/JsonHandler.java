package br.com.terminal.utils;

import br.com.terminal.model.Terminal;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;

import java.io.IOException;

public class  JsonHandler {

	public static Terminal parseJsonToTerminal(String json) throws IOException{
		return new ObjectMapper().readValue(json, Terminal.class);
	}
	
	public static String parseTerminalToJson(Terminal terminal) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(terminal);
	}

}
