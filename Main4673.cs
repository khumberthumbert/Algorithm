using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudyC_
{
     class Main4673
    {
        static void Main(string[] args)
        {
            bool[] check = new bool[10001];

            for(int i = 1; i < 10001;  i++)
            {
                int n = d(i);

                if(n < 10001) check[n] = true;
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < 10001; i++)
            {
                if (!check[i])
                {
                    sb.Append(i).Append('\n');
                }
            }
            Console.WriteLine(sb);
        }


        public static int d(int number)
        {
            int sum = number;

            while(number != 0)
            {
                sum = sum + (number % 10);
                number = number / 10;
            }    
            return sum;
        }
    }
}
