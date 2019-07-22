package control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.ProductoBean;
import beans.ProductoMonedaBean;
import cad.ProductoCAD;

@WebServlet("/ControlProducto")
public class ControlProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		recibirDatos(request);
		String url = request.getAttribute("imagen").toString();
		
		String nombre = request.getAttribute("nombre").toString();
		Float precioPen = Float.parseFloat(request.getAttribute("precioPen").toString());//Peru
		Float precioNuevoPen = Float.parseFloat(request.getAttribute("precioNuevoPen").toString());
		Float precioUsd = Float.parseFloat(request.getAttribute("precioUsd").toString());//EE.UU
		Float precioNuevoUsd = Float.parseFloat(request.getAttribute("precioNuevoUsd").toString());
		Float precioCop = Float.parseFloat(request.getAttribute("precioCop").toString());//Colombia
		Float precioNuevoCop = Float.parseFloat(request.getAttribute("precioNuevoCop").toString());
		Float precioMxn = Float.parseFloat(request.getAttribute("precioMxn").toString());//Mexico
		Float precioNuevoMxn = Float.parseFloat(request.getAttribute("precioNuevoMxn").toString());	
		
		int cantidad = Integer.parseInt(request.getAttribute("cantidad").toString());
		int marca = Integer.parseInt(request.getAttribute("marca").toString());
		int categoria = Integer.parseInt(request.getAttribute("categoria").toString());
		String descripcion = request.getAttribute("descripcion").toString();
		
		boolean nuevo,recomendado,visible;
		try {
				nuevo=request.getAttribute("nuevo").toString().equalsIgnoreCase("on");
		} catch (Exception e) {
			nuevo=false;
		}
	
		try {
			recomendado = request.getAttribute("recomendado").toString().equalsIgnoreCase("on");
		} catch (Exception e) {
			recomendado=false;
		}
		try {
			visible = request.getAttribute("visible").toString().equalsIgnoreCase("on");
		} catch (Exception e) {
			visible=false;
		}
		
		String accion = request.getAttribute("accion").toString();
		
		ProductoBean p = new ProductoBean();
		p.setsNombre(nombre);
		p.setdPrecio(precioPen);
		p.setdPrecioNuevo(precioNuevoPen);
		p.setiStock(cantidad);
		p.setiCodigoMarca(marca);
		p.setiCodigoCategoria(categoria);
		p.settDescripcion(descripcion);
		p.setsImg(url);
		p.setbNuevo(nuevo);
		p.setbRecomendado(recomendado);
		p.setbVisible(visible);
		
		
		ProductoMonedaBean usd = new ProductoMonedaBean();
		usd.setsMoneda("USD");
		usd.setdPrecio(precioUsd);
		usd.setdPrecioNuevo(precioNuevoUsd);
		
		ProductoMonedaBean cop = new ProductoMonedaBean();
		cop.setsMoneda("COP");
		cop.setdPrecio(precioCop);
		cop.setdPrecioNuevo(precioNuevoCop);
		
		ProductoMonedaBean mxn = new ProductoMonedaBean();
		mxn.setsMoneda("MXN");
		mxn.setdPrecio(precioMxn);
		mxn.setdPrecioNuevo(precioNuevoMxn);
		
		if(accion.equalsIgnoreCase("registrar")){
			if(ProductoCAD.registrarProducto(p, usd, cop, mxn)){
				request.setAttribute("mensaje", "<p style='color:green'>Producto Registrado</p>");
			}else{
				request.setAttribute("mensaje", "<p style='color:red'>Producto No Registrado</p>");				
			}
		}else{
			request.setAttribute("mensaje", "<p style='color:red'>Accion Desconocido</p>");	
		}
		request.getRequestDispatcher("admin").forward(request, response);
		//response.sendRedirect("admin");
		//response.sendRedirect("foto/"+url);
	}
	
	private void recibirDatos(HttpServletRequest request){
		try {
			FileItemFactory fileFactory = new DiskFileItemFactory();
		
			ServletFileUpload servletUpload = new ServletFileUpload(fileFactory);
		
			String nombre="";
			List<FileItem> items = servletUpload.parseRequest(request);
			
			for(int i = 0; i<items.size(); i++){
				FileItem item = (FileItem) items.get(i);
				if(!item.isFormField()){
					String ruta = request.getServletContext().getRealPath("/")+"foto/";
					SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
					String fecha = sdf.format(new Date());
					nombre = fecha+new Random().nextLong()+item.getName();
					String nuevoNombre = ruta+nombre; 	
					File folder = new File(ruta);
					if(!folder.exists()){
						folder.mkdirs();
					}
					File imagen = new File(nuevoNombre);
					if(item.getContentType().contains("image")){
						item.write(imagen);
						request.setAttribute(item.getFieldName(), nombre);
					}
				}else{
					request.setAttribute(item.getFieldName(), item.getString());
				}
			}
		} catch (FileUploadException ex) {
			request.setAttribute("subida", false);
		} catch (Exception ex) {
			request.setAttribute("subida", false);
		} 
	}

}
