package aed;

public class Agenda {

    private Fecha _fechaActual;
    private ArregloRedimensionableDeRecordatorios _Recordatorios;

    public Agenda(Fecha fechaActual) {
        _fechaActual = new Fecha(fechaActual.dia(), fechaActual.mes());
        _Recordatorios = new ArregloRedimensionableDeRecordatorios();

    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this._Recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {

        String agendaDia = "";
        agendaDia +=_fechaActual + "\n=====\n";
        int i = 0;
        while (i < _Recordatorios.longitud()) {
            Fecha fechaRecordario = new Fecha(_Recordatorios.obtener(i).fecha().dia(),
                    _Recordatorios.obtener(i).fecha().mes());

            String mensajeRecordatorio = _Recordatorios.obtener(i).mensaje();
            Horario horarioRecordatorio = new Horario(_Recordatorios.obtener(i).horario().hora(),
                    _Recordatorios.obtener(i).horario().minutos());

            if (fechaRecordario.equals(_fechaActual)) {
                agendaDia +=  mensajeRecordatorio + " @ "
                        + _fechaActual + " " + horarioRecordatorio + "\n";
            }
            i = i + 1;
        }

        return agendaDia;

    }

    public void incrementarDia() {
        _fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return _fechaActual;
    }

}
