using Business.Abstract;
using Business.Constants;
using Core.Utilities.Results;
using DataAccess.Abstract;
using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Text;

namespace Business.Concrete
{
    public class CustomerManager : ICustomerService
    {
        ICustomerDal _customerDal;
        public CustomerManager(ICustomerDal customerDal)
        {
            _customerDal = customerDal;
        }

        public IResult Add(Customer customer)
        {
            _customerDal.Add(customer);
            return new SuccessResult(Messages.CustomerAdded);
        }

        public IResult Delete(Customer customer)
        {
            if (_customerDal.Get(c => c.Id == c.Id) == null)
            {
                return new ErrorResult(Messages.CustomerNotFound);
            }
            _customerDal.Delete(customer);
            return new SuccessResult(Messages.CustomerDeleted);
        }

        public IDataResult<List<Customer>> GetAll()
        {
            return new SuccessDataResult<List<Customer>>(_customerDal.GetAll());
        }

        public IDataResult<Customer> GetById(int id)
        {
            if (_customerDal.Get(c => c.Id == c.Id) == null)
            {
                return new ErrorDataResult<Customer>(Messages.CustomerNotFound);
            }
            return new SuccessDataResult<Customer>(_customerDal.Get(c => c.Id == c.Id));
        }

        public IResult Update(Customer customer)
        {
            if (_customerDal.Get(c => c.Id == c.Id) == null)
            {
                return new ErrorResult(Messages.CustomerNotFound);
            }
            _customerDal.Update(customer);
            return new SuccessResult(Messages.CustomerUpdated);
        }

    }
}
