package aed;

public class Fecha {

    private int _mes;
    private int _dia;

    public Fecha(int dia, int mes) {
        _dia = dia;
        _mes = mes;
    }

    public Fecha(Fecha fecha) {
        Fecha nueva = new Fecha(fecha._dia, fecha._mes);
        _dia = nueva._dia;
        _mes = nueva._mes;
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
        return _mes;
    }

    @Override
    public String toString() {
        return _dia + "/" + _mes;
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null);
        boolean cd = otra.getClass() != this.getClass();
        if (oen || cd) {
            return false;
        }
        Fecha otraFecha = (Fecha) otra;

        return _dia == otraFecha._dia
                && _mes == otraFecha._mes;
    }

    public void incrementarDia() {
        Fecha modificada = new Fecha(_dia, _mes);

        if (diasEnMes(_mes) == _dia) {
            modificada._dia = 1;
            if (_mes < 12) {
                modificada._mes = _mes + 1;
            } else {
                modificada._mes = 1;
            }
        } else {
            modificada._dia = _dia + 1;
        }

        _dia = modificada._dia;
        _mes = modificada._mes;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
