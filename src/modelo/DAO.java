package src.modelo;

import java.sql.Connection;
import java.sql.*;
import java.util.*;


public abstract class DAO<CLASS> {

	protected Conexion con = new Conexion();
	protected CLASS classNormal;
	protected PreparedStatement ps; 
	protected ResultSet rs;
	protected Connection bd;  

    // listar
	public abstract ArrayList<CLASS> list();

	// agregar
    // add documentation of method
    // retorna el stado, si fue correcto 1, si no 0
	public abstract int add(CLASS clase);

    // modificar
    // retorna el stado, si fue correcto 1, si no 0
	public abstract int modify(CLASS clase);

}


