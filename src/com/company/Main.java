package com.company;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import static com.company.SafeInput.getYNConfirm;
import static com.company.SafeInput.getRegExString;
import static com.company.SafeInput.getRangedInt;
import static com.company.SafeInput.getNonZeroLengthString;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<String> myArrList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String controls = "A - add an item to the list \nD - delete an item from the list \nP - print the list \nQ - quit the program";
        boolean quit = false;
        System.out.println(controls);
        do
        {
            String response = getRegExString(in, "What do you wish to do? ", "[AaDdPpQq]");
            switch (response.toUpperCase(Locale.ROOT))
            {
                case "A":
                    add(myArrList);
                    break;
                case "D":
                    delete(myArrList);
                    break;
                case "P":
                    print(myArrList);
                    break;
                case "Q":
                     quit = quit();
                    break;
                default:
                    System.out.println("Invalid Input, Please enter: A, D, P, or Q");
                    break;
            }
        } while(!quit);
    }

    private static ArrayList<String> add(ArrayList<String> arrList)
    {
        Scanner in = new Scanner(System.in);
        arrList.add(getNonZeroLengthString(in, "Write what you want added to the list"));
        return arrList;
    }

    private static ArrayList<String> delete(ArrayList<String> arrList)
    {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < arrList.size(); i++)
        {
            System.out.println((i + 1) + ". " + arrList.get(i));
        }
        int itemNum = getRangedInt(in, "Which item would you like to delete? ",1 ,arrList.size() + 1) - 1;
        arrList.remove(itemNum);
        return arrList;
    }

    private static void print(ArrayList<String> arrList)
    {
        for (int i = 0; i < arrList.size(); i++)
        {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();
    }
    private static boolean quit()
    {
        Scanner in = new Scanner(System.in);
        if (getYNConfirm(in, "Are you sure you want to quit?"))
        {
            return true;
        }
        return false;
    }
}
