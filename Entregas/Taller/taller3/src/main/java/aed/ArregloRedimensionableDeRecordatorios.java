package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio [] _recordatorios;
    
    public ArregloRedimensionableDeRecordatorios() { 
        _recordatorios = new Recordatorio [0];
        
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        vector = vector.copiar();
        _recordatorios = vector._recordatorios;
    }

    public int longitud() {
        return _recordatorios.length ;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] copiaRecordatorios = new Recordatorio [_recordatorios.length+1];

        int k = 0;            
        while (k <  _recordatorios.length) { 
            copiaRecordatorios[k] = _recordatorios[k];
            
            k++;       
        }
        copiaRecordatorios[k] = i;
        _recordatorios = copiaRecordatorios;  
    }


    public Recordatorio obtener(int i) {
        return _recordatorios[i];
    }

    public void quitarAtras() {
        
        int longitud = 0;

        if (_recordatorios.length > 0){
            longitud =_recordatorios.length-1;
        }

        Recordatorio[] _copiaRecordatorios = new Recordatorio [longitud];

        int k = 0;
        while (k < _recordatorios.length-1) {
            _copiaRecordatorios[k] = _recordatorios[k];
            k=k+1;
        }
         _recordatorios = _copiaRecordatorios;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
         this._recordatorios[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {;
        ArregloRedimensionableDeRecordatorios devuelveCopia = new ArregloRedimensionableDeRecordatorios();        
        int k=0;
        if (_recordatorios.length != 0){
            while (k < _recordatorios.length) {
                Recordatorio copiaRecordatorio =  new Recordatorio(this.obtener(k).mensaje(),
                                                                   this.obtener(k).fecha(),
                                                                   this.obtener(k).horario());
                devuelveCopia.agregarAtras(copiaRecordatorio);
                k++;
            } 
        }
        return devuelveCopia;
    }

}
