package org.fasttrackit.util.agenda;

import org.apache.xpath.SourceTree;
import org.fasttrackit.util.Calc;

/**
 * Created by dserdean on 15.12.2016.
 */
public class Agenda {
    public static void main(String[] args) {
        String[] agenda = new String[10];
        int option;
        int index = 0;
        do {
            System.out.println("1-Create");
            System.out.print("2-UpdateByName\n");
            System.out.print("2-UpdateByName\n");
            System.out.println("3-DeleteByName");
            System.out.println("4-SearchByName");
            System.out.println("5-printAll");
            System.out.println("9-Exit");
            System.out.println("Please choose a number: ");
            option = Calc.readIntFromConsole();

            if (option == 1) {
                System.out.println("give me a name:");
                String newName = Calc.readStringFromConsole();
                agenda[index] = newName;
                index++;
            }
            if (option == 2) {
                System.out.println("Give me an existing name:");
                String existingName = Calc.readStringFromConsole();
                int indexOfExistingName = 0;
                while (indexOfExistingName < index) {
                    if (existingName.equals(agenda[indexOfExistingName])) {
                        System.out.println("Find " + existingName + "give me a new name:");
                        String newName = Calc.readStringFromConsole();
                        agenda[indexOfExistingName] = newName;
                        break;
                    }
                    indexOfExistingName++;
                }
                if (indexOfExistingName == index) {
                    System.out.println("can't find " + existingName);
                }
            }
            if (option == 5) {
                for (int i = 0; i < index; i++) {
                    System.out.println(agenda[i]);
                }

            }
        }
            while (option != 9) ;

        }
    }
