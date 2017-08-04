package br.com.terminal.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
	
	private int logic;
	private String serial;
	private String model;
	private int sam;
	private String ptid;
	private int plat;
	private String version;
	private int mxr;
	private int mxf;
	private String VERFM;	

}
