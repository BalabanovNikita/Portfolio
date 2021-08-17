using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Snake
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.SetWindowSize(80,27);
            Console.SetBufferSize(80,27);



            Walls walls = new Walls(80, 25);
            walls.Draw();
            FoodCreater foodCreater = new FoodCreater(80,25, '$');
            Point food = foodCreater.CreateFood();
            food.Draw();
            Point p1 = new Point(5, 3, '*');
            Snake snake = new Snake(p1, 4, Direction.RIGHT);
            snake.Draw();
            while (true)
            {
                if (walls.IsHIt(snake) || snake.IsHitTail())
                {
                    Console.ForegroundColor = ConsoleColor.Blue;
                    Console.SetCursorPosition(80/2-5, 25/2);
                    Console.WriteLine("Game over!");
                    break;
                }
                if (snake.Eat(food))
                {
                    food = foodCreater.CreateFood();
                    food.Draw();
                }
                else snake.Move();
                if (Console.KeyAvailable)
                {
                    ConsoleKeyInfo key = Console.ReadKey();
                    snake.HandleKey(key.Key);
                }
                Thread.Sleep(200);

            }
            Console.ReadLine();
        }
        static void Draw(Figure figure)
        {
            figure.Draw();
        }
        
    }
}
