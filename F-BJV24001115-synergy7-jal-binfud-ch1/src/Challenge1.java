import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge1 {
    public static final String[] menu = {"Nasi Goreng", "Mie Goreng", "Nasi + Ayam", "Es Teh Manis", "Es Jeruk   "};
    public static final Integer[] harga = {15000, 13000, 18000, 3000, 5000};
    public static void main(String[] args) {
        ArrayList<Object[]> selected = new ArrayList<>();
        pilihMakanan(menu, harga, selected);
        System.out.println();

        confirmPay(selected);
        lastOpsi(selected, menu, harga);
    }
    public static void tampilanMenu(String[] menu, Integer[] harga) {
        System.out.println("==========================\n" +
                "Selamat datang di BinarFud\n" +
                "==========================\n" +
                "Silahkan pilih makanan :");
        for (int i = 0; i < menu.length && i < harga.length; i++){
            System.out.println((i+1) + ". " + menu[i] + "\t".repeat(1) + " | " + harga[i]);
        }
        System.out.println("99. " + "Pesan dan Bayar");
        System.out.println("0. " + "Keluar Aplikasi");
    }

    public static void pilihMakanan(String[] menu, Integer[] harga, ArrayList<Object[]> selected){
        tampilanMenu(menu, harga);
        //memilih menu
        Scanner selectMenu = new Scanner(System.in);
        System.out.print("Pilih menu anda => ");
        int     select = selectMenu.nextInt();

        System.out.println();
        if (select >= 1 && select <= menu.length){
            //mengisi jumlah menu yang dipesan
            Scanner qtyMenu = new Scanner(System.in);
            System.out.println("==========================\n" +
                    "Berapa pesanan anda\n" +
                    "==========================\n");

            System.out.println(menu[select-1] + "\t" + " | " + "\t" + harga[select-1]);

            System.out.print("Jumlah pesanan => ");
            int qty = qtyMenu.nextInt();
            if (qty != 0){
                selected.add(new Object[]{menu[select-1], qty, harga[select-1]});
            } else {
                tampilanMenu(menu, harga);
                pilihMakanan(menu, harga, selected);
            }
        } else if (select == 99){
            System.out.println("PILIH MENU DULU");
            pilihMakanan(menu, harga, selected);
        } else if (select == 0) {
            System.exit(1);
        }

    }

    public static void confirmPay(ArrayList<Object[]> selected){
        System.out.println("==========================\n" +
                "Konfirmasi & Pembayaran\n" +
                "==========================");
        int totalHarga = 0;
        for (Object[] item : selected){
            System.out.println(item[0] + "\t".repeat(2) + item[1] + " " + "\t" + item[2]);
            totalHarga += (int) item[1] * (int) item[2];
        }
        int totalQty = 0;
        for (Object[] qty : selected){
            totalQty += (int) qty[1];
        }
        System.out.println("-------------------------+\n" +
                "Total: " + "\t".repeat(3) + totalQty + " " + "\t" + totalHarga);
        System.out.println();
        System.out.println("1." + " Konfirmasi & Bayar\n" +
                "2." + " Kembali ke menu\n" +
                "0." + " Keluar aplikasi");
    }

    public static void lastOpsi(ArrayList<Object[]> selected, String[] menu, Integer[] harga){
        Scanner opsi = new Scanner(System.in);
        System.out.print("opsi : ");
        int inputOpsi = opsi.nextInt();
        if (inputOpsi == 1){
            strukPembayaran(selected);
        } else if (inputOpsi == 2){
            pilihMakanan(menu, harga, selected);
            confirmPay(selected);
            lastOpsi(selected, menu, harga);
        } else if (inputOpsi == 0) {
            System.exit(1);
        }
    }

    public static void strukPembayaran(ArrayList<Object[]> selected){
        try {
            FileWriter writer = new FileWriter("strukPembayaran.txt");
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("===============================\n" +
                    "BinarFud\n" +
                    "===============================\n");
            bwr.write("Terima kasih sudah memesan \ndi BinarFud\n" + "\n");
            bwr.write("Dibawah ini adalah pesanan anda\n" + "\n");
            int totalHarga = 0;
            for (Object[] pesanan : selected){
                bwr.write(pesanan[0] + " " + "\t".repeat(2) + pesanan[1] + " " + "\t" + pesanan[2] + "\n");
                totalHarga += (int) pesanan[1] * (int) pesanan[2];
            }
            int totalQty = 0;
            for (Object[] qty : selected){
                totalQty += (int) qty[1];
            }
            bwr.write("------------------------------+\n" +
                    "Total: " + "\t".repeat(4) + totalQty + " " + "\t" + totalHarga + "\n\n");
            bwr.write("Pembayaran : " + "BinarCash" + "\n");
            bwr.write("===============================\n" +
                    "Simpan struk ini sebagai \nbukti pembayaran\n" +
                    "===============================");
            bwr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

