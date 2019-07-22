package cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import beans.ProductoBean;
import beans.ProductoMonedaBean;

public class ProductoCAD {

	public static boolean registrarProducto(ProductoBean p, ProductoMonedaBean usd, ProductoMonedaBean cop, ProductoMonedaBean mxn){
		try {
			String sql = "{call sp_registrarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			Connection c = Conexion.conectar();
			CallableStatement sentencia = (CallableStatement)c.prepareCall(sql);
			sentencia.setString(1, p.getsNombre());
			sentencia.setFloat(2, p.getdPrecio());
			sentencia.setFloat(3, p.getdPrecioNuevo());
			sentencia.setInt(4, p.getiStock());
			sentencia.setBoolean(5, p.isbNuevo());
			sentencia.setBoolean(6, p.isbRecomendado());
			sentencia.setString(7, p.gettDescripcion());
			sentencia.setBoolean(8, p.isbVisible());
			sentencia.setInt(9, p.getiCodigoMarca());
			sentencia.setInt(10, p.getiCodigoCategoria());
			sentencia.setString(11, p.getsImg());
			
			sentencia.setString(12, usd.getsMoneda());
			sentencia.setFloat(13, usd.getdPrecio());
			sentencia.setFloat(14, usd.getdPrecioNuevo());
			
			sentencia.setString(15, cop.getsMoneda());
			sentencia.setFloat(16, cop.getdPrecio());
			sentencia.setFloat(17, cop.getdPrecioNuevo());
			
			sentencia.setString(18, mxn.getsMoneda());
			sentencia.setFloat(19, mxn.getdPrecio());
			sentencia.setFloat(20, mxn.getdPrecioNuevo());
			return sentencia.executeUpdate()>0;
		} catch (SQLException e) {
			return false;
		}
	}
}
