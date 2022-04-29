package com.company;
import java.util.Scanner;
public class SafeInput
{

    public static String getNonZeroLengthString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int number = 0;
        boolean incorrect = true;
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            pipe = new Scanner(System.in);
            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                incorrect = false;
            }
        } while (incorrect);
        return number;
    }


    public static double getDouble(Scanner pipe, String prompt)
    {
        double doubleNumber = 0;
        boolean incorrect = true;

        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            pipe = new Scanner(System.in);
            if (pipe.hasNextDouble())
            {
                doubleNumber = pipe.nextDouble();
                incorrect = false;
            }
        } while (incorrect);
        return doubleNumber;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int number = 0;
        boolean incorrect = true;
        do
        {
            System.out.print("\n" +prompt + " [" + low + "-" + high + "] "); // show prompt add space
            pipe = new Scanner(System.in);
            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                if (number >= low && number <= high)
                {
                    incorrect = false;
                }
            }
        }while (incorrect);
        return number;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double doubleNumber = 0;
        boolean incorrect = true;
        do
        {
            System.out.print("\n" +prompt + "[" + low + "-" + high + "] "); // show prompt add space
            pipe = new Scanner(System.in);
            if (pipe.hasNextDouble())
            {
                doubleNumber = pipe.nextDouble();
                if (doubleNumber >= low && doubleNumber <= high)
                {
                    incorrect = false;
                }
            }
        }while (incorrect);
        return doubleNumber;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String tryString = "";
        do
        {
            System.out.print("\n" +prompt + " [Y/N]: "); // show prompt add space
            tryString = pipe.nextLine();

            if (tryString.equalsIgnoreCase("y"))
            {
            return true;
            }
            else if (tryString.equalsIgnoreCase("N"))
            {
                return false;
            }

        }while (!(tryString.equalsIgnoreCase("y") || tryString.equalsIgnoreCase("N")));
        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean incorrect = true;
        String tryString = "";
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            tryString = pipe.nextLine();
            if (tryString.matches(regEx))
            {
                incorrect = false;
            }
            else
            {
                System.out.println("Invalid input: " + tryString); // error message
            }

        }while (incorrect);
        return tryString;
    }

    public static void prettyHeader(String msg)
    {
        int msgLength = msg.length();
        int spacing = ((52 - msgLength) / 2);

        // printing message
        if ((msgLength < 52))
        {
            //first line
            for (int i = 0; i <= 60; i++)
            {
                System.out.print("*");
            }
            // second line
            System.out.print("\n*** ");
            for (int i = 0; i <= spacing; i++)
            {
                System.out.print(" ");
            }
            System.out.print(msg);
            if (spacing % 2 == 0)
            {
                for (int i = 0; i <= spacing; i++)
                {
                    System.out.print(" ");
                }
            }
            else
            {
                for (int i = 0; i <= spacing - 1; i++)
                {
                    System.out.print(" ");
                }
            }
            System.out.print(" ***\n");
            // third line
            for (int i = 0; i <= 60; i++)
            {
                System.out.print("*");
            }
        }
        else
        {
            System.out.println("Your message was too long for the header!!!");
        }


    }

}

