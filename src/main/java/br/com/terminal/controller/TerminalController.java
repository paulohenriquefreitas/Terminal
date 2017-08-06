package br.com.terminal.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

import com.github.fge.jsonschema.core.report.ProcessingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;

import br.com.terminal.model.Terminal;
import br.com.terminal.service.TerminalService;
import br.com.terminal.utils.JsonHandler;
import br.com.terminal.utils.JsonSchemaValidator;
import br.com.terminal.utils.TerminalConverter;


@RestController
@RequestMapping("v1/terminal")
public class TerminalController {
	
	@Autowired
	private TerminalService terminalService;
		
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody String request) {	
		try {
            Terminal terminalFromString = TerminalConverter
                    .getTerminalFromString(request);
            String requestJson = JsonHandler
					.parseTerminalToJson(terminalFromString);
			ProcessingReport  pr = new JsonSchemaValidator().schemaValidation(requestJson);
            StringBuilder sb = new StringBuilder();
            for (ProcessingMessage processingMessage : pr) {
                sb.append(processingMessage);
            }
            if(pr.isSuccess()){
                return new ResponseEntity<String>(terminalService.save(terminalFromString),HttpStatus.OK) ;
            }else {
                return new ResponseEntity<String>(sb.toString(),HttpStatus.OK) ;
            }
        } catch (IOException e) {
            return new ResponseEntity<String>(e.toString(),HttpStatus.OK) ;
        } catch (ProcessingException e) {
            return new ResponseEntity<String>(e.toString(),HttpStatus.OK) ;
        }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Terminal>> getAll() throws FileNotFoundException{		
		return new ResponseEntity<List<Terminal>>(terminalService.getAll(), HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/{logicId}",method=RequestMethod.GET)
	public ResponseEntity<Terminal> findById(@PathVariable Integer logicId){
		return new ResponseEntity<Terminal>(terminalService.findById(logicId), HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/{logicId}", method=RequestMethod.PUT, consumes = "application/json")	
	public ResponseEntity<?> update(@RequestBody String request, @PathVariable Integer logicId) {

		try {
			ProcessingReport  pr = new JsonSchemaValidator().schemaValidation(request);
			StringBuilder sb = new StringBuilder();
            for (ProcessingMessage processingMessage : pr) {
              sb.append(processingMessage);
            }
			if(pr.isSuccess()){
                return new ResponseEntity<String>(terminalService.update(request,logicId),HttpStatus.OK) ;
            }else {
                return new ResponseEntity<String>(sb.toString(),HttpStatus.OK) ;
            }
		} catch (IOException e) {
            return new ResponseEntity<String>(e.toString(),HttpStatus.OK) ;
		} catch (ProcessingException e) {
            return new ResponseEntity<String>(e.toString(),HttpStatus.OK) ;
		}
	}


}
