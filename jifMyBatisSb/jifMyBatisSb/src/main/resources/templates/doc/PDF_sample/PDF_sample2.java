import com.itextpdf.html2pdf.HtmlConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlToPdfConverter {

    public static void main(String[] args) throws IOException {
        String htmlContent = "<html><body><h1>Hello, World!</h1><p>This is a test.</p></body></html>";

        // HTMLをPDFに変換する部分選択
        String selectedHtml = extractSelectedHtml(htmlContent); // ここで必要な部分選択ロジックを実装する必要がある

        // PDFに変換して保存
        convertHtmlToPdf(selectedHtml, "output.pdf");
    }

    private static String extractSelectedHtml(String htmlContent) {
        // 例:HTMLで特定の部分を選択するロジック
        Document doc = Jsoup.parse(htmlContent);
        Element selectedElement = doc.sele ctFirst("h1"); // 例としてタイトル部分を選択
        return selectedElement != null ? selectedElement.outerHtml() : "";
    }

    private static void convertHtmlToPdf(String htmlContent, String outputPdf) throws IOException {
        File pdfFile = new File(outputPdf);
        try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
            HtmlConverter.convertToPdf(htmlContent, fos);
        }
    }
}
