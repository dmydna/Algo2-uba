package aed;

public class Recordatorio {

    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {

        _mensaje = mensaje;
        _fecha = new Fecha(fecha);
        _horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        Fecha newFecha = new Fecha(this._fecha);       
        return newFecha;
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
        return _mensaje + " @ " + _fecha + " " + _horario;
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen =  (otro == null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd) {
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return  _mensaje.equals(otroRecordatorio.mensaje())
            && _fecha.equals(otroRecordatorio.fecha()) 
            && _horario.equals(otroRecordatorio.horario()) ;
    }

}
