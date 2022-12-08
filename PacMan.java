import java.util.Random;
import java.util.Scanner;

public class PacMan
{
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    char bound[][]=new char[22][22];
    char x =22;
    char y =12;

    public void setMaze()
    {

        bound = new char[y][x];
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                if (i == 0 || i == y - 1 || j == 0 || j == x - 1) //i statements for top and bottom border
// j statements for left and right border
                {
                    bound[i][j] = '#'; //outer wall
                }
//Inner walls
                else if (i == 2 && j > 1 && j < 6) //hurdle at(2,1) to (2,6)
                {
                    bound[i][j] = '#';
                }
                else if (i == 4 && j==8) //hurdle at(4,8)
                {
                    bound[i][j] = '#';
                } else if (i == 5 && j == 8)//hurdle at(5,8)
                {
                    bound[i][j] = '#';
                }
                else if (i == 6 && j == 8)//hurdle at(6,8)
                {
                    bound[i][j] = '#';
                }
                else if (i == 7 && j == 8)//hurdle at(7,8)
                {
                    bound[i][j] = '#';
                }
                else if (i == 9 && j > 5 && j < 11) //hurdle at(2,1) to (2,6)
                {
                    bound[i][j] = '#';
                }
                else if (i == 3 && j == 16)//hurdle at(3,16)
                {
                    bound[i][j] = '#';
                }
                else if (i == 4 && j == 16)//hurdle at(4,16)
                {
                    bound[i][j] = '#';
                }
                else if (i == 5 && j == 16)//hurdle at(5,16)
                {
                    bound[i][j] = '#';
                }
                else if (i == 6 && j == 16)//hurdle at(6,16)
                {
                    bound[i][j] = '#';
                }
                else // Food
                {
                    bound[i][j] = '.'; //inner food
                }

            }

        }
        build();

    }
    public void build()
    {
        class game
        {

            int[][] hurdles = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {0, 10}, {0, 11}, {1, 11}, {2, 11}, {3, 11}, {4, 11}, {5, 11}, {6, 11}, {7, 11}, {8, 11}, {9, 11}, {10, 11}, {11, 11}, {12, 11}, {13, 11}, {14, 11}, {15, 11}, {16, 11}, {17, 11}, {18, 11}, {19, 11}, {20, 11}, {21, 11}, {21, 10}, {21, 9}, {21, 8}, {21, 7}, {21, 6}, {21, 5}, {21, 4}, {21, 3}, {21, 2}, {21, 1}, {20, 0}, {19, 0}, {18, 0}, {17, 0}, {16, 0}, {15, 0}, {14, 0}, {13, 0}, {12, 0}, {11, 0}, {10, 0}, {9, 0}, {8, 0}, {7, 0}, {6, 0}, {5, 0}, {4, 0}, {3, 0}, {2, 0}, {1, 0}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {8, 4}, {8, 5}, {8, 6}, {8, 7}, {16, 3}, {16, 4}, {16, 5}, {16, 6}, {6, 9}, {7, 9}, {8, 9}, {9, 9}, {10, 9}};
            int x1;
            int y1;

            int g1x;
            int g1y;

            int g2x;

            int g2y;

            int totalscores;

            public void setTotalscores(int totalscores) {
                this.totalscores = totalscores;
            }

            public int getTotalscores() {
                return totalscores;
            }

            public int getX1()
            {
                return x1;
            }
            public void setX1(int x1) {
                this.x1 = x1;
            }
            public void setY1(int y1) {
                this.y1 = y1;
            }
            public int getY1() {
                return y1;
            }



            public int getG1y() {
                return g1y;
            }
            public void setG1y(int g1y) {
                this.g1y = g1y;
            }
            public int getG1x()
            {
                return g1x;
            }
            public void setG1x(int g1x)
            {
                this.g1x = g1x;
            }



            public int getG2y() {
                return g2y;
            }
            public void setG2y(int g2y) {
                this.g2y = g2y;
            }
            public int getG2x() {
                return g2x;
            }
            public void setG2x(int g2x) {
                this.g2x = g2x;
            }

        }
        class gameplay extends game
        {
            game gameobj =new game();
            void gamer()
            {
                gameobj.setG2x(10);
                gameobj.setG2y(8);

                gameobj.setG1x(8);
                gameobj.setG1y(8);

                int ghost1updown;
                int ghost1rightleft;

                int ghost2updown;
                int ghost2rightleft;

                gameobj.setX1(4);
                gameobj.setY1(6);

                int downe;
                int rightt;


                int randomnumber2;
                int randomnumber1;
                char movesignal;

                bound[gameobj.getY1()][gameobj.getX1()]='P';
                bound[gameobj.getG2y()][gameobj.getG2x()]='B';
                bound[gameobj.getG1y()][gameobj.getG1x()]='G';
                for (int i = 0; i < y; i++)
                {
                    for (int j = 0; j < x; j++)
                    {
                        System.out.print(bound[i][j]+" ");

                    }
                    System.out.println();
                }

                System.out.println("You have 3 Lives");
                System.out.println("W-Up\nS-Down\nA-Left\nD-Right");


                int totalscore=0;


                for(int lives=3;lives>0;lives--)
                {
                    int u=98;


                    while(u<100)
                    {
                        System.out.println("You have lives left: "+lives);


                        downe= gameobj.getY1();
                        rightt= gameobj.getX1();


                        randomnumber1 = ran.nextInt(4);
                        randomnumber2 = ran.nextInt(4);

                        ghost1updown= gameobj.getG1y();
                        ghost1rightleft= gameobj.getG1x();

                        ghost2updown= gameobj.getG2y();
                        ghost2rightleft= gameobj.getG2x();
                        movesignal = sc.next().charAt(0);


                        if (randomnumber1 == 0)
                        {
                            --ghost1updown;
                            gameobj.setG1y(ghost1updown);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG1x() && hurdles[j][1] == gameobj.getG1y())
                                {
                                    ++ghost1updown;
                                    gameobj.setG1y(ghost1updown);
                                }

                            }
                            if(bound[gameobj.getG1y()+1][gameobj.getG1x()]=='G')
                            {
                                bound[gameobj.getG1y()+1][gameobj.getG1x()]='.';
                            }
                            if (bound[gameobj.getG1y()+1][gameobj.getG1x()]==' ')
                            {
                                bound[gameobj.getG1y()+1][gameobj.getG1x()]=' ';
                            }
                            if (bound[gameobj.getG1y()+1][gameobj.getG1x()]=='B')
                            {
                                bound[gameobj.getG1y()+1][gameobj.getG1x()]=' ';
                            }

                        }
                        if (randomnumber1 == 1)
                        {
                            ++ghost1rightleft;
                            gameobj.setG1x(ghost1rightleft);

                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG1x() && hurdles[j][1] == gameobj.getG1y())
                                {
                                    --ghost1rightleft;
                                    gameobj.setG1x(ghost1rightleft);
                                }
                            }
                            if(bound[gameobj.getG1y()][gameobj.getG1x()-1]=='G')
                            {
                                bound[gameobj.getG1y()][gameobj.getG1x()-1]='.';
                            }
                            if (bound[gameobj.getG1y()][gameobj.getG1x()-1]==' ')
                            {
                                bound[gameobj.getG1y()][gameobj.getG1x()-1]=' ';
                            }
                        }
                        if (randomnumber1== 2)
                        {
                            ++ghost1updown;
                            gameobj.setG1y(ghost1updown);
                            for (int k1 = 0; k1 < hurdles.length; k1++)
                            {
                                if (hurdles[k1][0] == gameobj.getG1x() && hurdles[k1][1] == gameobj.getG1y())
                                {
                                    --ghost1updown;
                                    gameobj.setG1y(ghost1updown);
                                }
                            }
                            if(bound[gameobj.getG1y()-1][gameobj.getG1x()]=='G')
                            {
                                bound[gameobj.getG1y()-1][gameobj.getG1x()]='.';
                            }
                            if (bound[gameobj.getG1y()-1][gameobj.getG1x()]==' ')
                            {
                                bound[gameobj.getG1y()-1][gameobj.getG1x()]=' ';
                            }
                        }
                        if (randomnumber1 == 3)
                        {
                            --ghost1rightleft;
                            gameobj.setG1x(ghost1rightleft);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG1x() && hurdles[j][1] == gameobj.getG1y())
                                {
                                    ++ghost1rightleft;
                                    gameobj.setG1x(ghost1rightleft);
                                }
                            }
                            if(bound[gameobj.getG1y()][gameobj.getG1x()+1]=='G')
                            {
                                bound[gameobj.getG1y()][gameobj.getG1x()+1]='.';
                            }
                            if (bound[gameobj.getG1y()][gameobj.getG1x()+1]==' ')
                            {
                                bound[gameobj.getG1y()][gameobj.getG1x()+1]=' ';
                            }
                        }



                        if (randomnumber2 == 0)
                        {
                            ++ghost2updown;
                            gameobj.setG2y(ghost2updown);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG2x() && hurdles[j][1] == gameobj.getG2y())
                                {
                                    --ghost2updown;
                                    gameobj.setG2y(ghost2updown);
                                }
                            }
                            if(bound[gameobj.getG2y()-1][gameobj.getG2x()]=='B')
                            {
                                bound[gameobj.getG2y()-1][gameobj.getG2x()]='.';
                            }
                            else if (bound[gameobj.getG2y()-1][gameobj.getG2x()]==' ')
                            {
                                bound[gameobj.getG2y()-1][gameobj.getG2x()]=' ';
                            }
                        }
                        if (randomnumber2 == 1)
                        {
                            --ghost2updown;
                            gameobj.setG2y(ghost2updown);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG2x() && hurdles[j][1] == gameobj.getG2y())
                                {
                                    ++ghost2updown;
                                    gameobj.setG2y(ghost2updown);
                                }
                            }
                            if(bound[gameobj.getG2y()+1][gameobj.getG2x()]=='B')
                            {
                                bound[gameobj.getG2y()+1][gameobj.getG2x()]='.';
                            }
                            else if (bound[gameobj.getG2y()+1][gameobj.getG2x()]==' ')
                            {
                                bound[gameobj.getG2y()+1][gameobj.getG2x()]=' ';
                            }
                        }
                        if (randomnumber2 == 2)
                        {
                            ++ghost2rightleft;
                            gameobj.setG2x(ghost2rightleft);

                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG2x() && hurdles[j][1] == gameobj.getG2y())
                                {
                                    --ghost2rightleft;
                                    gameobj.setG2x(ghost2rightleft);
                                }
                            }
                            if(bound[gameobj.getG2y()][gameobj.getG2x()-1]=='B')
                            {
                                bound[gameobj.getG2y()][gameobj.getG2x()-1]='.';
                            }
                            else if (bound[gameobj.getG2y()][gameobj.getG2x()-1]==' ')
                            {
                                bound[gameobj.getG2y()][gameobj.getG2x()-1]=' ';
                            }
                        }
                        if (randomnumber2 ==3)
                        {
                            --ghost2rightleft;
                            gameobj.setG2x(ghost2rightleft);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getG2x() && hurdles[j][1] == gameobj.getG2y())
                                {
                                    ++ghost2rightleft;
                                    gameobj.setG2x(ghost2rightleft);
                                }
                            }
                            if(bound[gameobj.getG2y()][gameobj.getG2x()+1]=='B')
                            {
                                bound[gameobj.getG2y()][gameobj.getG2x()+1]='.';
                            }
                            else if (bound[gameobj.getG2y()][gameobj.getG2x()+1]==' ')
                            {
                                bound[gameobj.getG2y()][gameobj.getG2x()+1]=' ';
                            }
                        }


                        //FOR PAC MAN STAY AWAY!!!!!!!
                        if (movesignal == 's')
                        {
                            ++downe;
                            gameobj.setY1(downe);
                            for (int j = 0; j < hurdles.length; j++)
                            {
                                if (hurdles[j][0] == gameobj.getX1() && hurdles[j][1] == gameobj.getY1())
                                {
                                    System.out.println("PacMan encounters hurdles :"+"["+ gameobj.getX1()+":"+ gameobj.getY1()+"]");
                                    --downe;
                                    gameobj.setY1(downe);
                                }


                            }
                            if(gameobj.getG1x() == gameobj.getX1() && gameobj.getG1y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 1 has caught you");

                                u=101;
                            }
                            if(gameobj.getG2x() == gameobj.getX1() && gameobj.getG2y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 2 has caught you");
                                u=101;
                            }
                            totalscore=totalscore+10;
                            bound[gameobj.getY1()-1][gameobj.getX1()]=' ';

                        }

                        if (movesignal == 'd')
                        {
                            ++rightt;
                            gameobj.setX1(rightt);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getX1() && hurdles[j][1] == gameobj.getY1())
                                {
                                    System.out.println("PacMan encounters hurdles :"+"["+ gameobj.getX1()+":"+ gameobj.getY1()+"]");
                                    --rightt;
                                    gameobj.setX1(rightt);
                                }
                            }
                            if(gameobj.getG1x() == gameobj.getX1() && gameobj.getG1y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 1 has caught you");
                                u=101;
                            }
                            if(gameobj.getG2x() == gameobj.getX1() && gameobj.getG2y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 2 has caught you");
                                u=101;
                            }
                            totalscore=totalscore+10;
                            bound[gameobj.getY1()][gameobj.getX1()-1]=' ';
                        }
                        if (movesignal == 'w')
                        {
                            --downe;
                            gameobj.setY1(downe);
                            for (int j = 0; j < hurdles.length; j++)
                            {


                                if (hurdles[j][0] == gameobj.getX1() && hurdles[j][1] == gameobj.getY1())
                                {
                                    System.out.println("PacMan encounters hurdles :"+"["+ gameobj.getX1()+":"+ gameobj.getY1()+"]");
                                    ++downe;
                                    gameobj.setY1(downe);
                                }

                            }
                            if(gameobj.getG1x() == gameobj.getX1() && gameobj.getG1y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 1 has caught you");
                                u=101;
                            }
                            if(gameobj.getG2x() == gameobj.getX1() && gameobj.getG2y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 2 has caught you");
                                u=101;
                            }
                            totalscore=totalscore+10;
                            bound[gameobj.getY1()+1][gameobj.getX1()]=' ';

                        }
                        if (movesignal == 'a')
                        {
                            --rightt;
                            gameobj.setX1(rightt);
                            for (int j = 0; j < hurdles.length; j++)
                            {

                                if (hurdles[j][0] == gameobj.getX1() && hurdles[j][1] == gameobj.getY1())
                                {
                                    System.out.println("PacMan encounters hurdles :"+"["+ gameobj.getX1()+":"+ gameobj.getY1()+"]");
                                    ++rightt;
                                    gameobj.setX1(rightt);
                                }
                            }
                            if(gameobj.getG1x() == gameobj.getX1() && gameobj.getG1y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 1 has caught you");
                                u=101;
                            }
                            if(gameobj.getG2x() == gameobj.getX1() && gameobj.getG2y() == gameobj.getY1())
                            {
                                System.out.println("Ghost 2 has caught you");
                                u=101;
                            }
                            totalscore=totalscore+10;
                            bound[gameobj.getY1()][gameobj.getX1()+1]=' ';
                        }



                        //FOR PAC MAN STAY AWAY!!!!!!!




                        bound[gameobj.getG1y()][gameobj.getG1x()]='G';

                        bound[gameobj.getY1()][gameobj.getX1()]='P';

                        bound[gameobj.getG2y()][gameobj.getG2x()]='B';


                        //DO NOT CROSS THIS LINE !!!!!!
                        for (int i = 0; i < y; i++)
                        {
                            for (int j = 0; j < x; j++)
                            {
                                System.out.print(bound[i][j]+" ");

                            }
                            System.out.println();
                        }
                        System.out.println("PacMan is at =" +Math.abs(gameobj.getX1())+":"+Math.abs(gameobj.getY1()));

                        System.out.println("Ghost1 is at ="+Math.abs(gameobj.getG1x())+":"+Math.abs(gameobj.getG1y()));

                        System.out.println("Ghost2 is at ="+Math.abs(gameobj.getG2x())+":"+ Math.abs(gameobj.getG2y()));
                        gameobj.setTotalscores(totalscore);
                        System.out.println("W-Up\nS-Down\nA-Left\nD-Right");
                    }

                    bound[gameobj.getG1y()][gameobj.getG1x()]=' ';

                    bound[gameobj.getY1()][gameobj.getX1()]=' ';

                    bound[gameobj.getG2y()][gameobj.getG2x()]=' ';
                    gameobj.setG2x(10);
                    gameobj.setG2y(8);

                    gameobj.setG1x(8);
                    gameobj.setG1y(8);

                    gameobj.setX1(4);
                    gameobj.setY1(6);
                    for (int i = 0; i < y; i++)
                    {
                        for (int j = 0; j < x; j++)
                        {
                            System.out.print(bound[i][j]+" ");

                        }
                        System.out.println();
                    }


                }
                System.out.println("Gamer Over!");
                System.out.println("Your Score is: "+ gameobj.getTotalscores());

            }


        }

        gameplay iop=new gameplay();
        iop.gamer();

    }
    public static void main(String[] args)
    {
        PacMan mmm=new PacMan();
        mmm.setMaze();
    }
}
