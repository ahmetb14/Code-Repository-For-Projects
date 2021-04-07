using Core.DataAccess.EntityFramework;
using DataAccess.Abstract;
using Entities.Concrete;
using Entities.DTOs;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;

namespace DataAccess.Concrete.EntityFramework
{
    public class EfRentalDal : EfEntityRepositoryBase<Rental, RentACarDbContext>, IRentalDal
    {
        public List<RentalDetailDto> GetRentalDetails(Expression<Func<Rental, bool>> filter = null)
        {
            using (RentACarDbContext context = new RentACarDbContext())
            {
                var result = from r in filter == null ? context.Rentals : context.Rentals.Where(filter)
                             join v in context.Cars
                             on r.CarId equals v.Id
                             join c in context.Customers
                             on r.CustomerId equals c.Id
                             join b in context.Brands
                             on v.BrandId equals b.Id

                             select new RentalDetailDto
                             {
                                 Id = r.Id,
                                 CarName = b.BrandName,
                                 CustomerName = c.CompanyName,
                                 RentDate = r.RentDate,
                                 ReturnDate = r.ReturnDate
                             };

                return result.ToList();
            }
        }
    }

}
