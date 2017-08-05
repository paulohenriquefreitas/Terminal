package br.com.terminal.mock;

import br.com.terminal.model.Terminal;

public class TerminalMock {
	
	String body;

	public static Terminal createTerminalStub() {

		return Terminal.builder().logic(Integer.valueOf(10)).serial("123").model("PWD").sam(0).ptid("FERHT")
				.plat(Integer.valueOf(4)).version("8.00b8").mxr(Integer.valueOf(0)).mxf(Integer.valueOf(58468))
				.VERFM("PWD").build();
	}

	public static String createTerminalJson() {

		String json = "{\"logic\":10," + "\"serial\":\"123\"," + "\"model\":\"PWD\","
				+ "\"sam\":0," + "\"ptid\":\"FERHT\"," + "\"plat\":4," + "\"version\":\"8.00b8\","
				+ "\"mxr\":0," + "\"mxf\":58468," + "\"VERFM\":\"PWD\"}";

		return json;
	}
	
	public static String createIncompleteTerminalJson() {

		String json = "{\"serial\":\"123\"," + "\"model\":\"PWD\","
				+ "\"sam\":0," + "\"ptid\":\"FERHT\"," + "\"plat\":4," + "\"version\":\"8.00b8\","
				+ "\"mxr\":0," + "\"mxf\":58468," + "\"VERFM\":\"PWD\"}";

		return json;
	}

}
