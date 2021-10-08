package ddsutn.Business.Mascota.Foto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QR {

    public void ejecutar(String data) throws WriterException, IOException, NotFoundException {

        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/main/java/Services/Config/QR.prop");
        prop.load(input);

        String path = prop.getProperty("path");         // Path donde va a guardar el QR cuando lo genere
        String charset = prop.getProperty("charset");   //Encoding charset
        int height = Integer.parseInt(prop.getProperty("height"));
        int width = Integer.parseInt(prop.getProperty("width"));

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        //generates QR code with Low level(L) error correction capability
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        generarQR(data, path, charset, hashMap, height, width);

    }

    public void generarQR(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
        // the BitMatrix class represents the 2D matrix of bits
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);

        // MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

}
