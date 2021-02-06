using System;

namespace DictionaryAssignment
{
    class Program
    {
        static void Main(string[] args)
        {
            MineDictionary<string> mineDictionary = new MineDictionary<string>();

            mineDictionary.Add("Ahmet");
            Console.WriteLine("<-------->");
            mineDictionary.Add("Burak");
            Console.WriteLine("<-------->");
            mineDictionary.Add("Görkem"); 

        }
    }
}

