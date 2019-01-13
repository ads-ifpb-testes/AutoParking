package br.com.ifpb.teste.auto_parking.factory;

import br.com.ifpb.teste.auto_parking.dao.imp.DAOFactoryMem;

public class DAOFactorry {
	public enum FactoryType{MEM, JDBC}
	public static DAOAbstractFactory createFactory(FactoryType type){
		switch (type) {
		case MEM:
			return new DAOFactoryMem();
		case JDBC:
			throw new UnsupportedOperationException("Não implementado ainda.");
		}			
		return null;
	}

}
