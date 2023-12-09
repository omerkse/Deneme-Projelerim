import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    Scanner scn = new Scanner(System.in);
    Random rdn = new Random();

    int satirSayisi, sutunSayisi, boyut, sucsses = 0;
    int[][] harita;
    int[][] tahta;
    boolean oyun = true;

    public MayinTarlasi(int satirSayisi, int sutunSayisi) {
        this.satirSayisi = satirSayisi;
        this.sutunSayisi = sutunSayisi;
        this.harita = new int[satirSayisi][sutunSayisi];
        this.tahta = new int[satirSayisi][sutunSayisi];
        this.boyut = satirSayisi * sutunSayisi;
    }

    public void run() {
        oyunHazirlik();
        yazdir(harita); //(isteğe bağlı oyunda mayınların nerde oldugunu bilmek istiyorsanız yorum satırını kaldırınız)
        System.out.println();
        System.out.println("==Oyun Basladi==");
        while (oyun) {
            yazdir(tahta);
            System.out.print("Satir:");
            int satir = scn.nextInt();
            System.out.print("Sutun:");
            int sutun = scn.nextInt();
            if (harita[satir][sutun] != -1) {
                kontrol(satir, sutun);
                sucsses++;
                if (sucsses == (boyut - (boyut / 4))) {
                    yazdir(tahta);
                    System.out.println("Tebrikler Oyunu Kazandınız \n" +
                            "Tüm Mayinlar Basarili Bir Sekilde Temizlendi");
                    break;
                }
            } else {
                oyun = false;
                System.out.println("Game Over \n Mayina Bastiniz");
                yazdir(harita);
            }

        }
    }

    public void kontrol(int sat, int sut) {
        if (harita[sat][sut] == 0) {
            if ((sut < sutunSayisi - 1) && (harita[sat][sut + 1] == -1)) {
                tahta[sat][sut]++;
            }
            if ((sat < satirSayisi - 3) && (harita[sat + 1][sut] == -1)) {
                tahta[sat][sut]++;
            }
            if ((sat > 0) && (harita[sat - 1][sut] == -1)) {
                tahta[sat][sut]++;
            }
            if ((sut > 0) && (harita[sat][sut - 1] == -1)) {
                tahta[sat][sut]++;
            }
            if (tahta[sat][sut] == 0) {
                tahta[sat][sut] = -2;
            }
        }
    }

    public void oyunHazirlik() {
        int randomsatir, randomsutun, count = 0;
        while (count != (boyut / 4)) {
            randomsatir = rdn.nextInt(satirSayisi);
            randomsutun = rdn.nextInt(sutunSayisi);
            if (harita[randomsatir][randomsutun] != -1) {
                harita[randomsatir][randomsutun] = -1;
                count++;
            }
        }
    }

    public void yazdir(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
