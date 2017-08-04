package br.com.terminal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(value = "/{logic}", method=RequestMethod.POST, consumes = MediaType.ALL_VALUE)	
	public ResponseEntity<Terminal> post(@RequestBody String request) {		
		return new ResponseEntity<>(terminalService.save(request), HttpStatus.OK) ;		
	}

}
