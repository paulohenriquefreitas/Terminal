package br.com.terminal.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.terminal.model.Terminal;

@RunWith(MockitoJUnitRunner.class)
public class TerminalDaoTest {
	
	@Mock
	private TerminalDao terminalDao;
	
	@Test
	public void test_save_terminal_success() {
		terminalDao.save(createTermihalStub());
		//TODO assert save objcet
	}
	
	public Terminal createTermihalStub(){
		return  Terminal.builder()
						.logic(Integer.valueOf(10))
						.serial("123")
						.model("PWD")
						.sam(0)
						.ptid("FERHT")
						.plat(Integer.valueOf(4))
						.version("8.00b8")
						.mxr(Integer.valueOf(0))
						.mxf(Integer.valueOf(58468))
						.VERFM("PWD")
						.build();
	}

}
