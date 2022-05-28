package kviz3;

public class kviz10 {
    public static void main(String[] args){
        bsdChecksum("filename.txt");
    }
    public static int bsdChecksum(String filename){
        try {
            java.io.FileInputStream file = new java.io.FileInputStream(filename);
            int sum = 0;
            while (file.available() > 0) {
                int c = file.read();
                sum = (sum >> 1) + ((sum & 0X1) << 15);
                sum = (sum + c) % 65536;

            }
            
            file.close();
            return sum;
        }
        
        catch (Exception e) {
            return 0;
        }
    }
}
