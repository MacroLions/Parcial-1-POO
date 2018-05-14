/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricapasteles;

public class RealFactory {

    public static Cake getCake(int opcion) {
        switch (opcion) {

            case 1:
                Cake cake = new Cheesecake();
                return cake;

            case 2:
                Cake cake2 = new FreezeCake();
                return cake2;

            case 3:
                Cake cake3 = new PastelChocolate();
                return cake3;

            case 4:
                Cake cake4 = new GalletaPastel();
                return cake4;
        }
        return null;
    }
}
