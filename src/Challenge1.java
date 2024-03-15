import java.util.ArrayList;
import java.util.Scanner;

public class Challenge1 {
    public static final String[] menu = {"Nasi Goreng", "Mie Goreng", "Nasi Ayam Goreng", "Es Teh Manis", "Es Jeruk"};
    public static final Integer[] harga = {15000, 13000, 18000, 3000, 5000};

    public static void main(String[] args) {
        tampilanMenu(menu, harga);
        System.out.println();

        ArrayList<String> selected = pilihMakanan(menu, harga);
        System.out.println();

        confirmPay(selected);
        lastOpsi(selected, menu, harga);
        System.out.println(selected);
    }

    public static void tampilanMenu(String[] menu, Integer[] harga) {
        System.out.println("==========================\n" +
                "Selamat datang di BinarFud\n" +
                "==========================\n" +
                "Silahkan pilih makanan :");
        for (int i = 0; i < menu.length && i < harga.length; i++){
            System.out.println((i+1) + ". " + menu[i] + " | " + harga[i]);
        }
        System.out.println("99. " + "Pesan dan Bayar");
        System.out.println("0. " + "Keluar Aplikasi");
    }

    public static ArrayList<String> pilihMakanan(String[] menu, Integer[] harga){
        //create Array for menu selected
        ArrayList<String> selected = new ArrayList<>();

        //memilih menu
        Scanner selectMenu = new Scanner(System.in);
        System.out.print("Pilih menu anda : ");
        int select = selectMenu.nextInt();

        System.out.println();

        //mengisi jumlah menu yang dipesan
        Scanner qtyMenu = new Scanner(System.in);
        System.out.println("==========================\n" +
                "Berapa pesanan anda\n" +
                "==========================\n");

        System.out.print("Jumlah pesanan : ");


        int qty = qtyMenu.nextInt();

        if (select >= 1 && select <= menu.length){
            selected.add(menu[select-1]);
            selected.add(String.valueOf(qty));
            selected.add(String.valueOf(harga[select-1]));
        } else if (select == 99){
            System.out.println("test");
        } else if (select == 0) {
            System.out.println("keluar");
        }

        System.out.println();

        return selected;

    }


    public static ArrayList confirmPay(ArrayList selected){
        //nota sementara
        System.out.println("==========================\n" +
                "Nota sementara\n" +
                "==========================");
        for (Object item : selected){
            System.out.print(item + " ");
        }

        System.out.println();
        System.out.println("-------------------------+\n" +
                "Total " + selected.get(1) + " " + selected.get(2));

        System.out.println();

        System.out.println("1." + " Konfirmasi & Bayar\n" +
                "2." + " Kembali ke menu\n" +
                "0." + " Keluar aplikasi");

        return selected;
    }

    public static ArrayList lastOpsi (ArrayList selected, String[] menu, Integer[] harga){
        Scanner opsi = new Scanner(System.in);
        System.out.print("opsi : ");
        int inputOpsi = opsi.nextInt();
        if (inputOpsi == 1){
            System.out.println("bayar");
        } else if (inputOpsi == 2){
            tampilanMenu(menu, harga);
            pilihMakanan(menu, harga);
            confirmPay(selected);
        } else if (inputOpsi == 0){
            System.out.println("keluar");
        }
        return selected;
    }

}
