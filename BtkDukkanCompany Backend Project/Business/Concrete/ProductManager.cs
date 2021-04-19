using Business.Abstract;
using Core.Utilities.Results;
using DataAccess.Abstract;
using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Text;

namespace Business.Concrete
{
    public class ProductManager : IProductService
    {
        IProductDal _productDal;

        public ProductManager(IProductDal productDal)
        {
            _productDal = productDal;
        }

        public IResult Add(Product product)
        {
            //İş Kuralları Bulunur.

            if (product.CategoryId == 1)
            {
                return new ErrorResult("Bu Kategoriye Ürün Kabul Edilmiyor!");
            }
            else
            {
                _productDal.Add(product);
                return new SuccessResult("Ürün Eklendi!");
            }

        }

        public IDataResult<List<Product>> GetAll()
        {
            return new SuccessDataResult<List<Product>>(_productDal.GetAll(), "Ürünler Listelendi");

        }

        public IDataResult<List<Product>> GetAllByCategory(int categoryId)
        {
            return new SuccessDataResult<List<Product>>
                (_productDal.GetAll(p => p.CategoryId == categoryId),
                "Ürünler Listelendi");
        }
    }
}
