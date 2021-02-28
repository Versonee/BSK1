public class CaesarCipher implements Cipher{
    public int offset;
    public final int charactersCount= 26;
    public final int firstUppercaseLetter= 65;
    public final int firstLowercaseLetter= 97;
    public CaesarCipher(int offset){
        this.offset = offset;
    }

    @Override
    public String encrypt(String data)
    {
        char[] encryptedData = new char[data.length()];
        for (int i = 0; i<data.length(); i++)
        {
            if (data.charAt(i) == ' '){
                encryptedData[i]=data.charAt(i);
            }else{
                if (Character.isUpperCase(data.charAt(i)))
                {
                    char ch = (char)(((int)data.charAt(i) + offset - firstUppercaseLetter) % 26 + firstUppercaseLetter);
                    encryptedData[i]=ch;
                }
                else
                {
                    char ch = (char)(((int)data.charAt(i) + offset - firstLowercaseLetter) % 26 + firstLowercaseLetter);
                    encryptedData[i]=ch;
                }
            }
        }
        return new String(encryptedData);
    }

    @Override
    public String decrypt(String data) {
        int currentOffset = offset;
        this.offset=charactersCount - offset;
        String result = encrypt(data);
        this.offset=currentOffset;
        return result;
    }
}
