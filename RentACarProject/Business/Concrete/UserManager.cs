using Business.Abstract;
using Business.Constants;
using Core.Utilities.Results;
using DataAccess.Abstract;
using DataAccess.Concrete.EntityFramework;
using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Text;

namespace Business.Concrete
{
    public class UserManager : IUserService
    {
        IUserDal _userDal;
        public UserManager(IUserDal userDal)
        {
            _userDal = userDal;
        }

        public IResult Add(User user)
        {
            _userDal.Add(user);
            return new SuccessResult(Messages.UserAdded);
        }

        public IResult Delete(User user)
        {
            if (_userDal.Get(u => u.Id == u.Id) == null)
            {
                return new ErrorResult(Messages.UserNotFound);
            }

            _userDal.Delete(user);
            return new SuccessResult(Messages.UserDeleted);
        }

        public IDataResult<List<User>> GetAll()
        {
            return new SuccessDataResult<List<User>>(_userDal.GetAll());
        }

        public IDataResult<User> GetById(int id)
        {
            var result = _userDal.Get(u => u.Id == u.Id);
            if (result != null)
            {
                return new SuccessDataResult<User>(_userDal.Get(u => u.Id == u.Id));
            }
            else
            {
                return new ErrorDataResult<User>(Messages.UserNotFound);
            }

            //if (_userDal.Get(u => u.Id == u.Id) == null)
            //{
            //    return new ErrorDataResult<User>(Messages.UserNotFound);
            //}
            //return new SuccessDataResult<User>(_userDal.Get(u => u.Id == u.Id));

        }

        public IResult Update(User user)
        {
            if (_userDal.Get(u => u.Id == u.Id) == null)
            {
                return new ErrorResult(Messages.UserNotFound);
            }
            _userDal.Update(user);
            return new SuccessResult(Messages.UserUpdated);
        }

    }
}
