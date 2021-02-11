using Business.Concrete;
using DataAccess.Concrete.EntityFramework;
using Entities.Concrete;
using System;

namespace ConsoleUI
{
    class Program
    {
        static void Main(string[] args)
        {
            //Stage1();
            //Stage2();

            CarManager productManager = new CarManager(new EfCarDal());

            var result = productManager.GetCarDetails();

            if (result.Success == true)
            {
                foreach (var car in result.Data)
                {
                    Console.WriteLine(car.BrandName + " => " + car.Descriptions);
                }
            }
            else
            {
                Console.WriteLine(result.Message);
            }

            Console.ReadLine();

        }

        private static void Stage2()
        {
            CarManager carManager = new CarManager(new EfCarDal());
            BrandManager brandManager = new BrandManager(new EfBrandDal());
            ColorManager colorManager = new ColorManager(new EfColorDal());

            Console.WriteLine("**************************************************************************************");

            foreach (var car in carManager.GetCarDetails().Data)
            {
                Console.WriteLine("=> Araç Bilgileri <=");
                Console.WriteLine("**************************************************************************************");
                Console.WriteLine("-> Arabanın Renk Adı: " + car.ColorName + "\n-> Arabanın Marka Adı: " + car.BrandName +
                  "\n-> Araba Hakkında Açıklama: " + car.Descriptions + "\n-> Arabanın Günlük Ücreti: " + car.DailyPrice);
                Console.WriteLine("**************************************************************************************");
            }

            Console.ReadLine();
        }

        private static void Stage1()
        {
            CarManager carManager = new CarManager(new EfCarDal());
            BrandManager brandManager = new BrandManager(new EfBrandDal());
            ColorManager colorManager = new ColorManager(new EfColorDal());

            Console.Write("> Hangi Marka Araba İstersiniz? ==> ");
            Console.WriteLine("                                ");
            byte brandId = Convert.ToByte(Console.ReadLine());

            foreach (var car in carManager.GetCarsByBrandId(brandId).Data)
            {
                Console.WriteLine($"-> Arabanın Marka Adı = {brandManager.GetById(car.BrandId).Data.BrandName}\n" +
                $"-> Arabanın Model Yılı = {car.ModelYear}\n" +
                $"-> Arabanın Renk Adı = {colorManager.GetById(car.ColorId).Data.ColorName}\n" +
                $"-> Araba Hakkında Açıklama = {car.Descriptions}\n" +
                $"-> Arabanın Günlük Ücreti = {car.DailyPrice}\n");
            }

            Console.WriteLine("> Hangi Renk Araba İstersiniz? ==> ");
            byte colorId = Convert.ToByte(Console.ReadLine());

            foreach (var car in carManager.GetCarsByColorId(colorId).Data)
            {
                Console.WriteLine($"-> Arabanın Renk Adı = {colorManager.GetById(car.ColorId).Data.ColorName}\n" +
                $"-> Arabanın Marka Adı = {brandManager.GetById(car.ColorId).Data.BrandName}\n" +
                $"-> Arabanın Model Yılı = {car.ModelYear}\n" +
                $"-> Araba Hakkında Açıklama = {car.Descriptions}\n" +
                $"-> Arabanın Günlük Ücreti = {car.DailyPrice}\n");

            }

            Brand brand1 = new Brand()
            {
                Id = 6,
                BrandName = "F"
            };

            brandManager.Add(brand1);
            Console.WriteLine();

            Car car1 = new Car()
            {
                BrandId = 7,
                ColorId = 7,
                DailyPrice = 120,
                ModelYear = "2010",
                Descriptions = "Fiat Palio 1.6 Benzin & LPG Active Sole 75 HP"
            };

            carManager.Add(car1);

        }
    }
}
