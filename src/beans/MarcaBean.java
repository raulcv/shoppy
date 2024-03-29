package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MarcaBean implements Serializable{

	private int codigo;
	private String nombre;
	private boolean visible;
	
	public MarcaBean() {

	}
	public MarcaBean(int codigo, String nombre, boolean visible) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.visible = visible;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}	
}
