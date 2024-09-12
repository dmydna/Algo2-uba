package aed;

public class Horario {

    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
        return _hora + ":" + _minutos;
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen =  (otro == null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd) {
            return false;
        }

        Horario otroHorario = (Horario) otro;

        return _hora == otroHorario._hora 
            && _minutos == otroHorario._minutos;
    }

}
