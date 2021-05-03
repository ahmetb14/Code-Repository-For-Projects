using InterfaceAbstractDemo.Abstract;
using InterfaceAbstractDemo.Adapters;
using InterfaceAbstractDemo.Concrete;
using InterfaceAbstractDemo.Entites;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InterfaceAbstractDemo
{
    class Program
    {
        static void Main(string[] args)
        {

            BaseCustomerManager baseCustomerManager = new NeroCustomerManager(new MernisServiceAdapter());

            baseCustomerManager.Save(new Customer
            {
                DateOfBirth = new DateTime(2002, 12, 20),
                FirstName = "Ahmet Berkay",
                LastName = "Yılmaz",
                NationalityId = "96378974156"
            });

            Console.ReadLine();

        }

    }

}



