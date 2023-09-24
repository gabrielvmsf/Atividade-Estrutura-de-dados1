import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Entrada {
    InputStream is;

    public Entrada(String arquivo) {
        try {
            is = new FileInputStream(new File(arquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int LerProximoCaractere() {
        try {
            int p = is.read();
            System.out.println(p);
            return p;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
