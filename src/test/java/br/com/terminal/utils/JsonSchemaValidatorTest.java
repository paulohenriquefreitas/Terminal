package br.com.terminal.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import br.com.terminal.mock.TerminalMock;

@RunWith(MockitoJUnitRunner.class)
public class JsonSchemaValidatorTest {

	@Test
	public void test_parseJsonToTerminal_success() throws IOException, ProcessingException {
		assertTrue(new JsonSchemaValidator().getProcessingReport(TerminalMock.createTerminalJson()).isSuccess());
	}
	@Test
	public void test_parseJsonToTerminal_fail() throws IOException, ProcessingException {
		assertFalse(new JsonSchemaValidator().getProcessingReport(TerminalMock.createIncompleteTerminalJson()).isSuccess());
	}
}
