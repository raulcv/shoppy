package beans;

import java.io.Serializable;

public class CategoriaBean implements Serializable{

	private int codigo;
	private String nombre;
	private boolean visible;
	private int categoriaSuperior;
	
	public CategoriaBean() {	
	}

	public CategoriaBean(int codigo, String nombre, boolean visible, int categoriaSuperior) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.visible = visible;
		this.categoriaSuperior = categoriaSuperior;
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

	public int getCategoriaSuperior() {
		return categoriaSuperior;
	}

	public void setCategoriaSuperior(int categoriaSuperior) {
		this.categoriaSuperior = categoriaSuperior;
	}
}
