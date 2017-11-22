import com.sun.corba.se.spi.orb.Operation;
import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class ConverterWithoutGUI {

    public static void ConverterWithoutGUI(String[] args)
    {
        //Variable Declaration
        long binary1=0, binary2=0;
        int selection =0;
        String option;
        String optionChanged;
        String InputInteger="";

        Scanner in = new Scanner(System.in);

        //Ask for to what type of calculation is required
        System.out.print("Select the Calculation to be Performed");

        //Show to the User the options available for the conversion required
        do {
            System.out.println("\n");
            System.out.println("1: Add Two Binary numbers");
            System.out.println("2: Multiple Two Binary numbers");
            System.out.println("3: Convert a decimal number to binary number");
            System.out.println("4: Convert a decimal number to hexadecimal number");
            System.out.println("5: Convert a decimal number to octal number");
            System.out.println("6: Convert a binary number to decimal number");
            System.out.println("7: Convert a binary number to hexadecimal number");
            System.out.println("8: Convert a binary number to Octal number");
            System.out.println("9: Convert a Octal Number to a Decimal Number");
            System.out.println("10: Convert an Octal Number to a Binary Number");
            System.out.println("11: Convert an Octal number to a Hexadecimal Number");
            System.out.println("12: Convert a Hexadecimal number to a Decimal Number");
            System.out.println("13: Convert a Hexadecimal to a Binary Number");
            System.out.println("14: Convert a Hexadecimal to an Octal Number");
            System.out.println("Write Exit to finish");

            //Get the option from user
            option = in.next();
            //Convert the String input to Lowercase -------WE NEED TO ADD ERASE SPACES JUST IN CASE
            optionChanged = option.toLowerCase();

            //Compare the input to check if it is any of the options required
            if(option.equals("1")||option.equals("2")||option.equals("3")||option.equals("4")||option.equals("5")
                    ||option.equals("6")||option.equals("7")||option.equals("8")||option.equals("9") ||option.equals("10")
                    ||option.equals("11")||option.equals("12")||option.equals("13")||option.equals("14"))
            {
                //Convert String input to Integer
                selection = Integer.parseInt(option);
            }
            if(selection == 0 && !optionChanged.equals("exit"))//Strings are compared as objects if "==" are used.
                // To compare values de .equals class needs to be used
            {
                System.out.print("The Selection entered is not valid. Enter a number from the " +
                        "list or type Exit to quit");
            }
        //Allow the user to insert the option as many times as required or select exit to finish the program
        } while(selection == 0 && !optionChanged.equals("exit"));

        //If Any of the Selections will required binary numbers run this
        if (selection==1||selection==2||selection==6||selection==7||selection==8)
        {
            //Sent Message to user stating the option selected
            switch (selection)
            {
                case 1:System.out.print("Add Two Binary Numbers");
                    System.out.println("\n");
                break;
                case 2:System.out.print("Multiply Two Binary Numbers");
                    System.out.println("\n");
                break;
                case 6:System.out.print("Convert a Binary Number to a Decimal Number");
                    System.out.println("\n");
                break;
                case 7:System.out.print("Convert a Binary Number to a Hexadecimal Number");
                    System.out.println("\n");
                break;
                case 8:System.out.print("Convert a Binary Number to an Octal Number");
                    System.out.println("\n");
                break;
                default: break;
            }
            //Ask User for Binary Numbers according to the option selected
            if(selection==1||selection==2) {
                System.out.println("Insert the First Binary Number");
                binary1 = in.nextLong();
                System.out.println("Insert the Second Binary Number");
                binary2 = in.nextLong();
            }
            else if(selection==6||selection==7||selection==8)
            {
                System.out.println("Insert the Binary Number to be Converted");
                binary1 = in.nextLong();
                binary2 = 01;
            }

            //Convert Binary Numbers to Array
            //First the binary numbers need to be converted to a String
            String StringBinary1 = Long.toString(binary1);
            String StringBinary2 = Long.toString(binary2);

            //This class matches the numbers with any 0 or 1s
            boolean b1Bool = StringBinary1.matches("[01]+");
            boolean b2Bool = StringBinary2.matches("[01]+");

            //Check if the numbers inserted are valid
            while(!b1Bool || !b2Bool)
            {
                if(!b1Bool && b2Bool)
                {
                    System.out.println("The number "+binary1+" is not a binary number");
                    System.out.println("Please try again");
                    System.out.println("Insert the First Binary Number: ");
                    binary1 = in.nextLong();
                }
                else if(!b2Bool && b1Bool)
                {
                    System.out.println("The number "+binary2+" is not a binary number");
                    System.out.println("Please try again");
                    System.out.println("Insert the Second Binary Number: ");
                    binary2 = in.nextLong();
                }
                else if(!b1Bool && !b2Bool)
                {
                    System.out.println("The numbers entered are not binary");
                    System.out.println("Please try again");
                    System.out.println("Insert the First Binary Number: ");
                    binary1 = in.nextLong();
                    System.out.println("Insert the Second Binary Number: ");
                    binary2 = in.nextLong();
                }
                //Update the Strings with the new data Entered
                StringBinary1 = Long.toString(binary1);
                StringBinary2 = Long.toString(binary2);
                //Update the booleans according to the data entered
                b1Bool = StringBinary1.matches("[01]+");
                b2Bool = StringBinary2.matches("[01]+");
            }
            //Execute the function that contains the calculations
            String ResultBinary = AddOrMultiplyBinaries(binary1, binary2, selection);

            if(selection==1) {
                //Show the result obtained based on the selection performed
                System.out.println(binary1+" + "+binary2+" = "+ResultBinary);
            }
            else if(selection==2) {
                //Show the result obtained based on the selection performed
                System.out.println(binary1+" * "+binary2+" = "+ResultBinary);
            }
            else if(selection==6) {
                //Show the result obtained based on the selection performed
                System.out.println("The binary number "+binary1+" converted to decimal is "+ResultBinary);
            }
            else if(selection==7) {
                //Show the result obtained based on the selection performed
                System.out.println("The binary number "+binary1+" converted to hexadecimal is "+ResultBinary);
            }
            else if(selection==8) {
                //Show the result obtained based on the selection performed
                System.out.println("The binary number "+binary1+" converted to octal is "+ResultBinary);
            }
        }
        else if(selection==3||selection==4||selection==5||selection==9||selection==10||
                selection==11|| selection==12||selection==13||selection==14)
        {
            //Sent Message to user stating the option selected
            switch (selection) {
                case 3:
                    System.out.print("Convert a Decimal Number to Binary number");
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.print("Convert a Decimal Number to Hexadecimal number");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.print("Convert a Decimal Number to an Octal Number");
                    System.out.println("\n");
                    break;
                case 9:
                    System.out.print("Convert an Octal Number to a Decimal Number");
                    System.out.println("\n");
                    break;
                case 10:
                    System.out.print("Convert an Octal Number to a Binary Number");
                    System.out.println("\n");
                    break;
                case 11:
                    System.out.print("Convert an Octal Number to a Hexadecimal Number");
                    System.out.println("\n");
                    break;
                case 12:
                    System.out.print("Convert a Hexadecimal Number to a Decimal Number");
                    System.out.println("\n");
                    break;
                case 13:
                    System.out.println("Convert a Hexadecimal to a Binary Number");
                    System.out.println("\n");
                    break;
                case 14:
                    System.out.println("Convert a Hexadecimal to an Octal Number");
                    System.out.println("\n");
                    break;
                default:
                    break;
            }
            //Ask User for numbers according to the selected option -- All numbers are saved in String that is converted afterwards
            //Ask for a Decimal Number
            if(selection==3||selection==4||selection==5)
            {
                System.out.println("Enter the Decimal Number to be Converted");
                InputInteger = in.next();
            }
            //Ask for a Hexadecimal Number
            else if(selection==12||selection==13||selection==14)
            {
                System.out.println("Enter the Hexadecimal Number to be Converted");
                InputInteger = in.next();
            }
            //Ask for a Octal Number
            else if(selection==9||selection==10||selection==11)
            {
                System.out.println("Enter the Octal Number to be Converted");
                InputInteger = in.next();
            }

            //Check if the Number Entered is correct
            boolean InputDataStatus=false;
            do{
                //If the selection requires a decimal numbers enters here
                if(selection==3||selection==4||selection==5) {
                   InputDataStatus = InputInteger.matches("[0-9]+");
                }
                //if the selection requires a hexadecimal number enters here
                else if(selection==12||selection==13||selection==14) {
                    String InIntLowerCase= InputInteger.toLowerCase();
                    InputDataStatus = InIntLowerCase.matches("[0-9a-f]+");
                }
                //if the selection requires an Octal number enters here
                else if(selection==9||selection==10||selection==11) {
                    InputDataStatus = InputInteger.matches("[0-7]+");
                }
                //Throw message to user if the input is incorrect - Request input again
                if(!InputDataStatus)
                {
                    if(selection==3||selection==4||selection==5)
                    {
                        System.out.println(InputInteger+" is not a Decimal number");
                        System.out.println("Please try again. Enter a Decimal number");
                        InputInteger = in.next();
                    }
                    //Ask for a Hexadecimal Number
                    else if(selection==12||selection==13||selection==14)
                    {
                        System.out.println(InputInteger+" is not a Hexadecimal number");
                        System.out.println("Please try again. Enter a Hexadecimal number");
                        InputInteger = in.next();
                    }
                    //Ask for a Octal Number
                    else if(selection==9||selection==10||selection==11)
                    {
                        System.out.println(InputInteger+" is not a Octal number");
                        System.out.println("Please try again. Enter an Octal number");
                        InputInteger = in.next();
                    }
                }
            } while(!InputDataStatus);

            //We call the functions that is going to do the transformation of the numbers
            String ConvNumObtained = ConvertNumbers(InputInteger, selection);

            //We throw the ouput message according to the operation performed
            if(selection==3||selection==10||selection==13)
            {
                System.out.println(InputInteger+" converted to binary is "+ConvNumObtained);
            }
            else if(selection==4||selection==11)
            {
                System.out.println(InputInteger+" converted to hexadecimal is "+ConvNumObtained);
            }
            else if(selection==5||selection==14)
            {
                System.out.println(InputInteger+" converted to octal is "+ConvNumObtained);
            }
            else if(selection==9||selection==12)
            {
                System.out.println(InputInteger+" converted to decimal is "+ConvNumObtained);
            }
        }
    }
    //Start of function that deals only with Binary Inputs
    static String AddOrMultiplyBinaries(long Binar1, long Binar2, int select)
    {
        //Variable Declaration
        int BinaryAddedResult, BinaryMultipliedResult=0;
        String OperationResult="";

        //Converting the Binary Numbers to Strings
        String StringBinar1 = Long.toString(Binar1);
        String StringBinar2 = Long.toString(Binar2);

        //Converting the Binary Strings to Integers
        int ChangedBinar1 = Integer.parseInt(StringBinar1,2); //The number 2 is the base of the StringBinar1
        int ChangedBinar2 = Integer.parseInt(StringBinar2,2); //Important to put the 2, since this determines the system base numeration
       switch (select) {
           //Add Two Binary Numbers and convert the result to a String
           case 1: BinaryAddedResult = ChangedBinar1+ChangedBinar2;
               OperationResult = Integer.toBinaryString(BinaryAddedResult);
               break;
           //Multiply Two Binary Numbers and convert the result to a String
           case 2: BinaryMultipliedResult = ChangedBinar1*ChangedBinar2;
               OperationResult = Integer.toBinaryString(BinaryMultipliedResult);
               break;
           //Convert a binary number to decimal number and convert the result to a Decimal String
           case 6: OperationResult = Integer.toString(ChangedBinar1);
               break;
           //Convert a binary number to hexadecimal number and convert the result to a
           case 7:  OperationResult = Integer.toHexString(ChangedBinar1);
               break;
           //Convert a binary number to Octal number
           case 8:  OperationResult = Integer.toOctalString(ChangedBinar1);
               break;
           default: break;
       }
       return OperationResult;
    }
    static String ConvertNumbers(String InputNumber, int select)
    {
        //Variable Declaration
        String OperationResult="";
        int OperationNumber=0;

        switch (select)
        {
            //Convert Decimal to Binary
            case 3: OperationNumber = Integer.parseInt(InputNumber);
                OperationResult = Integer.toBinaryString(OperationNumber);
                break;
            //Convert Decimal to Hexadecimal
            case 4: OperationNumber = Integer.parseInt(InputNumber);
                OperationResult = Integer.toHexString(OperationNumber);
                break;
            //Convert Decimal to Octal
            case 5: OperationNumber = Integer.parseInt(InputNumber);
                OperationResult = Integer.toOctalString(OperationNumber);
                break;
            //Convert Octal to Decimal
            case 9: OperationNumber = Integer.parseInt(InputNumber, 8);
                OperationResult=Integer.toString(OperationNumber);
                break;
            //Convert Octal to Binary
            case 10: OperationNumber = Integer.parseInt(InputNumber, 8);
                OperationResult = Integer.toBinaryString(OperationNumber);
                break;
            //Convert Octal to Hexadecimal
            case 11: OperationNumber = Integer.parseInt(InputNumber, 8);
                OperationResult = Integer.toHexString(OperationNumber);
                break;
            //Convert Hexadecimal to Decimal
            case 12: OperationNumber = Integer.parseInt(InputNumber, 16);
                OperationResult=Integer.toString(OperationNumber);
                break;
            //Convert Hexadecimal to Binary
            case 13: OperationNumber = Integer.parseInt(InputNumber, 16);
                OperationResult = Integer.toBinaryString(OperationNumber);
                break;
            //Convert Hexadecimal to Octal
            case 14: OperationNumber = Integer.parseInt(InputNumber, 16);
                OperationResult = Integer.toOctalString(OperationNumber);
                break;
            default: break;
        }
        //Convert the Result to String
        return OperationResult;
    }
}
