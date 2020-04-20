package queryBuilder;

import queryBuilder.Database;

public class test {
    public static void main(String[] args) {
        Database db = new Database();
        String[][] data = {
                {"judul", "pengarang"},
                {"No Mans Sky","gedece"}
        };

        String[][] dataUpdate = {
                {"judul", "Guuuede"},
                {"pengarang", "wewe"}
        };

        db.insert("buku").field(data[0]).value(data[1]).println();
        db.select("buku").field("pengarang,judul").where("id",1).println();
        db.update("buku").set(dataUpdate).where("id", 1).println();
        db.delete("buku").where("id",1).println();
//
//        if (db.insert("buku").data(data).exec()) {
//            System.out.println("Sukses");
//        } else {
//            System.out.println("Gagal");
//        }
//
//        if (db.update("buku").set(dataUpdate).where("id", 1).exec()) {
//            System.out.println("Sukses");
//        } else {
//            System.out.println("Gagal");
//        }
    }
}
