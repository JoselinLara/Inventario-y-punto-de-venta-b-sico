package modelo1;
import java.io.*;

import java.util.*;

/**
 *
 * @author joselin
 */
public class Tienda {
    static List<Producto> productos = new ArrayList<>(); 

    public static void alimentaInventario (Producto p){
        productos.add(p);
        
    } 
     public static void mostrarInventario( ){
        ListIterator<Producto> it;
       Producto myProduct;
        System.out.println();
        for(it = productos.listIterator();it.hasNext();){
           myProduct= it.next();
            System.out.println("Cantidad"+myProduct.getCanti()+",Clave: "+myProduct.getClave()+
                    ", Nombre: "+myProduct.getNombre()+", Precio: "+
                    myProduct.getPrecio()+ ", Caducidad: "+
                    myProduct.getCaducidad());
        }
    }
      public static Producto buscarP(String clar){
        Producto pro_found = null;      
        for (Producto myProduct : productos) {
            String cla=myProduct.getClave();
            if (cla.equals(clar)) 
                pro_found = myProduct;
        }
        return pro_found;
    }
      public static float  ventaProducto(Producto p, int cantidad){     
         float totalVentaCliente=0;
         float subTotalProducto=0;
	 
         String tm=p.getPrecio();
         float pr;
         
         pr=Float.parseFloat(tm);
         subTotalProducto= (cantidad* pr);
         
         ventaTotal(totalVentaCliente);
        
         return totalVentaCliente;
         
      }
      public  static float ventaTotal(float vent){
          vent+=vent;
          return vent;
      }
      public static  boolean  guardarProducto() {
        try{
            BufferedWriter w;
            w= new BufferedWriter(new FileWriter("Inventario.dat"));
            ListIterator<Producto> it;      

            for (it = productos.listIterator();it.hasNext();){
                Producto myProduct =  it.next();
                myProduct.setDisponible(true);
                String ctmp=myProduct.getCanti();//cantidad
                String  clav=  myProduct.getClave();//clave
                String nom =  myProduct.getNombre();//nombre
                String tempo =  myProduct.getPrecio();//precio
                String cadu =  myProduct.getCaducidad();//caducidad
                Boolean disp0 = myProduct.isDisponible();//dispoonible

                if((!disp0)&&(ctmp!=null)){
                    w.write(ctmp+"~~"+clav+"~~"+nom+"~~"+tempo+"~~"+cadu+"~~"+disp0+"~~"+ "\n");
                } 
                else{
                    myProduct.setDisponible(true);
                    disp0 = myProduct.isDisponible();
                    w.write(ctmp+"~~"+clav+"~~"+nom+"~~"+tempo+"~~"+cadu+"~~"+disp0+"~~"+ "\n");
                }
            }
            w.close();
            return true;           
        }
        catch(IOException ex){
            return false;
        }
        
    }
    public static boolean cargarInventario(){
        try{
            BufferedReader r = new BufferedReader(new FileReader("Inventario.dat"));
            String registro;
            Producto prod;
            while((registro = r.readLine())!= null){
                
                String campos[] = registro.split("~~");
                String ctmp = campos[0];//cantidad
                String clv = campos[1];//clave
                String nam= campos[2];//nombre
                String tmp = campos[3];//precio
                String cadu = campos[4];//caducidad
                String disp = campos[5];//disponible
                boolean d = Boolean.getBoolean(disp);
                
                if(disp.equals("false")){
                    prod = new Producto(ctmp,clv,nam,tmp,cadu,d);
                     
                }else{
                    prod =new Producto(ctmp,clv,nam,tmp,cadu);
                }
                productos.add(prod);
                
            }
            r.close();
            return true;
        }catch(IOException exc){
         return false;
        }
    }
}