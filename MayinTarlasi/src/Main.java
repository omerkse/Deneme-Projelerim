import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int satirSayisi, sutunSayisi;

        System.out.println("===Mayin Tarlasi Oyununa Hosgeldiniz===");
        System.out.println();
        System.out.print("Mayin Tarlasinin Satir Sayisini Giriniz:");
        satirSayisi = scn.nextInt();
        System.out.print("Mayin Tarlasinin Sutun Sayisini Giriniz:");
        sutunSayisi = scn.nextInt();

        MayinTarlasi mayin = new MayinTarlasi(satirSayisi, sutunSayisi);
        mayin.run();


    }
}