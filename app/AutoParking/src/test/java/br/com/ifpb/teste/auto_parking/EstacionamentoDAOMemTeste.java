package br.com.ifpb.teste.auto_parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;

import br.com.ifpb.teste.auto_parking.dao.imp.EstacionamentoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public class EstacionamentoDAOMemTeste {

	private static ArrayList<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
	private EstacionamentoDAOMem estacionamentoDAO = null;
	
	@BeforeClass
	public static void criarEstacionamentos() {
		//listaEstacionamento.add(new Estacionamento(id, quitado, finalizado, placa, dhChegada, dhPagamento, dhSaida, valor));
		listaEstacionamento.add(new Estacionamento(1, true, true, "JJK-1373", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 5.5));
		listaEstacionamento.add(new Estacionamento(2, false, false, "JOE-8330", LocalDateTime.now().minusHours(1), null, null, null));
		listaEstacionamento.add(new Estacionamento(3, true, false, "EFH-9373", LocalDateTime.now().minusHours(2), LocalDateTime.now().minusMonths(1), LocalDateTime.now(), 5.5));
	}

}
