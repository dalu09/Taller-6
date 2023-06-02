package hamburguesasMundo;

import java.util.ArrayList;

public class Combo {
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();
	
	public Combo(double d, String n) {
		descuento = d;
		nombreCombo = n;
	} 
	
	public String getNombre() {
		return nombreCombo;
	}
	
	public boolean agregarItemACombo(ProductoMenu itemCombo) {
	    for(ProductoMenu item : itemsCombo) {
	      if(item.getNombre().equals(itemCombo.getNombre()))
	        return false;
	    }
	    this.itemsCombo.add(itemCombo);
	    return true;
	  }
	
	public int getPrecio() {
	    int precio = 0;
	    for(ProductoMenu producto : itemsCombo) {
	      precio += producto.getPrecio();
	    }
	    return (int) (precio-(precio*(descuento/100)));
	  }
	
	 public String generarTextoFactura() {
		    String formato = "";
		    for(ProductoMenu producto : itemsCombo) {
		      formato += producto.generarTextoFactura() + "\n";
		    }
		    return formato;
		  }
}
