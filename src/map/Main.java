package map;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        int[] usb = {5,10};
        int[] tst = {50};
        int budget = 60;
        System.out.println(max_combo(tst,usb,budget));
    }


    public static int billigste(int[] tst){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<tst.length; i++){
            if(tst[i] < min) min=tst[i];
        }
        return min;
    }

    /**
     *
     * @param tast array mit Preise(int)
     * @param usb array mit Preise (int)
     */

    public static int teuerste(int[] tast, int[] usb){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<tast.length; i++){
            if(tast[i] > max) max=tast[i];
        }
        for(int i=0; i<usb.length; i++){
            if(usb[i] > max) max=usb[i];
        }
        return max;
    }


    public static int mx_budget(int[] usb, int budget){
        int max = Integer.MIN_VALUE;
        int change = 0;
        for(int i=0; i<usb.length; i++){
            if(usb[i] > max && usb[i] <= budget) {
                max=usb[i];
                change = 1;
            }
        }
        if (change == 0) return -1;
        return max;
    }

    /**
     * @param budget Buget
     * @return die maximale Sume <= Buget
     */

    public static int max_combo(int[] tast, int[] usb, int budget){
        int sum_max = 0;
        int s = 0;
        for(int i=0; i<tast.length && sum_max != budget; i++) {
            for(int j=0; j<usb.length && sum_max != budget; j++) {
                s = tast[i] + usb[j];
                if(abs(budget-s) < abs(budget-sum_max) && s <= budget){
                    sum_max = s;
                }
            }
        }
        if(sum_max == 0) return -1;
        return sum_max;
    }

}
