package cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CategoriaBean;

public class CategoriaCAD {

	public static ArrayList<CategoriaBean> listar(){
		try {
			String sql = "{call sp_listarCategoriaSuperior()}";
			Connection c = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)c.prepareCall(sql);
			ResultSet resultado= sentencia.executeQuery();
			ArrayList<CategoriaBean> lista = new ArrayList<>();
			while (resultado.next()) {
				CategoriaBean cat = new CategoriaBean();
				cat.setCodigo(resultado.getInt("codigo"));//biene e la BD
				cat.setNombre(resultado.getString("nombre"));
				lista.add(cat);
			}
			return lista;
		} catch (SQLException e) {
			return null;
		}
	}

	public static ArrayList<CategoriaBean> listarSubCategorias(int iCodCatSuperior){
		try {
			String sql = "{call sp_listarSubCategoria(?)}";
			Connection c = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)c.prepareCall(sql);
			sentencia.setInt(1, iCodCatSuperior);
			ResultSet resultado= sentencia.executeQuery();
			ArrayList<CategoriaBean> lista = new ArrayList<>();
			while (resultado.next()) {
				CategoriaBean cat = new CategoriaBean();
				cat.setCodigo(resultado.getInt("codigo"));
				cat.setNombre(resultado.getString("nombre"));
				lista.add(cat);
			}
			return lista;
		} catch (SQLException e) {
			return null;
		}
	}

	public static Boolean bObtenerCatSuperior(int iCodCatSuperior){
		try {
			String sql = "{call sp_obtenerCantSubCategorias(?)}";
			Connection c = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)c.prepareCall(sql);
			sentencia.setInt(1, iCodCatSuperior);
			ResultSet resultado= sentencia.executeQuery();
			resultado.next();
			return resultado.getInt("cantidad")>0;
		} catch (SQLException e) {
			return false;
		}
	}

	public static ArrayList<CategoriaBean> listarCategorias(){
		try {
			String sql = "{call sp_listarCategorias()}";
			Connection c = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)c.prepareCall(sql);
			ResultSet resultado= sentencia.executeQuery();
			ArrayList<CategoriaBean> lista = new ArrayList<>();
			while (resultado.next()) {
				CategoriaBean cat = new CategoriaBean();
				cat.setCodigo(resultado.getInt("codigo"));
				cat.setNombre(resultado.getString("nombre"));
				lista.add(cat);
			}
			return lista;
		} catch (SQLException e) {
			return null;
		}
	}
}
