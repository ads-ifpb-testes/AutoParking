package br.com.ifpb.teste.autoparking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ClienteDAOTeste.class,
	VeiculoDAOTeste.class,
	PrecoDAOTeste.class,
	EstacionamentoDAOTeste.class,
	PagamentoDAOTeste.class
})

public class Testes {

}
