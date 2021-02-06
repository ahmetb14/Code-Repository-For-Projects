using System;
using System.Collections.Generic;
using System.Text;

namespace DictionaryAssignment
{
    public class MineDictionary<X>
    {
        X[] items;

        X[] tempArray;

        public MineDictionary()
        {
            items = new X[0];
        }

        public void Add(X item)
        {
            tempArray = items;
            items = new X[items.Length + 1];

            for (int i = 0; i < tempArray.Length; i++)
            {
                items[i] = tempArray[i];
            }

            items[items.Length - 1] = item;

            Console.WriteLine(item);

        }
    }
}
