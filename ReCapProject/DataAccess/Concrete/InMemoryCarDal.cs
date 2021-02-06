using DataAccess.Abstract;
using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DataAccess.Concrete
{
    public class InMemoryCarDal : ICarDal
    {
        public List<Car> _cars;

        public InMemoryCarDal()
        {
            _cars = new List<Car>()
            {
                new Car {Id=1,BrandId=1,ColorId=1,ModelYear="2021",DailyPrice=900000,Description="BMW 320i 1.6 Benzin First Edition M Sport 170 Hp"},
                new Car {Id=2,BrandId=1,ColorId=1,ModelYear="2021",DailyPrice=829000,Description="Audi A5 Sportback 2.0 Dizel Quattro Sport 190 Hp"},
                new Car {Id=3,BrandId=1,ColorId=1,ModelYear="2021",DailyPrice=338000,Description="Toyota Corolla 1.5 Bezin Passion X-Pack Multidrive S"},
                new Car {Id=4,BrandId=1,ColorId=1,ModelYear="2010",DailyPrice=168000,Description="Opel Insignia 2.0 Dizel Sports Tourer Cosmo 160 Hp"},
                new Car {Id=5,BrandId=1,ColorId=1,ModelYear="2008",DailyPrice=115000,Description="Opel Vectra 1.6 Benzin & LPG Comfort 105 Hp"},
                new Car {Id=6,BrandId=1,ColorId=1,ModelYear="2005",DailyPrice=78000,Description="Opel Astra 1.6 Benzin & LGP Classic 100 Hp"}
            };
        }

        public void Add(Car car)
        {
            _cars.Add(car);
        }

        public void Delete(Car car)
        {
            var carToDelete = _cars.SingleOrDefault(c => c.Id == car.Id);
            _cars.Remove(carToDelete);
        }

        public List<Car> GetAll()
        {
            return _cars;
        }

        public Car GetById(int id)
        {
            return _cars.SingleOrDefault(c => c.Id == id);
        }

        public void Update(Car car)
        {
            var carToUpdate = _cars.SingleOrDefault(c => c.Id == car.Id);
            carToUpdate.BrandId = car.BrandId;
            carToUpdate.ColorId = car.ColorId;
            carToUpdate.ModelYear = car.ModelYear;
            carToUpdate.Description = car.Description;
        }
    }
}
