--Select 
--ANSII
Select ContactName Adi,CompanyName Sirketadi,City Sehir from Customers

Select * from Customers where City = 'Berlin'

--case insensitive
Select * from Products where CategoryID=1 or CategoryID=3

Select * from Products where CategoryID=1 and UnitPrice>=10

Select * from Products where CategoryID=1 order by UnitPrice desc --ascending asc artan --descending desc düşen

Select count (*) Adet from Products where CategoryID=2 --products tablosundaki toplam ürün sayısını verir.

Select count (*) Adet from Products 

Select CategoryID, count(*) from Products where UnitPrice>20 group by CategoryID having count(*)<10 --bütün kategorileri bana tekrar etmeden adetleriyle listele.

--Sadece iki tabloda eşlesenleri bir araya getirmemizi sağlar. "inner join" sağda da solda da var denebilir.
--DTO Data Transformation Object
Select Products.ProductID,Products.ProductName,Products.UnitPrice,Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID
where Products.UnitPrice>10

--Köşeli parantez tablo ismi alsın diye.
--left join solda olup sağda olmayanlarıda getirir.ürünler tablosunda var satış da yok gibi.solda oluğ sağda olamayanlarıda getir denebilir.
Select * from Products p left join [Order Details] od on p.ProductID = od.ProductID
inner join Orders o on o.OrderID = od.OrderID

--Boş olan kısımları çağırmak için "is null" yazılır.
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID
where o.CustomerID is null --null demek o data yok demektir.
