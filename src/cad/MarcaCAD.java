package cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.MarcaBean;

public class MarcaCAD {

	public static ArrayList<MarcaBean> listarMarcas(){
		try {
			String sql = "{call sp_listarMarcas()}";
			Connection m = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)m.prepareCall(sql);
			ResultSet resultado= sentencia.executeQuery();
			ArrayList<MarcaBean> lista = new ArrayList<>();
			while (resultado.next()) {
				MarcaBean mar = new MarcaBean();
				mar.setCodigo(resultado.getInt("codigo"));
				mar.setNombre(resultado.getString("nombre"));
			    lista.add(mar);
			}
			return lista;
		} catch (SQLException e) {
			return null;
		}
	}
}
