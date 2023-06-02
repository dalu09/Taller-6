package hamburguesasMundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	public Pedido(int numP, int id, String n, String d) {
		numeroPedidos = numP;
		idPedido = id;
		nombreCliente = n;
		direccionCliente = d;
	}
	
	public int getidPedido() {
		return idPedido;
	}
	
	public boolean Pedido(Producto nuevoItem) throws PedidoException {	
		for(Producto producto : itemsPedido) {
		      if(producto.getNombre().equals(nuevoItem.getNombre())) {
		        return false;
		      }
		}
	    if(getPrecioTotalPedido() + Producto.getPrecio() > 150000) {
	      throw new PedidoException();
	    }
	    this.itemsPedido.add(nuevoItem);
	    return true;
		}
	private int getPrecioTotalPedido() {
		for (int i = 0; i < itemsPedido.size(); i++) {
			int precioI = Producto.getPrecio();
		}
		return 0;
	}
	

	public boolean guardarFactura(File archivo) {
	    try {
	      FileWriter file = new FileWriter(archivo);
	      file.write(generarTextoFactura());
	      file.close();
	      return true;
	    } catch (IOException e) {
	      System.err.println("ERROR: no se ha podido crear la factura!");
	    }
	    return false;
	  }

	private String generarTextoFactura() {
		String textoFactura = "";
	    textoFactura += "PEDIDO No. (" + idPedido + ")\n";
	    textoFactura += "###################\n";
		for(Producto producto : itemsPedido) {
	      textoFactura += producto.generarTextoFactura() + "\n";
	    }
		return textoFactura;
	}	
}
