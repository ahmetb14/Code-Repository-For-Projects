using System;
using System.Collections.Generic;
using System.Text;

namespace Core.Utilities.Results
{
    //T'ye Kısıtlama Koymuyoruz Çünkü Her Şey Olabilir!
    public interface IDataResult<T> : IResult
    {
        T Data { get; }

    }
}
