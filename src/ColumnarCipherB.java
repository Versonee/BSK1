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
        char[][] matrix = populateMatrixWithData(data, DataType.DATA_DECRYPTED);
        int index=0,maxCharToEncrypt=0;
        boolean split=false;
        for(int k=1;k<key.length;k++){
            maxCharToEncrypt+=getIndex(k)+1;
        }
        if(maxCharToEncrypt<data.length()) split =true;
        if(split){
            String part1 = data.substring(0,data.length()/2);
            String part2 = data.substring(data.length()/2);
            return encrypt(part1) + encrypt(part2);
        }else{
            for(int i=0;i<key.length;i++){
                int columnIndex = getIndex(i+1);
                for(int j=0; j<n;j++){
                    if(matrix[j][columnIndex] == '\u0000'){}
                    else{
                        encryptedData[index++] = matrix[j][columnIndex];
                    }
                }
            }
            return new String(encryptedData);
        }
    }

    @Override
    public String decrypt(String data){
        data = removeSpaces(data);
        char[] decryptedData = new char[data.length()];
        char[][] matrix = populateMatrixWithData(data, DataType.DATA_ENCRYPTED);
        int index = 0,maxCharToDecrypt=0;
        boolean split=false;
        for(int k=1;k<key.length;k++){
            maxCharToDecrypt+=getIndex(k)+1;
        }
        if(maxCharToDecrypt<data.length()) split =true;
        if(split){
            String part1 = data.substring(0,data.length()/2);
            String part2 = data.substring(data.length()/2);
            return decrypt(part1) + decrypt(part2);
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j] == '\u0000') break;
                    decryptedData[index++] = matrix[i][j];
                }
            }
            return new String(decryptedData);
        }
    }

    private char[][] populateMatrixWithData(String data, DataType type){
        char[][] matrix = new char[n][n];
        char[] arrayData = data.toCharArray();
        int index = 0;
        if(type == DataType.DATA_DECRYPTED){
            for(int k=0;k<key.length;k++){
                int letterCountInRow = getIndex(k+1)+1;
                for(int i=0; i<letterCountInRow;i++){
                    if(arrayData.length>index){
                        matrix[k][i] = arrayData[index++];
                    }else{
                        break;
                    }
                }
            }
        }
        if(type == DataType.DATA_ENCRYPTED){
            int height=0;
            int maxCharToEncrypt=0;
            int charactersInLastRow=0;
            for(int k=1;k<key.length;k++){
                height++;
                maxCharToEncrypt+=getIndex(k)+1;
                if(maxCharToEncrypt>=data.length()) {
                    charactersInLastRow = getIndex(k)+1 - (maxCharToEncrypt-data.length());
                    break;
                };
            }

            for(int i=0;i<n;i++){
                if(arrayData.length<index+1) break;
                int currentColumn = getIndex(i+1);
                for(int j=0;j<height;j++){
                    if(arrayData.length<index+1) break;
                    if(getIndex(j+1)>=currentColumn){
                        if(j+1==height){
                            if(currentColumn>charactersInLastRow-1)break;
                            else matrix[j][currentColumn] = arrayData[index++];
                        }else{
                            matrix[j][currentColumn] = arrayData[index++];
                        }
                    }
                }
            }

        }
        return matrix;
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
