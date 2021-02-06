using System;
using System.Collections.Generic;
using System.Text;

namespace GameServices
{
    public class PersonValidation : CustomerInformation
    {
        public bool status;

        public PersonValidation(CustomerInformation customerInformation)
        {
            Console.WriteLine("TcNo Bilginizi Giriniz!");
            TcNo = Console.ReadLine();
            Console.WriteLine("///////////////////////////////////");

            if (customerInformation.TcNo == TcNo)
            {
                status = true;
                Console.WriteLine("Hoşgeldin :) " + customerInformation.FirstName + " " + customerInformation.LastName);
                Console.WriteLine("//////////////////////////////////");
            }
            else
            {
                status = false;
                Console.WriteLine("TcNo Bilginiz Doğru Değil!");
            }

        }
    }
}
