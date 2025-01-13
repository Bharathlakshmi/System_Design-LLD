import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake
{
    private char[][] snakeboard=null;
    private Queue<Node> snakedots = new LinkedList<Node>();
    private Queue<Node> food=new LinkedList<Node>();

    Snake(int row,int col)
    {
        snakeboard=new char[row][col];
        snakedots.add(new Node(0,0));

        food.add(new Node(2,2));
        food.add(new Node(3,3));
        food.add(new Node(4,2));
        food.add(new Node(2,4));
        food.add(new Node(3,4));

        displayFood(food.poll());
    }

    public void initiateSnake()
    {
        int row=0,col=0;
        snakeboard[row][col]='.';
        printSnake();

        while (true)
        {
            System.out.println("Enter next move : ");
            Scanner sc=new Scanner(System.in);
            char direction=sc.next().charAt(0);

            if (direction=='u')
            {
                snakeMove(--row,col);
            }
            if(direction=='d')
            {
                snakeMove(++row,col);
            }
            if(direction=='l')
            {
                snakeMove(row,--col);
            }
            if(direction=='r')
            {
                snakeMove(row,++col);
            }
        }
    }

    public void snakeMove(int row,int col)
    {
        if(row >=0 && row<snakeboard.length && col>=0 && col<snakeboard.length)
        {
            snakedots.add(new Node(row,col));

            if (snakeboard[row][col] != 'X')  //remove tail
            {
                Node n = snakedots.poll();
                int r=n.getRow();
                int c=n.getCol();
                snakeboard[r][c]='\0';
            }

            if(snakeboard[row][col] == 'X')
            {
                if(food.isEmpty())
                {
                    moveForwardAndPrint(row, col);
                    System.out.println("Congratulations! \nYou won the Game !! \n");
                    System.exit(0);
                }
                displayFood(food.poll());
            }

            if(snakeboard[row][col] == '.')
            {
                System.out.println("Game Over!! ");
                System.exit(0);
            }

            moveForwardAndPrint(row,col);
        }
        else {
            System.out.println("Game Over!! ");
            System.exit(0);
        }
    }

    public void displayFood(Node n)
    {
        int r=n.getRow();
        int c=n.getCol();
        snakeboard[r][c]='X';
    }

    public void moveForwardAndPrint(int row,int col)
    {
        snakeboard[row][col]='.';
        printSnake();
    }

    public void printSnake()
    {
        for(char[] c : snakeboard)
        {
            for (int j = 0; j < snakeboard[0].length ; j++) {
                System.out.print(c[j]+ " ");
            }
            System.out.println();
        }
    }
}
