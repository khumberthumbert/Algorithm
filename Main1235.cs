using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudyC_
{
    class Main1235
    {
        static void Main(string[] args)
        {
            //입력 받기
            int n = int.Parse(Console.ReadLine()); // 학생 수
            string[] studentNumbers = new string[n];

            for (int i = 0; i< n; i++)
            {
                studentNumbers[i] = Console.ReadLine(); // 학생 번호 입력
            }

            //최소 k 찾기
            int minK = FindMinK(studentNumbers);
            Console.WriteLine(minK);
        }

        static int FindMinK(string[] studentNumbers)
        {
            int maxLength = 0;

            //번호의 최대 길이 찾기
            foreach (var num in studentNumbers) // foreach -> 배열이나 컬렉션을 순회하는 반복문, var -> C#의 타입 추론 기능.
            {
                maxLength = Math.Max(maxLength, num.Length);
            } 

            // k를 1부터 최대 길이까지 증가하며 확인
            for (int k = 1; k <= maxLength; k++)
            {
                HashSet<string> seen = new HashSet<string>(); // 잘라낸 번호 저장
                bool unique = true;

                foreach(var num in studentNumbers)
                {
                    //뒤에서 k 자리만 남김
                    string trimmed = num.Length >= k ? num.Substring(num.Length - k) : num; 

                    //중복체크
                    if (seen.Contains(trimmed))
                    {
                        unique = false;
                        break;
                    }
                    seen.Add(trimmed);
                }
                if (unique) return k; // 모든 번호가 유일하다면 최소 k 반환
       
            }
            return maxLength;
        }
    }
}
