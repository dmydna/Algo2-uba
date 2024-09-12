package aed;

class Debugging {
    boolean xor(boolean a, boolean b) {
        if (a == b) {
            return false;
        }else{
            return true;
        }
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        
        if (xs.length != ys.length) return false;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
                break;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 1; i < xs.length; i++) {
            if(xs[i] < xs[i-1]) {
                res = false;
                break;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        if (xs.length == 0) return  0;
        int res = xs[0];
        for (int i = 1; i < xs.length; i++) {
            if (xs[i] >= res) {
                res = xs[i];
            } 
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x <= 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
