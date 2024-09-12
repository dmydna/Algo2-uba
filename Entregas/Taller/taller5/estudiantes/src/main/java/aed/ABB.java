package aed;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        arrayList<Nodo> siguientes;
        T definicion;
        private Nodo() {
            definicion = null;
            siguientes = new arrayList<Nodo>();
        }
    }
    Nodo raiz;
    int tamanio;
      
    public ABB() {
        _raiz = new Nodo();
    }

    public int cardinal() {
        return _cardinal;
    }
    
    

    // definir  
    public void insertar(T elem) {
        Nodo actual = raiz; 
        int posicion;
        
        if(raiz == null){
          return false;
        }
        
         
        if (pertenece(elem)) {
            return;
        }
        Nodo nuevo = new Nodo();
        nuevo.valor = elem;

        if (_cardinal == 0) {
            _raiz = nuevo;
            _cardinal++;
            return;
        }

        Nodo nodo_padre =  _raiz;

        while (true) { // busca padre para elem nuevo y lo inserta

            if (elem.compareTo(nodo_padre.valor) < 0) {
                if (nodo_padre.izq == null) {
                    // encuentra padre
                    // inserta elem
                    nodo_padre.izq = nuevo;
                    nuevo.arriba = nodo_padre;
                    break;
                } else {
                    nodo_padre = nodo_padre.izq;
                }
            } else {
                if (nodo_padre.der == null) {
                    // encuentra padre
                    // inserta elem
                    nodo_padre.der = nuevo;
                    nuevo.arriba = nodo_padre;
                    break;
                } else {
                    nodo_padre = nodo_padre.der;
                }
            }
        }

        _cardinal ++ ;

    }
    

    // esta
    public boolean pertenece(T elem) {
        if (_cardinal == 0) {
            return false;
        }
        if (elem.compareTo(_raiz.valor) == 0) {
            return true;
        }
        Nodo actual = _raiz;
        while (actual != null) {
            if (elem.compareTo(actual.valor) == 0) {
                return true;
            } else {
                if (elem.compareTo(actual.valor) < 0) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }

        }

        return false;

    }





    public void eliminar(T elem) {
        if (_cardinal == 1) {
            _raiz = null;
            _cardinal--;
            return;
        }

        Nodo nodo_elem = _raiz;
        while (elem.compareTo(nodo_elem.valor) != 0) {
            if (elem.compareTo(nodo_elem.valor) < 0) {
                nodo_elem = nodo_elem.izq;
            } else {
                nodo_elem = nodo_elem.der;
            }
        }

        // si no tiene desendencia
        if (nodo_elem.der == null && nodo_elem.izq == null) {
            Nodo padre = nodo_elem.arriba;
            if (nodo_elem.valor.compareTo(padre.valor) < 0) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
            _cardinal--;
            return;
        }

        // si tiene dos descendientes
        if (nodo_elem.der != null && nodo_elem.izq != null) {

            Nodo minimo_der = nodo_elem.der;
            while (minimo_der.izq != null) {
                minimo_der = minimo_der.izq;
            }
            
            Nodo padre_elem = minimo_der.arriba;
            nodo_elem.valor = minimo_der.valor;

            if (minimo_der.valor.compareTo(padre_elem.valor) < 0) {
                padre_elem.izq = minimo_der.der;
            } else {
                padre_elem.der = minimo_der.der;
            }
            if (minimo_der.der != null) {
                minimo_der.der.arriba = padre_elem;
            }
            _cardinal--;
            return;
        }

        // Si tiene un descendiente

        boolean elemTieneHijoDerecho   = nodo_elem.der != null && nodo_elem.izq == null;
        boolean elemTieneHijoIzquierdo = nodo_elem.izq != null && nodo_elem.der == null;

        if(elemTieneHijoDerecho || elemTieneHijoIzquierdo){

            Nodo hijo = elemTieneHijoDerecho ? nodo_elem.der : nodo_elem.izq;

            // nodo_elem.valor = hijo.valor;
            // nodo_elem.der   = hijo.der;
            // nodo_elem.izq   = hijo.izq;
            
            //nodo_elem = hijo.copiar();
            nodo_elem.reemplazar(hijo);
            
            if (hijo.der != null) {
                hijo.der.arriba = nodo_elem;
            }
            if (hijo.izq != null) {
                hijo.izq.arriba = nodo_elem;
            }
            _cardinal--;
            return;
        }
    }

    private String _inorder(Nodo nodo){
        if(nodo == null) return "";
        boolean nodoEsMaximo = nodo.valor.compareTo ( maximo() ) == 0 ;
        
        String sepador =  nodoEsMaximo ? "" : ",";
        return _inorder(nodo.izq) + nodo.valor + sepador + _inorder(nodo.der);
    }
 
    public String toString(){
        if (_cardinal == 0) {
            return "{}";
        }
        return "{" + _inorder(_raiz) + "}";
    }


    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador() {

            Nodo minimo = null;
            if (_raiz != null) {
                minimo = _raiz;
                while (minimo.izq != null) {
                    minimo = minimo.izq;
                }
            }
            _actual = minimo;
        }

        public boolean haySiguiente() {
            return _actual.valor.compareTo(maximo())!=0;
        }

        public T siguiente() {
            T res = _actual.valor;
            if (haySiguiente()) {
                if (_actual.der != null) {

                    _actual = _actual.der;
                    while (_actual.izq != null) {
                        _actual = _actual.izq;
                    }
                } else {
                    Nodo ancestro = _actual.arriba;
                    while (ancestro != null && _actual.valor.compareTo(ancestro.valor) > 0) {
                        ancestro = ancestro.arriba;
                    }

                    if (_actual.valor.compareTo(ancestro.valor) < 0) {

                        _actual = ancestro;
                    }
                }
            }
            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}

