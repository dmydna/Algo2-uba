package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;
    
    private class Nodo {
        T valor;
        Nodo sig;
        Nodo prev;

        public Nodo(T v){
            valor = v;
        } 
    }

    public ListaEnlazada() {
        primero = null;
        longitud = 0;
        ultimo = primero;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.sig;       
        }
        ultimo = actual;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo actual;   
          
        nuevo.sig = primero;
        primero = nuevo;
        if(primero==null) {
           ultimo = primero;
        }else{
           actual = primero;
           while (actual != null){
              ultimo = actual;
              actual = actual.sig
           }
        }  
        longitud++;
    }

    public void agregarAtras(T elem) {

        Nodo nuevo = new Nodo(elem);
        
        if (primero == null){
            primero = nuevo;
        }else{
            Nodo actual = primero;
            while (actual.sig != null){
                actual = actual.sig;
            }
            actual.sig = nuevo;
            nuevo.prev = actual;
        }
        ultimo = nuevo;
        longitud++;
    }

    public T obtener(int i) {
        Nodo actual = primero;
        Nodo previo = actual.prev;

        for(int j = 0; j < i; j++){
            previo = actual;
            actual = actual.sig;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo previo = actual.prev;

        for(int j = 0; j < i; j++){
            previo = actual;
            actual = actual.sig;
        }
        if(i==0){
            primero = actual.sig;
            ultimo = primero;
        }else{
            previo.sig = actual.sig;
            ultimo = actual;
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        Nodo previo = actual.prev;

        for(int j = 0; j < indice; j++){
            previo = actual;
            actual = actual.sig;
        }
        if(indice==0){
            primero.valor = elem;
            ultimo = primero;
        }else{
            actual.valor = elem;
            // Busco Ultimo.
            while (actual.sig != null){
               actual = actual.sig
            } 
            ultimo = actual;
        }
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> listaEnlazadaCopia = new ListaEnlazada<T>();

        int i = 0;
        while (i< this.longitud()){
            Nodo NodoCopia = new Nodo(this.obtener(i)); 
            listaEnlazadaCopia.agregarAtras(NodoCopia.valor);
            i++;
        }

        return listaEnlazadaCopia;

        

    }

    
    @Override
    public String toString() {
        int i=0;
        String str = "[";
        while (i < this.longitud()) {
            if (i != this.longitud()-1){
                str += this.obtener(i) + ", ";   
            }else{
                str += this.obtener(i) ;
            }
            i++;
        };
        str += "]";
        return str;
    }

    private class ListaIterador implements Iterador<T> {
        
        private Nodo iterador;

        public ListaIterador(){
            iterador = primero;
        }

        public boolean haySiguiente() {
            if(longitud() == 0){
                return false;
            }


            if(iterador ==  ultimo){
                return true;
            }
            return iterador != ultimo.sig;
            
        }
        
        public boolean hayAnterior() {

            if(longitud() == 0){
                return false;
            }
            if(iterador == ultimo){
                return true;
            }
            if(iterador != null){
                return iterador.prev != null;
            }
            return true;

        }

        public T siguiente() {
            T res = iterador.valor;
            if(this.haySiguiente()){
                iterador = iterador.sig;
            }
            return res;
        }
        

        public T anterior() {
            T res;
            if(iterador == null){
                iterador = ultimo; 
                res = ultimo.valor; 
            }else{
                res = iterador.prev.valor;
                iterador = iterador.prev;  
            }
            return res;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
