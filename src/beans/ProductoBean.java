package beans;

public class ProductoBean {
	private int iWebId; 
	private String sNombre;
	private float dPrecio;
	private float dPrecioNuevo;
	private int iStock;
	private boolean bNuevo;
	private boolean bRecomendado;
	private String tDescripcion;
	private boolean bVisible;
	private int iCodigoMarca;
	private int iCodigoCategoria;
	private String sImg;

	public ProductoBean() {
		
	}

	public int getiWebId() {
		return iWebId;
	}

	public void setiWebId(int iWebId) {
		this.iWebId = iWebId;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
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

	public int getiStock() {
		return iStock;
	}

	public void setiStock(int iStock) {
		this.iStock = iStock;
	}

	public boolean isbNuevo() {
		return bNuevo;
	}

	public void setbNuevo(boolean bNuevo) {
		this.bNuevo = bNuevo;
	}

	public boolean isbRecomendado() {
		return bRecomendado;
	}

	public void setbRecomendado(boolean bRecomendado) {
		this.bRecomendado = bRecomendado;
	}

	public String gettDescripcion() {
		return tDescripcion;
	}

	public void settDescripcion(String tDescripcion) {
		this.tDescripcion = tDescripcion;
	}

	public boolean isbVisible() {
		return bVisible;
	}

	public void setbVisible(boolean bVisible) {
		this.bVisible = bVisible;
	}

	public int getiCodigoMarca() {
		return iCodigoMarca;
	}

	public void setiCodigoMarca(int iCodigoMarca) {
		this.iCodigoMarca = iCodigoMarca;
	}

	public int getiCodigoCategoria() {
		return iCodigoCategoria;
	}

	public void setiCodigoCategoria(int iCodigoCategoria) {
		this.iCodigoCategoria = iCodigoCategoria;
	}

	public String getsImg() {
		return sImg;
	}

	public void setsImg(String sImg) {
		this.sImg = sImg;
	}

	
}
