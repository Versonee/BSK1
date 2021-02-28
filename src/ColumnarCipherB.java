import java.util.LinkedList;

public class ColumnarCipherB implements Cipher{
    private final int n;
    private final int[] key;


    public ColumnarCipherB(String key){
        key = removeSpaces(key);
        this.n = key.length();
        this.key =new int[n];
        char[] stringNumbers = key.toCharArray();
        int[] keyNumbers = new int[stringNumbers.length];
        for(int i = 0; i<stringNumbers.length;i++){
            keyNumbers[i] = (int)stringNumbers[i];
        }
        int index = 1;
        while(index<=n){
            int min = getMinValue(keyNumbers);
            for(int i = 0; i<keyNumbers.length;i++){
                if(keyNumbers[i] == min) {
                    this.key[i] = index++;
                    keyNumbers[i] = Integer.MAX_VALUE;
                }
            }
        }
    }

    @Override
    public String encrypt(String data){
        data = removeSpaces(data);
        char[] encryptedData = new char[data.length()];
        LinkedList<Character> list = new LinkedList<Character>();
        LinkedList<Character>[] matrix = new LinkedList[n];
        return new String(encryptedData);
    }

    @Override
    public String decrypt(String data){
        data = removeSpaces(data);
        char[] decryptedData = new char[data.length()];

        return new String(decryptedData);
    }

    private int getIndex(int value) {
        int index = 0;
        for(int i : key){
            if(i==value) return index;
            index++;
        }
        return -1;
    }

    private int getMinValue(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<array.length; i++){
            if(min>array[i]) min = array[i];
        }
        return min;
    }

    private String removeSpaces(String data) {
        char[] arrayData = data.toCharArray();
        char[] dataWithoutSpaces = new char[data.length()];
        int index=0;
        for(int i = 0; i<data.length();i++){
            if(arrayData[i]==' '){}
            else{
                dataWithoutSpaces[index++]= arrayData[i];
            }
        }
        return new String(dataWithoutSpaces);
    }
}
