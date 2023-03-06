package com.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.*;

public class CatatanKeuangan {


    public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
        initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locator
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement izin;
    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement btnIcontambah;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnPemasukan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDate")
    private MobileElement dateMasuk;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"23 Maret 2023\"]")
    private MobileElement date;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"25 Maret 2023\"]")
    private MobileElement date2;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okDate;
    @AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
    private MobileElement selectKategori;
    @AndroidFindBy(className = "android.widget.LinearLayout")
    private MobileElement select;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[9]/android.widget.LinearLayout")
    private MobileElement select2;
    @AndroidFindBy(id = "com.chad.financialrecord:id/ibCalc")
    private MobileElement btnKalkulator;
    @AndroidFindBy(id = "com.chad.financialrecord:id/calc_btn_23")
    private MobileElement two;
    @AndroidFindBy(id = "com.chad.financialrecord:id/calc_btn_33")
    private MobileElement three;
    @AndroidFindBy(id = "com.chad.financialrecord:id/calc_btn_24")
    private MobileElement zero;
    @AndroidFindBy(id = "com.chad.financialrecord:id/calc_btn_add")
    private MobileElement add;
    @AndroidFindBy(id = "com.chad.financialrecord:id/calc_btn_ok")
    private MobileElement btnOk;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement keterangan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSimpan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvIncome")
    private MobileElement resultPemasukan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvExpense")
    private MobileElement resultPengeluaran;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tvBalance")
    private MobileElement resultSaldo;

    //Method pengulangan klik angka 0 pada kalkulator
    public void ulang(int digit) {
        for (int i = 0; i <= digit; i++) {
            zero.click();
        }
    }

    //Method save pemasukan
    public void savePemasukan() {
        delayDuration(1);
        izin.click();
        System.out.println("Klik jangan izin untuk akses media : sudah");
        btnIcontambah.click();
        System.out.println("Tambahkan pemasukan : sudah");
        btnPemasukan.click();
        System.out.println("Masuk ke halaman pemasukan : sudah");
        dateMasuk.click();
        date.click();
        okDate.click();
        System.out.println("Masukan tanggal: sudah");
        selectKategori.click();
        select.click();
        System.out.println("Select kategori : sudah");
        btnKalkulator.click();
        System.out.println();
        two.click();
        ulang(3);
        add.click();
        three.click();
        ulang(3);
        btnOk.click();
        btnOk.click();
        System.out.println("Masukan nominal : sudah");
        keterangan.sendKeys("Uang Tambahan");
        System.out.println("Masukan keterangan : sudah");
        btnSimpan.click();
        System.out.println("Klik simpan : sudah");
    }

    //Method save pengeluaran
    public void savePengeluaran() {
        delayDuration(1);
        btnIcontambah.click();
        System.out.println("Tambahkan pengeluaran : sudah");
        dateMasuk.click();
        date2.click();
        okDate.click();
        System.out.println("Masukan tanggal: sudah");
        selectKategori.click();
        select2.click();
        System.out.println("Select kategori : sudah");
        btnKalkulator.click();
        System.out.println();
        two.click();
        ulang(2);
        btnOk.click();
        System.out.println("Masukan nominal : sudah");
        keterangan.sendKeys("Beli rokok");
        System.out.println("Masukan keterangan : sudah");
        btnSimpan.click();
        System.out.println("Klik simpan : sudah");
    }

    //result text final
    public String textResultPemasukan() {
        return resultPemasukan.getText();
    }

    public String textResultPengeluaran() {
        return resultPengeluaran.getText();
    }

    public String textResultSaldo() {
        return resultSaldo.getText();
    }

    //Method delay
    public static void delayDuration(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
