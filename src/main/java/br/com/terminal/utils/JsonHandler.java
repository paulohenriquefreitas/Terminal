package br.com.terminal.utils;

import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.google.gson.Gson;

import br.com.terminal.model.Terminal;

public class  JsonHandler {
	
	public static Terminal parseJsonToTerminal(String json){
		return new Gson().fromJson(json, Terminal.class);
	}
	
	public static String parseTerminalToJson(Terminal terminal){
		return new Gson().toJson(terminal);
	}
	
	public static String parseTerminalToJson(ProcessingReport pr){
		return new Gson().toJson(pr);
	}

}
