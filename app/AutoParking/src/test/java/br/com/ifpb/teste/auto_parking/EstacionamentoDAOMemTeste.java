package br.com.ifpb.teste.auto_parking;

import java.util.ArrayList;

import org.junit.BeforeClass;

import br.com.ifpb.teste.auto_parking.dao.imp.EstacionamentoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public class EstacionamentoDAOMemTeste {

	private static ArrayList<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
	private EstacionamentoDAOMem estacionamentoDAO = null;
	
	@BeforeClass
	public static void criarEstacionamentos() {		
	}

}
