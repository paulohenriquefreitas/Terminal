package br.com.terminal.controller;

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

import br.com.terminal.model.Terminal;
import br.com.terminal.service.TerminalService;


@RestController
@RequestMapping("v1/terminal")
public class TerminalController {
	
	@Autowired
	private TerminalService terminalService;	

	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.ALL_VALUE)	
	public ResponseEntity<Terminal> save(@RequestBody String request) {		
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
		terminalService.update(request,logicId);
		return new ResponseEntity<String>(request,HttpStatus.OK) ;		
	}
	

}
