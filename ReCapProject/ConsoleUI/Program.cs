using Business.Abstract;
using Business.Concrete;
using DataAccess.Concrete;
using System;

namespace ConsoleUI
{
    class Program
    {
        static void Main(string[] args)
        {
            ICarService carService = new CarManager(new InMemoryCarDal());

            foreach (var car in carService.GetCars())
            {
                Console.WriteLine("-->Araç Bilgisi<--");
                Console.WriteLine(car.Description);
                Console.WriteLine("                    ");
                Console.WriteLine("-->Araç Model Yılı<--");
                Console.WriteLine(car.ModelYear);
                Console.WriteLine("                    ");
                Console.WriteLine("-->Araç Fiyatı<--");
                Console.WriteLine(car.DailyPrice);
                Console.WriteLine("                    ");
                Console.WriteLine("-->Araç Marka Numarası<--");
                Console.WriteLine(car.BrandId);
                Console.WriteLine("                    ");
                Console.WriteLine("-->Araç Kimlik Numarası<--");
                Console.WriteLine(car.Id);
                Console.WriteLine("                    ");
                Console.WriteLine("-->Araç Renk Numarası<--");
                Console.WriteLine(car.ColorId);
            }
        }
    }
}
