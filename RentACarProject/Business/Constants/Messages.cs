using Entities.Concrete;
using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text;

namespace Business.Constants
{
    public static class Messages
    {
        public static string CarAdded = "Araba Eklendi!";
        public static string DailyPriceInvalid = "Arabanın Kiralama Ücreti '0' Değerinden Büyük Olmalıdır!";
        public static string CarDeleted = "Araba Silindi!";
        public static string CarUpdated = "Araba Güncellendi!";
        public static string MaintenanceTime = "Sistem Bakımdadır Lütfen Daha Sonra Tekrar Deneyiniz!";
        public static string CarsListed = "Arabalar Listelendi!";
        public static string BrandAdded = "Marka Eklendi!";
        public static string BrandNameInvalid = "Marka Adı En Az '2' Karakter Olmalıdır!";
        public static string BrandDeleted = "Marka Silindi!";
        public static string BrandUpdated = "Marka Güncellendi!";
        public static string BrandsListed = "Markalar Listelendi!";
        public static string ColorAdded = "Renk Eklendi!";
        public static string ColorDeleted = "Renk Silindi!";
        public static string ColorUpdated = "Renk Güncellendi!";
        public static string ColorsListed = "Renkler Listelendi!";
        public static string CustomerDeleted = "Müşteri Silindi!";
        public static string CustomerAdded = "Müşteri Eklendi!";
        public static string CustomerNotFound = "Müşteri Bulunamadı!";
        public static string CustomerUpdated = "Müşteri Güncellendi!";
        public static string RentalAdded = "Kiralama Eklendi";
        public static string RentalNotFound = "Kiralama Bulunamadı!";
        public static string RentalDeleted = "Kiralama Silindi!";
        public static string RentalUpdated = "Kiralama Güncellendi!";
        public static string UserAdded = "Kullanıcı Eklendi!";
        public static string UserNotFound = "Kullanıcı Bulunamadı!";
        public static string UserDeleted = "Kullanıcı Silindi!";
        public static string UserUpdated = "Kullanıcı Güncellendi!";
        public static string CustomerListed = "Müşteriler Listelendi!";
        public static string DesiredListed = "İstenilenler Listelendi!";
        public static string UserListed = "Kullanıcılar Listelendi!";
        public static string RentalListed = "Kiralamalar Listelendi";
        public static string CarImagesAdded = "Kiralamalar Listelendi";
        public static string CarImageLimit = "Kiralamalar Listelendi";
        public static string CarImageListed = "Araba Resimleri Listelendi!";
        public static string CarImageGetAll = "Tüm Araba Resimleri Getirildi!";
        public static string AuthorizationDenied = "Yetkilendirme Reddedildi!";
        public static string UserRegistered = "Kullanıcı Kayıt Edildi!";
        public static string PasswordError = "Şifre Hatalı!";
        public static string SuccessfulLogin = "Giriş Başarılı!";
        public static string UserAlreadyExists = "Kullanıcı Zaten Ekli!";
        public static string CarNameInvalid = "Araba Adı Doğrulanamadı!";
        public static string AccessTokenCreated = "Token Oluşturuldu!";

    }
}
