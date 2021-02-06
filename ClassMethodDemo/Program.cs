using System;

namespace ClassMethodDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Customer customer1 = new Customer();
            customer1.Id = 1;
            customer1.TcNo = "96385274131";
            customer1.FirstName = "Burak Emre";
            customer1.LastName = "Aktaş";
            customer1.Age = 18;

            Customer customer2 = new Customer();
            customer2.Id = 2;
            customer2.TcNo = "74185296362";
            customer2.FirstName = "Tuğra Metin";
            customer2.LastName = "Dönmez";
            customer2.Age = 18;

            Customer customer3 = new Customer();
            customer3.Id = 3;
            customer3.TcNo = "78945612378";
            customer3.FirstName = "Görkem";
            customer3.LastName = "Öcal";
            customer3.Age = 19;

            Customer customer4 = new Customer();
            customer4.Id = 4;
            customer4.TcNo = "12345678996";
            customer4.FirstName = "Mustafa Berk";
            customer4.LastName = "Akgül";
            customer4.Age = 18;

            Customer customer5 = new Customer();
            customer5.Id = 5;
            customer5.TcNo = "15975384269";
            customer5.FirstName = "Ahmet Berkay";
            customer5.LastName = "Yılmaz";
            customer5.Age = 19;

            Customer[] allCustomers = new Customer[]
            {
                customer1,
                customer2,
                customer3,
                customer4,
                customer5
            };

            CustomerManager customerManager = new CustomerManager();
            customerManager.Get_All_Customer(allCustomers);
            customerManager.Add_Customer(customer1);
        }
    }
}
