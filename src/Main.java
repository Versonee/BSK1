public class Main {
    public static void main(String[] args){

        RailFenceCipher rfc = new RailFenceCipher(3);
        System.out.println(rfc.encrypt("CRYPTOGRAPHY"));
        System.out.println(rfc.decrypt("CTARPORPYYGH"));

//        ColumnarCipherA cc = new ColumnarCipherA(4, "3-1-4-2");
//        System.out.println(cc.encrypt("CRYPTOGRAPHYOSA"));
//        System.out.println(cc.decrypt("YCPRGTROHAYPAOS"));

//        ColumnarCipherA cc = new ColumnarCipherA("CONVENIENCE");
//        System.out.println(cc.encrypt("HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION"));
//        System.out.println(cc.decrypt("HCARRSSEEEIEEANMGSEETSCYETPDRHBIERISONIOSTAPN"));

//        ColumnarCipherB ccb = new ColumnarCipherB("CONVENIENCE");
//        System.out.println(ccb.encrypt("here is a secret message enciphered by transposition"));
//        System.out.println(ccb.decrypt("heespnirrscbtaemgepneiyandiieeroctrtahsossees"));

//        CaesarCipher caesarCipher = new CaesarCipher(3);
//        System.out.println(caesarCipher.encrypt("wiadomosc do zaszyfrowania"));
//        System.out.println(caesarCipher.decrypt("zldgrprvf gr cdvcbiurzdqld"));

//        VigenereCipher vc = new VigenereCipher();
//        System.out.println(vc.encrypt("CRYPTOGRAPHY", "BREAKBREAKBR"));
//        System.out.println(vc.decrypt("DICPDPXVAZIP", "BREAKBREAKBR"));

    }
}