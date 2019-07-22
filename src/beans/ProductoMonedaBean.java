package beans;

public class ProductoMonedaBean {
	private String sMoneda;
	private float dPrecio;
	private float dPrecioNuevo;
    private int iWebId;
    
	public ProductoMonedaBean() {
		
	}
	public ProductoMonedaBean(String sMoneda, float dPrecio, float dPrecioNuevo, int iWebId) {
		this.sMoneda = sMoneda;
		this.dPrecio = dPrecio;
		this.dPrecioNuevo = dPrecioNuevo;
		this.iWebId = iWebId;
	}
	public String getsMoneda() {
		return sMoneda;
	}
	public void setsMoneda(String sMoneda) {
		this.sMoneda = sMoneda;
	}
	public float getdPrecio() {
		return dPrecio;
	}
	public void setdPrecio(float dPrecio) {
		this.dPrecio = dPrecio;
	}
	public float getdPrecioNuevo() {
		return dPrecioNuevo;
	}
	public void setdPrecioNuevo(float dPrecioNuevo) {
		this.dPrecioNuevo = dPrecioNuevo;
	}
	public int getiWebId() {
		return iWebId;
	}
	public void setiWebId(int iWebId) {
		this.iWebId = iWebId;
	}
}
