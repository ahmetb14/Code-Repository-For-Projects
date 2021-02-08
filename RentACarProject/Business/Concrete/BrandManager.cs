using Business.Abstract;
using DataAccess.Abstract;
using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Text;

namespace Business.Concrete
{
    public class BrandManager : IBrandService
    {
        IBrandDal _brandDal;

        public BrandManager(IBrandDal brandDal)
        {
            _brandDal = brandDal;
        }

        public void Add(Brand brand)
        {
            if (brand.BrandName.Length >= 2)
            {
                _brandDal.Add(brand);
                Console.WriteLine("Seçilen Araba Marka İsmi Başarıyla Eklendi!");
            }
            else
            {
                Console.WriteLine("Araba'nın İsmi En Az 2 Karakter Olması Gerekmekte!");
            }
        }

        public void Delete(Brand brand)
        {
            _brandDal.Delete(brand);
            Console.WriteLine("Seçilen Araba Marka İsmi Başarıyla Silindi!");
        }

        public List<Brand> GetAll()
        {
            Console.WriteLine("Kayıtlı Tüm Araba Markaları: ");
            return _brandDal.GetAll();
        }

        public Brand GetById(int id)
        {
            return _brandDal.Get(b => b.Id == id);
        }

        public void Update(Brand brand)
        {
            _brandDal.Update(brand);
            Console.WriteLine("Seçilen Araba Marka İsmi Başarıyla Güncellendi!");
        }
    }
}
