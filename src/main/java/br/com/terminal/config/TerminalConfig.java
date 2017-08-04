package br.com.terminal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.terminal.dao.TerminalDaoImpl;
import br.com.terminal.service.TerminalService;

@Configuration
public class TerminalConfig {
	

	@Bean
	public TerminalService terminalService() {
		return new TerminalService();
	}

	@Bean
	public TerminalDaoImpl terminalDaoImpl() {
		return new TerminalDaoImpl();
	}
	
}
