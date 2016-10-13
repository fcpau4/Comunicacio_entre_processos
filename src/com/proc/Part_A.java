package com.proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Part_A {

    public static void main(String[] args) throws IOException {
	// write your code here


        String str = "";
        String nom = "";
        Scanner in = new Scanner(System.in);
        Process p = Runtime.getRuntime().exec("python dado.py");

        //Llegeixo el contingut del que ha resultat de l'execució de l'executable de Python.
        BufferedReader stdinput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        //Per aquí llegirem els errors que pugui contenir.
        BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));


        do{

            if((str=stdinput.readLine())!=null) {
                System.out.printf("Introdueix un nom: ");
                nom = in.nextLine();
                System.out.println(nom);
                System.out.println(str);
            }

        }while((str=stdinput.readLine())!=null);


        while((str=stderr.readLine())!= null){
            System.out.println("\t\t" + str);
        }

        stdinput.close();

        System.exit(0);

    }
}
