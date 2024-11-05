package Exercises;

import java.util.Scanner;

public class Exercise13 {
    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        int[] candidatos = {0, 0, 0};

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter 1 for the first candidate, 2 or 3,Which is your vote:");
            int vote = scanner.nextInt();
            if (vote == 1) {
                candidatos[0] += 1;
            } else if (vote == 2) {
                candidatos[1] += 1;
            } else if (vote == 3) {
                candidatos[2] += 1;
            }
        }
        int aux = candidatos[0];
        int indice = 0;
        for (int i = 0; i < candidatos.length; i++) {
            if (candidatos[i] > aux) {
                System.out.println(candidatos[i]);
                aux = candidatos[i];
                indice = i;
            }
        }
        System.out.println("The results are: " + "1: " + candidatos[0] + " , 2: " + candidatos[1] + ", 3:" + candidatos[2]);
        System.out.println("The winner is: " + (indice + 1) + " with: " + aux);

    }
}
