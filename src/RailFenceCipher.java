public class RailFenceCipher implements Cipher{
    int numRails;

    public RailFenceCipher(int numRails) {
        this.numRails = numRails;
    }
    public String encrypt(String data) {
        char[] encrypted = new char[data.length()];
        int n = 0;

        for (int k = 0; k < numRails; k++) {
            int index = k;
            boolean down = true;
            while (index < data.length()) {
                encrypted[n++] = data.charAt(index);

                if (k == 0 || k == numRails - 1) {
                    index = index + 2 * (numRails - 1);
                } else if (down) {
                    index = index + 2 * (numRails - k - 1);
                    down = !down;
                } else {
                    index = index + 2 * k;
                    down = !down;
                }
            }
        }
        return new String(encrypted);
    }

    public String decrypt(String data) {
        char[] decrypted = new char[data.length()];
        int n = 0;
        for (int k = 0; k < numRails; k++) {
            int index = k;
            boolean down = true;
            while (index < data.length()) {
                decrypted[index] = data.charAt(n++);

                if (k == 0 || k == numRails - 1) {
                    index = index + 2 * (numRails - 1);
                } else if (down) {
                    index = index + 2 * (numRails - k - 1);
                    down = !down;
                } else {
                    index = index + 2 * k;
                    down = !down;
                }
            }
        }
        return new String(decrypted);
    }
}