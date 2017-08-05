package br.com.terminal.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.ALL_VALUE)	
	public ResponseEntity<?> save(@RequestBody String request) {	
		String requestJson = JsonHandler
				.parseTerminalToJson(TerminalConverter
						.getTerminalFromString(request));
		schemaValidation(requestJson);

		return new ResponseEntity<>(terminalService.save(request), HttpStatus.OK) ;		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Terminal>> getAll(){
		return new ResponseEntity<List<Terminal>>(terminalService.getAll(), HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/{logicId}",method=RequestMethod.GET)
	public ResponseEntity<Terminal> findById(@PathVariable Integer logicId){
		return new ResponseEntity<Terminal>(terminalService.findById(logicId), HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/{logicId}", method=RequestMethod.PUT, consumes = "application/json")	
	public ResponseEntity<String> update(@RequestBody String request, @PathVariable Integer logicId) {
		
		ResponseEntity<String> re = schemaValidation(request);
		if(re != null){
			return re;
		}
		terminalService.update(request,logicId);
		return new ResponseEntity<String>(request,HttpStatus.OK) ;		
	}	
	
	private ResponseEntity<String> schemaValidation(String requestJson) {
		try {
			ProcessingReport pr = new JsonSchemaValidator().getProcessingReport(requestJson);
			if(!pr.isSuccess()){ 
				return new ResponseEntity<>(JsonHandler.parseTerminalToJson(pr),HttpStatus.BAD_REQUEST);
            } 
		} catch (IOException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ProcessingException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

}
