using System;
using System.Collections.Generic;
using System.Text;

namespace ClassMethodDemo
{
    class CustomerManager
    {
        public void Add_Customer(Customer customer)
        {
            Console.WriteLine("--Müşteri Ekleme--");
            Console.WriteLine("Müşteri Id: " + customer.Id);
            Console.WriteLine("Müşteri TcNo: " + customer.TcNo);
            Console.WriteLine("Müşteri Adı: " + customer.FirstName);
            Console.WriteLine("Müşteri Soyadı: " + customer.LastName);
            Console.WriteLine("Müşteri Veri Tabanına Eklendi!");
            Console.WriteLine();
        }

        public void Get_All_Customer(Customer[] customers)
        {
            Console.WriteLine("--Tüm Müşteriler--");
            foreach (var customer in customers)
            {
                Console.WriteLine("Müşteri: " + customer.FirstName + " " + customer.LastName);
            }

            Console.WriteLine();
        }

        public void Delete_Customer(Customer customer)
        {
            Console.WriteLine("--Müşteri Silme--");
            Console.WriteLine(customer.FirstName + " " + customer.LastName + "Müşteri Veri Tabanından Silindi!");
            Console.WriteLine();
        }
    }
}
