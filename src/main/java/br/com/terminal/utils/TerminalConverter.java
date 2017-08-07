package br.com.terminal.utils;

import br.com.terminal.model.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminalConverter {

	
	public  Terminal getTerminalFromString(String request) {
		List<String> reqList = new ArrayList<>(Arrays.asList(request.split(";")));
		Terminal terminal = new Terminal();
		if(!reqList.get(0).isEmpty()) terminal.setLogic(Integer.valueOf(reqList.get(0)));
		if(!reqList.get(1).isEmpty()) terminal.setSerial(reqList.get(1));
		if(!reqList.get(2).isEmpty()) terminal.setModel(reqList.get(2));
		if(!reqList.get(3).isEmpty()) terminal.setSam(Integer.valueOf(reqList.get(3)));
		if(!reqList.get(4).isEmpty()) terminal.setPtid(reqList.get(4));
		if(!reqList.get(5).isEmpty()) terminal.setPlat(Integer.valueOf(reqList.get(5)));
		if(!reqList.get(6).isEmpty()) terminal.setVersion(reqList.get(6));
		if(!reqList.get(7).isEmpty()) terminal.setMxr(Integer.valueOf(reqList.get(7)));
		if(!reqList.get(8).isEmpty()) terminal.setMxf(Integer.valueOf(reqList.get(8)));
		if(!reqList.get(9).isEmpty()) terminal.setVERFM(reqList.get(9));

		
		return  terminal;
	}
}
