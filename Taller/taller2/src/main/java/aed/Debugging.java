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

        if(xs.length == 1) return true;

        for (int i = 0; i < xs.length; i++) {
            if(i == xs.length -1){
                if(xs[i] >= xs[i-1]) res = true;
                else{res = false;}
                break;
            }

            if (xs[i] > xs [i+1]) {
                res = false;
                break;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i < xs.length; i++) {
            
            if (xs[i] > 0 && xs[i] > res) res = xs[i];
            else if(xs[i]< 0 && res!=0 && xs[i] > res){
                res = xs[i];
            }else if (xs[i]< 0 && res==0) {
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
