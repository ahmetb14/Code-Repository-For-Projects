using Business.Abstract;
using Business.BusinessAspects.Autofac;
using Business.Constants;
using Business.ValidationRules.FluentValidation;
using Core.Aspects.Autofac.Caching;
using Core.Aspects.Validation;
using Core.Utilities.Results;
using DataAccess.Abstract;
using DataAccess.Concrete.EntityFramework;
using Entities.Concrete;
using Entities.DTOs;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;

namespace Business.Concrete
{
    public class RentalManager : IRentalService
    {
        IRentalDal _rentalDal;
        public RentalManager(IRentalDal rentalDal)
        {
            _rentalDal = rentalDal;
        }

        [ValidationAspect(typeof(RentalValidator))]
        public IResult Add(Rental rental)
        {
            var carRentalList = _rentalDal.GetAll(r => r.Id == r.Id);
            _rentalDal.Add(rental);
            return new SuccessResult(Messages.RentalAdded);
        }

        public IResult Delete(Rental rental)
        {
            if (_rentalDal.Get(r => r.Id == r.Id) == null)
            {
                return new ErrorResult(Messages.RentalNotFound);
            }
            _rentalDal.Delete(rental);
            return new SuccessResult(Messages.RentalDeleted);
        }

        public IDataResult<List<Rental>> GetAll()
        {
            return new SuccessDataResult<List<Rental>>(_rentalDal.GetAll(), Messages.RentalListed);
        }

        

        public IDataResult<Rental> GetById(int id)
        {
            var rental = _rentalDal.Get(r => r.Id == r.Id);
            if (rental == null)
            {
                return new ErrorDataResult<Rental>(Messages.RentalNotFound);
            }
            return new SuccessDataResult<Rental>(rental, Messages.DesiredListed);
        }

        public IDataResult<List<RentalDetailDto>> GetRentalDetails()
        {
            return new SuccessDataResult<List<RentalDetailDto>>(_rentalDal.GetRentalDetails(), Messages.DesiredListed);
        }

        public IResult Update(Rental rental)
        {
            if (_rentalDal.Get(r => r.Id == r.Id) == null)
            {
                return new ErrorResult(Messages.RentalNotFound);
            }
            _rentalDal.Update(rental);
            return new SuccessResult(Messages.RentalUpdated);
        }
    }

}
