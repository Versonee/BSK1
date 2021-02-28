public class VigenereCipher {
    public final int firstLetter = 65;
    String generateValidKey(String data, String key)
    {
        int x = data.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == data.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    String encrypt(String data, String key)
    {
        key = generateValidKey(data,key);
        String encrypted="";

        for (int i = 0; i < data.length(); i++)
        {
            int x = (data.charAt(i) + key.charAt(i)) %26;
            x += firstLetter;
            encrypted+=(char)(x);
        }
        return encrypted;
    }


    String decrypt(String data, String key)
    {
        key = generateValidKey(data,key);
        String decrypted="";

        for (int i = 0 ; i < data.length() &&
                i < key.length(); i++)
        {
            int x = (data.charAt(i) - key.charAt(i) + 26) %26;
            x += firstLetter;
            decrypted+=(char)(x);
        }
        return decrypted;
    }
}
