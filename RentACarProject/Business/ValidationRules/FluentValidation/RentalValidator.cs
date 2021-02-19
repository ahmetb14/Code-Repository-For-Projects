using Entities.Concrete;
using FluentValidation;
using System;
using System.Collections.Generic;
using System.Text;

namespace Business.ValidationRules.FluentValidation
{
    public class RentalValidator : AbstractValidator<Rental>
    {
        public RentalValidator()
        {
            RuleFor(r => r.CarId).NotEmpty();
            RuleFor(r => r.CustomerId).NotEmpty();
            RuleFor(r => r.RentDate).NotEmpty();
            RuleFor(r => r.RentDate).Must(DeliveryDate).WithMessage("Girilen Tarih Bügünün Tarihinden Küçük Olmamalı!");
            RuleFor(r => r.ReturnDate).NotEmpty();
            RuleFor(r => r.ReturnDate).Must(RentalDate).WithMessage("Girilen Tarih Bügünün Tarihinden Büyük Olmalı!");

        }

        private bool DeliveryDate(DateTime arg)
        {
            return arg.Date >= DateTime.Today;
        }

        private bool RentalDate(DateTime arg)
        {
            return arg.Date > DateTime.Now;
        }
    }
}
