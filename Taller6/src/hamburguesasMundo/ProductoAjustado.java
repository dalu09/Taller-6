package hamburguesasMundo;

import java.util.ArrayList;

public class ProductoAjustado {
	
	private ProductoMenu base;
	private int precioAjustado;
	private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
	private Ingrediente ingrediente;
	
	public ProductoAjustado(ProductoMenu b) {
		base = b;
	}
	
	public String getNombre() {
		return base.getNombre();
	}
	
	public boolean agregarIngrediente(Ingrediente ingrediente) {
	    for(Ingrediente ingredienteAgregado : agregados) {
	      if(ingredienteAgregado.getNombre().equals(ingrediente.getNombre()))
	        return false;
	    }
	    
	    this.agregados.add(ingrediente);
	    this.precioAjustado = this.precioAjustado + ingrediente.getCostoAdicional();
	    return true;
	  }

	public boolean eliminarIngrediente(Ingrediente ingrediente) {
	    for(Ingrediente ingredienteAgregado : eliminados) {
	      if(ingredienteAgregado.getNombre().equals(ingrediente.getNombre()))
	        return false;
	    }
	    this.precioAjustado -= ingrediente.getCostoAdicional();
	    this.eliminados.add(ingrediente);
	    return true;
	  }

	  public String generarTextoFactura() {
	    String factura = "";

	    for(int i = 0; i < this.agregados.size(); i++) {
	      for(int j = 0; j < this.eliminados.size(); j++) {
	        if(this.agregados.get(i).getNombre().equals(this.eliminados.get(j).getNombre())) {
	          this.agregados.remove(i);
	          this.eliminados.remove(j);
	        }
	      }
	    }

	    for(Ingrediente ingrediente : agregados) {
	      if(!eliminados.contains(ingrediente))
	        factura += ingrediente.getNombre() + " +$" + ingrediente.getCostoAdicional() + "\n";
	    }
	    return factura;
	  }
}
