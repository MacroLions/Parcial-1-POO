/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricapasteles;

import java.util.Scanner;

public class FabricaPasteles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Que tipo de pastel quiere?");
        System.out.println("1. Cheesecake");
        System.out.println("2. Freezecake");
        System.out.println("3. Pastel de chocolate");
        System.out.println("4. Pastel de galleta");
        Scanner input = new Scanner(System.in);
        System.out.print("Opcion: ");
        int a = input.nextInt();
        Cake cake = RealFactory.getCake(a);
        cake.Hornearse();
        
    }
    
}
