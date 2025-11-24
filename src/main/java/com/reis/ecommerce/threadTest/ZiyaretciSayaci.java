package com.reis.ecommerce.threadTest;

public class ZiyaretciSayaci
{
  private int sayi = 0;

  //Yöntemm 1 : 'synchronized' Anahtar kelimesi
  //Bu metoda aynı anda sadece 1 thread girebilir.
  //Biri bitirmeden diğeri giremez

  public synchronized void arttir(){
    sayi++;
  }

  // Okuma yaparken de veri tutarlılığı için synchronized kullanabilirz
  //ama sadece yazma işlemi kritikse oraya koymak yeterlidir.
  public int getSayi(){
    return sayi;
  }

}
