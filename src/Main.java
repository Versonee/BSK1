public class Main {
    public static void main(String[] args){

        //POLITECHNIKA
        //DZIEKAN

//        RailFenceCipher rfc = new RailFenceCipher(3);
//        System.out.println(rfc.encrypt("POLITECHNIKA"));
//        System.out.println(rfc.decrypt("PTNOIEHIALCK"));

//        ColumnarCipherA cc = new ColumnarCipherA(4, "3-1-4-2");
//        System.out.println(cc.encrypt("POLITECHNIKA"));
//        System.out.println(cc.decrypt("LPIOCTHEKNAI"));


//        do poprawki - poprawione
//        ColumnarCipherA cc = new ColumnarCipherA("DZIEKAN");
//        System.out.println(cc.encrypt("POLITECHNIKA"));
//        System.out.println(cc.decrypt("EPILTCOHKIAN"));


//        do poprawki - poprawione
        ColumnarCipherB ccb = new ColumnarCipherB("DZIEKAN");
        System.out.println(ccb.encrypt("POLITECHNIKA"));
        System.out.println(ccb.decrypt("EPCHAIKLITON"));

//        CaesarCipher caesarCipher = new CaesarCipher(3);
//        System.out.println(caesarCipher.encrypt("POLITECHNIKA"));
//        System.out.println(caesarCipher.decrypt("SROLWHFKQLND"));

//        VigenereCipher vc = new VigenereCipher();
//        System.out.println(vc.encrypt("POLITECHNIKA", "DZIEKAN"));
//        System.out.println(vc.decrypt("SNTMDEPKMQOK", "DZIEKAN"));

    }
}