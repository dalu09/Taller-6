package hamburguesasMundo;

	import hamburguesasMundo.Combo;
	import hamburguesasMundo.Ingrediente;
	import hamburguesasMundo.Pedido;
	import hamburguesasMundo.Producto;
	import hamburguesasMundo.ProductoAjustado;
	import hamburguesasMundo.ProductoMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
	  private ArrayList<Combo> combos = new ArrayList<Combo>();
	  private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	  private Pedido pedidoEnCurso;
	  private ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
	  private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	  private ArrayList<ProductoMenu> bebidas = new ArrayList<ProductoMenu>();
	  
	  public Restaurante () throws FileNotFoundException {
		    File archivoIngredientes = new File("./data/ingredientes.txt");
		    File archivoMenu = new File("./data/menu.txt");
		    File archivoCombos = new File("./data/combos.txt");
		    
		    try {
				cargarIngredientes(archivoIngredientes);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IngredienteRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				cargarMenu(archivoMenu);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProductoRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    cargarCombos(archivoCombos);
		  }
	  
	  public Pedido getPedidoEnCurso() {
		  return pedidoEnCurso;
	  }
	  
	  public void iniciarPedido(int numeroPedido, int id, String nombreCliente, String direccionCliente) {
		    this.pedidoEnCurso = new Pedido(numeroPedido, id, nombreCliente, direccionCliente);
		    this.pedidos.add(pedidoEnCurso);
		  }
	  
	  public void cerrarYGuardarPedido() {
		    File archivoAGuardar = new File("./out/pedido" + pedidoEnCurso.getidPedido()+".txt");
		    pedidoEnCurso.guardarFactura(archivoAGuardar);
		    pedidos.add(pedidoEnCurso);
		    pedidoEnCurso = null;
		  }
	  
	  public Pedido getPedidoPorID(int id) {
		    for(Pedido pedido : pedidos) {
		      if(pedido.getidPedido() == id) return pedido;
		    }
		    return null;
		  }
	  
	  public String generarStringMenuBase() {
		    String resultado = "";
		    for(int i = 0; i < this.menuBase.size(); i++) {
		      resultado += (i+1) + ") " + this.menuBase.get(i).getNombre() + "\n";
		    }
		    return resultado;
		  }
	  
	  public String generarStringBebidas() {
		    String resultado = "";
		    for(int i = 0; i < this.bebidas.size(); i++) {
		      resultado += (i+1) + ") " + this.bebidas.get(i).getNombre() + "\n";
		    }
		    return resultado;
		  }
	  
	  public String generarStringCombos() {
		    String resultado = "";
		    for(int i = 0; i < this.combos.size(); i++) {
		      resultado += (i+1) + ") " + this.combos.get(i).getNombre() + "\n";
		    }
		    return resultado;
		  }
	  
	  public ProductoMenu buscarProductoMenu(int indice) {
		    return this.menuBase.get(indice - 1);
	  }
	  
	  public Combo buscarCombo(int indice) {
		    return this.combos.get(indice - 1);
		  }
	  
	  private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IngredienteRepetidoException  {
		    try (Scanner file = new Scanner(archivoIngredientes)) {
		      while(file.hasNextLine()) {
		        String[] data = file.nextLine().split(";");
		        Ingrediente ingrediente = new Ingrediente(data[0], Integer.parseInt(data[1]));
		      }
		    }
		  }
	  
	  private void cargarMenu(File archivoMenu) throws FileNotFoundException, ProductoRepetidoException {
		   try ( Scanner file = new Scanner(archivoMenu)){
		      while(file.hasNextLine()) {
		        String[] data = file.nextLine().split(";");
		        ProductoMenu producto = new ProductoMenu(data[0], Integer.parseInt(data[1]));
		      }
		   }
	  }
	  
	  private void cargarCombos(File archivoCombos) throws FileNotFoundException {
		    Scanner file = new Scanner(archivoCombos);
		    while(file.hasNextLine()) {
		      String[] data = file.nextLine().split(";");
		      Combo combo = new Combo(Integer.parseInt(data[1].replace("%", "")), data[0]);
		      this.combos.add(combo);
		    }
		    file.close();
	  }
}
