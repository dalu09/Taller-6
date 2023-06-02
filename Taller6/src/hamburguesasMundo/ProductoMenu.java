package hamburguesasMundo;

public class ProductoMenu {
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String n, int pb){
		nombre = n;
		precioBase= pb;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precioBase;
	}
	
	public String generarTextoFactura() {
		return nombre + " " + precioBase;
	}
	
}
