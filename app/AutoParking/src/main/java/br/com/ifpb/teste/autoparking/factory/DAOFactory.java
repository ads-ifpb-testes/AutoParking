package br.com.ifpb.teste.autoparking.factory;

import br.com.ifpb.teste.autoparking.dao.imp.DAOFactoryMem;

public class DAOFactory {
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
