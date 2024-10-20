import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        System.out.println("Daftar Barang:");
        double total = 0.0;
        for (Item item : items) {
            double subTotal = item.getSubTotal();
            System.out.println("Kode: " + item.getCode());
            System.out.println("Nama: " + item.getName());
            System.out.println("Harga: " + item.getPrice());
            System.out.println("Jumlah: " + item.getQuantity());
            System.out.println("Subtotal: " + subTotal);
            total += subTotal;
        }
        System.out.println("========================================");
        System.out.println("Total belanja: " + total);
    }

    public void processPayment(double amountPaid) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getSubTotal();
        }

        if (amountPaid >= total) {
            double change = amountPaid - total;
            System.out.println("Pembayaran berhasil.");
            System.out.println("Kembalian: " + change);
        } else {
            System.out.println("Uang tidak cukup. Silakan bayar sesuai atau lebih dari total.");
        }
    }
}