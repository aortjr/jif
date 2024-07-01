import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HtmlToPdfConverter {

    public static void convertHtmlToPdf(String inputHtmlPath, String outputPdfPath) throws Exception {
        String url = new File(inputHtmlPath).toURI().toURL().toString();
        OutputStream os = new FileOutputStream(outputPdfPath);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);

        os.close();
    }

    public static void main(String[] args) {
        try {
            convertHtmlToPdf("path/to/payroll.html", "path/to/payroll.pdf");
            System.out.println("PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}