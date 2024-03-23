package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt( x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        boolean res = n % 2 == 0;
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = n % 4 == 0 && n % 100 !=0 || n % 400 == 0;
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i=1; i <= n; i++ ){
            res = res * i;
        }
        return res;
    }



    int factorialRecursivo(int n) {
        if (n==0)return 1;
        return n * factorialRecursivo(n-1);
    }

    boolean esPrimo(int n) { 
        int cantDeDivisores = 0;

        if (n==1){
            return false;
        }

        for (int i=1; i<=n;i++){
            if (n % i == 0){
                cantDeDivisores += 1;
            }
        }
        return cantDeDivisores == 2;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i=0; i < numeros.length; i++){
            res = res  + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for(int i=0; i < numeros.length; i++){
           if (numeros[i]==buscado){
            res = i;
           }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i=0; i < numeros.length;i++){
            if(esPrimo(numeros[i])){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;

        for(int i=0; i< numeros.length;i++){
            if(!esPar(numeros[i])){
                res = false;
                break;
            }
        }
        return res;
    }

    boolean esPrefijo(String prefijo , String palabra) {

        if (prefijo.length() > palabra.length()) return false;

        for(int i=0; i < prefijo.length(); i++){
            if( prefijo.charAt(i) != palabra.charAt(i) ) return false;
        }

        return true;
    }

    boolean esSufijo(String sufijo, String palabra) {

        int s = sufijo.length();
        int p = palabra.length();

        if(sufijo.length() > palabra.length()) return false;

        for(int i=0 ;  i < sufijo.length() ; i++){
            if (sufijo.charAt(s-1) != palabra.charAt(p-1)){
                return false;
            }
            s--; p--;
        }
        return true; 
    }
}
