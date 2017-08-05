package br.com.terminal.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.terminal.model.Terminal;

public class TerminalConverter {
	
	public static Terminal getTerminalFromString(String request) {
		List<String> reqList = new ArrayList<>(Arrays.asList(request.split(";")));	
		
		return  Terminal.builder()
						.logic(Integer.valueOf(reqList.get(0)))
						.serial(reqList.get(1))
						.model(reqList.get(2))
						.sam(Integer.valueOf(reqList.get(3)))
						.ptid(reqList.get(4))
						.plat(Integer.valueOf(reqList.get(5)))
						.version(reqList.get(6))
						.mxr(Integer.valueOf(reqList.get(7)))
						.mxf(Integer.valueOf(reqList.get(8)))
						.VERFM(reqList.get(9))
						.build();
	}
}
