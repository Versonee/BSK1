
public class ColumnarCipherA implements Cipher{
    private final int n;
    private final int[] key;

    public ColumnarCipherA(int n, String key){
        this.n = n;
        key = removeSpaces(key);
        String[] stringNumbers = key.split("-");
        this.key = new int[n];
        for(int i=0; i<n; i++){
            this.key[i]=Integer.parseInt(stringNumbers[i]);
        }
    }

    public ColumnarCipherA(String key){
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
        int start=0,end=n,index=0;
        while(end<=data.length()){
            char[] line = data.substring(start,end).toCharArray();
            for(int k=0;k<n;k++){
                try{
                    encryptedData[index++] = line[key[k]-1];
                }catch(ArrayIndexOutOfBoundsException e){index--;}

            }
            start+=n;
            if(end==data.length()) break;
            if(end+n>data.length()) end = data.length();
            else end+=n;
        }
        return new String(encryptedData);
    }

    @Override
    public String decrypt(String data){
        data = removeSpaces(data);
        char[] decryptedData = new char[data.length()];
        int start=0,end=n,index=0;
        while(end<=data.length()){
            char[] line = data.substring(start,end).toCharArray();
            for(int k=0;k<n;k++){
                try{
                    decryptedData[index++] = line[getIndex(k+1)];
                }catch(ArrayIndexOutOfBoundsException e){index--;}

            }
            start+=n;
            if(end==data.length()) break;
            if(end+n>data.length()) end = data.length();
            else end+=n;
        }
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
