package modelo1;
/**
 *
 * @author joselin
 */
public class Producto {
    protected String clave;
    protected String nombre;
    protected String pre;
    protected String caducidad;
    protected String canti;
    boolean disponible;
    
    public Producto(String cad,String c,String n,String p,String cadu){
        canti=cad;
        clave=c;
        nombre=n;
        pre=p;
        caducidad=cadu;
        
        disponible=true;
     }
     public Producto(String cad,String c,String n,String p,String cadu,boolean di){
        canti=cad;
        clave=c;
        nombre=n;
        pre=p;
        caducidad=cadu;
        disponible=di;
     }

    public String getClave(){
        return clave;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCaducidad(){
        return caducidad;
    }
    public String getPrecio(){
        return pre;
    }
    public  String getCanti(){
        
        return canti;
    }

    public void setCantidad(String s){
        canti=s;
    }
     public boolean isDisponible(){
        return disponible;
    }
    public void setDisponible(boolean d){
        disponible = d;
    } 
            
    
}
