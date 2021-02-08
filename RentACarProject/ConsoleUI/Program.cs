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
            CarManager carManager = new CarManager(new EfCarDal());
            BrandManager brandManager = new BrandManager(new EfBrandDal());
            ColorManager colorManager = new ColorManager(new EfColorDal());

            Console.Write("-Hangi Marka Araba İstersiniz? ==> ");
            byte brandId = Convert.ToByte(Console.ReadLine());

            foreach (var car in carManager.GetCarsByBrandId(brandId))
            {
                Console.WriteLine($"Arabanın Marka Adı = {brandManager.GetById(car.BrandId).BrandName}\n" +
                $"Arabanın Model Yılı = {car.ModelYear}\n" +
                $"Arabanın Renk Adı = {colorManager.GetById(car.ColorId).ColorName}\n" +
                $"Araba Hakkında Açıklama = {car.Descriptions}\n" +
                $"Arabanın Günlük Ücreti = {car.DailyPrice}\n");
            }

            Console.WriteLine("-Hangi Renk Araba İstersiniz? ==> ");
            byte colorId = Convert.ToByte(Console.ReadLine());

            foreach (var car in carManager.GetCarsByColorId(colorId))
            {
                Console.WriteLine($"Arabanın Renk Adı = {colorManager.GetById(car.ColorId).ColorName}\n" +
                $"Arabanın Marka Adı = {brandManager.GetById(car.ColorId).BrandName}\n" +
                $"Arabanın Model Yılı = {car.ModelYear}\n" +
                $"Araba Hakkında Açıklama = {car.Descriptions}\n" +
                $"Arabanın Günlük Ücreti = {car.DailyPrice}\n");

            }

            Brand brand1 = new Brand()
            {
                BrandName = "F"
            };

            brandManager.Add(brand1);
            Console.WriteLine();

            Car car1 = new Car()
            {
                BrandId = 7,
                ColorId = 7,
                DailyPrice = -120,
                ModelYear = "2010",
                Descriptions = "Fiat Palio 1.6 Benzin & LPG Active Sole 75 HP"
            };

            carManager.Add(car1);

        }
    }
}
