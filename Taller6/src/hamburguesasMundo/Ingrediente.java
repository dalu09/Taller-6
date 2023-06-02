package hamburguesasMundo;

public class Ingrediente {
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	private String nombre;
	private int costoAdicional;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public Ingrediente(String n, int costo) {
		nombre = n;
		costoAdicional = costo;
	}
	
	//Metodos
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
}
