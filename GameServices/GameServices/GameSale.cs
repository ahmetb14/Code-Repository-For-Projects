using System;
using System.Collections.Generic;
using System.Text;

namespace GameServices
{
    public class GameSale : ICampaign
    {
        public void CampaignAdd()
        {
            Console.WriteLine("Bir adet oyun alana diğer oyun alımında %25 indirim fırsatı!");
        }

        public void CampaignDelete()
        {
            Console.WriteLine("Kayıtlı kampanya silindi!");
        }

        public void CampaignUpdate()
        {
            Console.WriteLine("Bu oyunu alana oyun içi özel eşyalar ücretsiz hediyedir!");
        }

    }
}
