using System;
using System.Collections.Generic;
using System.Text;

namespace GameServices
{
    public class Gamer : ICustomerDal
    {
        public void Add()
        {
            Console.WriteLine("Oyuncu veri tabanına eklendi!");
        }

        public void Delete()
        {
            Console.WriteLine("Oyuncu veri tabanından silindi!");
        }

        public void Update()
        {
            Console.WriteLine("Oyuncu veri tabanında güncellendi!");
        }

    }
}
