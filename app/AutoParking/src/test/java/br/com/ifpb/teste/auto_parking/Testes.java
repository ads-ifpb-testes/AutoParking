package br.com.ifpb.teste.auto_parking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ClienteDAOMemTeste.class,
	VeiculoDAOMemTeste.class,
	PrecoDAOMemTeste.class,
	EstacionamentoDAOMemTeste.class
})

public class Testes {

}
