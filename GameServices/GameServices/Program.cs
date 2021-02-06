using System;

namespace GameServices
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomerInformation customerInformation = new CustomerInformation()
            {
                Id = 1,
                TcNo = "7894561478945",
                FirstName = "Ahmet",
                LastName = "Yılmaz",
                Age = 19
            };

            PersonValidation personValidation = new PersonValidation(customerInformation);
            if (personValidation.status == true)
            {
                GameSale gameSale = new GameSale();
                gameSale.CampaignAdd();
            }

            Console.WriteLine("--------------------------------------");
            GameSale gameSale1 = new GameSale();
            gameSale1.CampaignDelete();

            Console.WriteLine("--------------------------------------");
            GameSale gameSale2 = new GameSale();
            gameSale2.CampaignUpdate();

            Console.WriteLine("--------------------------------------");
            Gamer gamer1 = new Gamer();
            gamer1.Add();

            Console.WriteLine("**************************************");
            Gamer gamer2 = new Gamer();
            gamer2.Delete();

            Console.WriteLine("**************************************");
            Gamer gamer3 = new Gamer();
            gamer2.Update();

            Console.WriteLine(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Console.WriteLine("Bu kısım inceleyenleri bilgilendirmek adına eklenmiştir bu metnin üstündeki operasyonların aktif çalıştığını vurgulamak için yazılmıştır.");

            Console.ReadKey(true);

        }
    }
}
