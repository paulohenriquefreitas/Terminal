package br.com.terminal.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.common.base.Function;

public class JsonSchemaValidator {

	public static final String JSON_V4_SCHEMA_IDENTIFIER = "http://json-schema.org/draft-04/schema#";
	public static final String JSON_SCHEMA_IDENTIFIER_ELEMENT = "$schema";


	public ProcessingReport schemaValidation(String requestJson) throws IOException, ProcessingException  {
		return  new JsonSchemaValidator().getProcessingReport(requestJson);

	}

	public ProcessingReport getProcessingReport(String request) throws IOException, ProcessingException {
		File biosampleFile = ResourceUtils.getFile("src/main/resources/schema.json");
			return isJsonValid(getSchemaNode(biosampleFile), getJsonNode(request));
	}

	public static JsonNode getJsonNode(String jsonText) throws IOException {
		return JsonLoader.fromString(jsonText);
	}

	public Function<String, File> getCustomerFileReader = filename -> {
		ClassLoader cl = getClass().getClassLoader();
		File customer = new File(cl.getResource(filename).getFile());
		return customer;
	};


	public static ProcessingReport isJsonValid(JsonSchema jsonSchemaNode, JsonNode jsonNode)
			throws ProcessingException {
		ProcessingReport report = jsonSchemaNode.validate(jsonNode);
		return report;
	}

	public static JsonSchema getSchemaNode(File schemaFile) throws IOException, ProcessingException {
		final JsonNode schemaNode = getJsonNode(schemaFile);
		return _getSchemaNode(schemaNode);
	}

	public static JsonNode getJsonNode(File jsonFile) throws IOException {
		return JsonLoader.fromFile(jsonFile);
	}

	private static JsonSchema _getSchemaNode(JsonNode jsonNode) throws ProcessingException {
		final JsonNode schemaIdentifier = jsonNode.get(JSON_SCHEMA_IDENTIFIER_ELEMENT);
		if (null == schemaIdentifier) {
			((ObjectNode) jsonNode).put(JSON_SCHEMA_IDENTIFIER_ELEMENT, JSON_V4_SCHEMA_IDENTIFIER);
		}

		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		return factory.getJsonSchema(jsonNode);
	}
}
