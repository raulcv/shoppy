
<%@page import="cad.MarcaCAD"%>
<%@page import="beans.MarcaBean"%>
<%@page import="cad.CategoriaCAD"%>
<%@page import="beans.CategoriaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Gestion de Productos |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
    <%@include file="../../WEB-INF/css.jsp" %>
</head><!--/head-->

<body>
   <%@include file="../../WEB-INF/header.jsp" %>
        
        <section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
				</div>
				
				<div class="col-sm-10 clearfix">
					${mensaje}
						<h3>Gestionar Producto</h3>
						<form action="ControlProducto" enctype="multipart/form-data" method="post">
						<div class="form-one">
						
							Nombre:<br /> <input type="text" name="nombre"	placeholder="Nombre de Producto" value="">
							<hr />

							Precio(PEN):<br /> <input type="number" name="precioPen"	placeholder="Precio" value="0" min="0"> <br />
							Precio Promo(PEN):<br /> <input type="number" name="precioNuevoPen"	placeholder="Precio Promo" value="0" min="0">
							<hr />

							Precio(USD):<br /> <input type="number" name="precioUsd"	placeholder="Precio" value="0" min="0"> <br /> 
							Precio Promo(USD):<br /> <input type="number" name="precioNuevoUsd" placeholder="Precio Promo" value="0" min="0">
							<hr />

							Precio(COP):<br /> <input type="number" name="precioCop"  placeholder="Precio" value="0" min="0"> <br />
							Precio Promo(COP):<br /> <input type="number" name="precioNuevoCop" placeholder="Precio Promo" value="0" min="0">
							<hr />

							Precio(MXN):<br /> <input type="number" name="precioMxn"  placeholder="Precio" value="0" min="0"> <br /> 
							Precio Promo(MXN):<br /> <input type="number" name="precioNuevoMxn" placeholder="Precio Promo" value="0" min="0">
							<hr />

							Stock:<br /> <input type="number" name="cantidad" placeholder="Cantidad" value="1" min="1"> <br /> 	
							Marca:<br />
							<select name="marca">
								<option>Seleccionar Marca</option>
								<%
									for (MarcaBean m : MarcaCAD.listarMarcas()) {
								%>
								<option value="<%=m.getCodigo()%>"> <%=m.getNombre()%></option>
								<%
									}
								%>
							</select> <br /> 
							
							Categoría:<br /> 
							<select name="categoria">
								<option>Seleccionar Categoría</option>
								<%
									for (CategoriaBean c : CategoriaCAD.listarCategorias()) {
								%>
								<option value="<%=c.getCodigo()%>"><%=c.getNombre()%></option>
								<%
									}
								%>
							</select> <br /> 
														
							Descripción:<br />	
							<textarea name="descripcion" rows="4" cols="20"  placeholder="Descripción" required></textarea><br /> 
							
							Nuevo?:<input type="checkbox" name="nuevo" value="ON" checked="checked" /> 
							Recomendado?:<input type="checkbox"	name="recomendado" value="ON" /> 
							Visíble?:<input	type="checkbox" name="visible" value="ON" checked="checked" />
							<hr />
							
							Seleccionar Imagen del Producto:<input type="file" name="imagen"  value="Seleccionar una Imagen" required />
							<hr />
							<input class="btn btn-success" name="accion" type="submit" value="Registrar" />
							 <input class="btn btn-info" name="accion"	type="submit" value="Consultar" /> 
							 <input class="btn btn-warning" name="accion" type="submit" value="Actualizar" /> 
							 <input class="btn btn-danger" name="accion" type="submit" value="Borrar" />
							<hr />
						</div>
					</form>					
				</div>
			</div>
		</div>
	</section>
	
				   <%@include file="../../WEB-INF/footer.jsp" %>
 	<%@include file="../../WEB-INF/js.jsp" %>

</body>
</html>
