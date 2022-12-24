import java.util.Scanner;
/**
 * Class rectanglePlotter is a tool to draw a rectangle on 40 * 20 graph.
 * @author Jina Pak
 * @since  March 11, 2022
 * 
 */
public class rectanglePlotter {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        printIdentification();
        userInteration();
          
    }

    /**
     *  Info!
     */
    public static void printIdentification()
    {
        System.out.println("### Rectangle Plotter  Author: Jina Pak  ###");
        System.out.println("### Course/Section - CPSC1150-3    St.# - 100377523 ###");
        System.out.println(new java.util.Date() + "\n");

    }


    /**
     * This method is the ultimate entity of this program, which as several essential methods to implement
     */
    public static void userInteration(){
        
        System.out.println("We are here to plot a rentangle on a 40*20 positive Cartesian gragh.");
        
        int x = getXCoordinate();

        int y = getYCoordinate();
        
        int width = getWidth(x);

        int height = getHeight(y);

        drawGraph(x,y,width,height);


        

    }

    
    /**
     * This method ask a user X coordinate of a rectangle that the user wants to draw with a few validation questions.
     * @return X coordinate of a rectangle.
     */
    private static int getXCoordinate(){
        Scanner keyboard = new Scanner(System.in);
        final int MAX = 39;
        System.out.println("Please enter a x coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
        int xCoordinate = (int)keyboard.nextDouble();
        while (xCoordinate < 1){
            System.out.println("You entered an invalid number. The x coordinate should be greater than 0.");
            System.out.println("Please enter a x coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
            xCoordinate = (int)keyboard.nextDouble();
        }

        while (xCoordinate > 39){
            System.out.println("You entered an invalid number. The x coordinate should be less than and equal to 39 to form a rectangle.");
            System.out.println("Please enter a x coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
            xCoordinate = (int)keyboard.nextDouble();
        }
       
        return xCoordinate;
    }

    /**
     * This method ask a user Y coordinate of a rectangle with a few validation questions.
     * @return Y coordinate of a rectangle.
     */
    private static int getYCoordinate(){
        final int MAX = 20;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a y coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
        int yCoordinate = (int)keyboard.nextDouble();
        while (yCoordinate < 1){
            System.out.println("You entered an invalid number. The y coordinate should be greater than 1 to form a rectangle.");
            System.out.println("Please enter a y coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
            yCoordinate = (int)keyboard.nextDouble();
        }

        while (yCoordinate > MAX){
            System.out.println("You entered an invalid number. The y coordinate should be less than and equal to 20.");
            System.out.println("Please enter a y coordinate which is going to be a top-left corner of the rectangle. Type only numbers in!");
            yCoordinate = (int)keyboard.nextDouble();
        }

        return yCoordinate;
    }

    /**
     * This method as a user a width of a rectangle considering x coordinate's value.
     * @param x is needed as a value of the x coordinate affects validation of the input.
     * @return width of a rectangle.
     */
    private static int getWidth(int x){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a width rectangle. Type only numbers in!");
        int width = (int)keyboard.nextDouble();
        int comparison = x + width -1; 

        while (width <= 1){
            System.out.println("You entered an invalid number. The width should be greater than 1.");
            System.out.println("Please enter a width of your rectangle. Type only numbers in!");
            width = (int)keyboard.nextDouble();
        }

        
        while (comparison > 40){
            System.out.println("You entered an invalid number. The width should fit in the graph. The sum of the X coordinate and width-1 should be less than equal to 40.");
            System.out.println("Please enter a width of your rectangle. Type only numbers in!");
            
            width = (int)keyboard.nextDouble();
            comparison = x + width -1;
        }

        return width;
    }

    /**
     * This method ask a user a height of a rectangle considering y coordinate's value.
     * @param y is needed as a value of the y coordinate affects validation of the input. 
     * @return height of a rectangle
     */
    private static int getHeight(int y){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a height rectangle.");
        int height = (int)keyboard.nextDouble();
        int comparison = y - (height - 1);

    

        while (height <= 1){
            System.out.println("You entered an invalid number. The height should be greater than 1.");
            System.out.println("Please enter a height of your rectangle. Type only numbers in!");
            height = (int)keyboard.nextDouble();
        }

        while (comparison <= 0){
            System.out.println("You entered an invalid number. The height should fit in the graph. The subtraction of the X coordinate and width-1 should be less than equal to 40.");
            System.out.println("Please enter a height of your rectangle. Type only numbers in!");
            
            height = (int)keyboard.nextDouble();
            comparison = y - height + 1;
        }

        return height;
    }

   
    /**
     * Here is a method which draws an actual rectangle on the graph. It has siginificants methods to construct a graph and rectangle.
     * These parameters will be the essential part of the formation of a rectangle.
     * @param x is X coordinate of the rec
     * @param y is Y coordinate of the rec
     * @param width is width of the rec
     * @param height is height of the rec
     * @return the finished graph with the rectangle
     */
    private static String drawGraph(int x, int y, int width, int height){
        
        String result = "   ^\n";
       
        
        
        result += drawYAxis(x, y, width, height);
        result += drawXAxisLine() + "\n";
        result += drawXAxisNum();
       
        System.out.println(result);
        return result;
    }

    /**
     * This method draws Y axis of the graph and rentangle. "printLine" method involves here to draw a rectangle. 
     * @param x is X coordinate of the rec
     * @param y is Y coordinate of the rec
     * @param width is width of the rec
     * @param height is height of the rec
     * @return the Y axis and a rectangle
     */
    private static String drawYAxis(int x, int y, int width, int height){
        
        String result = "";
        for(int i = 20; i >= 1; i--){
            if (i%5 == 0){
                if (Integer.toString(i).length() == 1){
                    result += " "+ i ;
                    result += " +";

                }

                else{
                    result += i;
                    result += " +";
                    
                }

                if (i > y-height && i <= y){
                        
                    result += printLine(' ', x, '*', width);
                     
                }
            }

            else{
                result += "   |";
                if (i > y-height && y >= i){
                        
                    result += printLine(' ', x, '*', width);
                       
                }
            }


            result += "\n";
        }

        return result;
    }
    

    /**
     * This method is for drawing a line which can be either a backgraound(space) or a snippet line of the rectangle.
     * @param character is the char parameter that printSpace takes 
     * @param num is the int parameter that printSpace takes
     * @param character2 is the char parameter that printStar takes
     * @param number is the int parameter that printStar takes
     * @return the concatenated version of string from two results from two methods
     */
    private static String printLine(char character, int num, char character2, int number){

        String result = printSpace(character, num) + printStar(character2, number);
        

        return result;
    }

    /**
     * This method name refers that character should be ' ', space, nothing else. However you can put anything here technically, I just didn't call any other characters but ' '.
     * @param character will be printed up to num times
     * @param num is an indicater that tells you how many times the while loop continues
     * @return character * num 
     */
    private static String printSpace(char character, int num){

        String result = "";
        int count = 1;
        while (count < num){
            result += character;
            ++count;
        }

        return result;
    }

    /**
     * Here you will print star
     * @param character will be printed
     * @param num this much
     * @return result of a printed line
     */
    private static String printStar(char character, int num){

        String result = "";
        int count = 1;
        while (count <= num){
            result += character;
            count++;
        }

        return result;
    }

 
    /**
     * This method draws the very last line, X axis
     * @return a line of X axis
     */
    private static String drawXAxisLine(){
        String axis = " 0 +";
        int xCoordinate = 1;
        while (xCoordinate <= 40){
            if (xCoordinate%5 == 0){
                axis += "+";
            }

            else{
                axis += "=";
            }

            xCoordinate ++;
        }
        axis += ">";

        //System.out.print(axis);

        return axis;
    }

    /**
     * Also, this method types(draws) the coordinate numbers under the X axis!
     * @return the sequence of numbers as coordinates
     */
    private static String drawXAxisNum(){
        String number = "   ";
        int count = 0;
        

        while (count <= 40){
            if (count%5 == 0 && count < 10){
                number += count + "    ";
            }
            else if (count%5 == 0 && count >= 10){
                number += count + "   ";
            }
            count ++;

        }

        //System.out.println(number);
        
        return number;
    }
}



