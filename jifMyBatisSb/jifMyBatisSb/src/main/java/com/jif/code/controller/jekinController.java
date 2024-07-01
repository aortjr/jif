import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @GetMapping("/download")
    public void downloadPdf(HttpServletResponse response) throws IOException {
        // HTMLファイル経路
        String inputHtmlPath = "path/to/payroll.html";
        // PDFファイル経路
        String outputPdfPath = "path/to/payroll.pdf";

        try {
            // HTMLをPDFに変換
            HtmlToPdfConverter.convertHtmlToPdf(inputHtmlPath, outputPdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // PDFファイルをクライアントに配信
        File pdfFile = new File(outputPdfPath);
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=payroll.pdf");
        response.setContentLength((int) pdfFile.length());

        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        OutputStream responseOutputStream = response.getOutputStream();
        int bytes;
        while ((bytes = fileInputStream.read()) != -1) {
            responseOutputStream.write(bytes);
        }
        fileInputStream.close();
    }
}
