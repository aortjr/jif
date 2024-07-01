import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlToPdfConverter {

    public static void main(String[] args) throws IOException {
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\" lang=\"jp\">\n" +
                "<head th:replace=\"common/head :: head_fragment(title = '給与明細書', scripts = ~{::script}, links = ~{::link})\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\n" +
                "    <title>給与明細書</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container mt-4\">\n" +
                "    <div class=\"row mb-2\">\n" +
                "        <div class=\"col-12 header\">\n" +
                "            <p class=\"fw-bold\">2024年 4月分給与　明細書</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"row mb-2\">\n" +
                "        <div class=\"col-11\">\n" +
                "            株式会社ジェードットインタフェース\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"row mb-2\">\n" +
                "        <div class=\"col-10\">\n" +
                "            氏名　 (07) KIM MINSEOK 様\n" +
                "        </div>\n" +
                "        <div class=\"col-2 text-left\">\n" +
                "            支給日　2024年 4月30日\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col\" style=\"padding-right: 10px;\">\n" +
                "            <!-- 勤怠 テーブル -->\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\" class=\"text-center bg-light\">勤怠</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>項目</th>\n" +
                "                    <th>合計</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody class=\"table-group-divider\">\n" +
                "                <tr>\n" +
                "                    <td>所定就労日</td>\n" +
                "                    <td>21.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>出勤日数</td>\n" +
                "                    <td>0.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>欠勤日数</td>\n" +
                "                    <td>0.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>休日出勤日数</td>\n" +
                "                    <td>0.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>法休出勤日数</td>\n" +
                "                    <td>0.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>特別休暇日数</td>\n" +
                "                    <td>0.00</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>所定労働時間</td>\n" +
                "                    <td>168:00</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"col\" style=\"padding-right: 10px; padding-left: 10px;\">\n" +
                "            <!-- 支給 テーブル -->\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\" class=\"text-center bg-light\">支給</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>項目</th>\n" +
                "                    <th>合計</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody class=\"table-group-divider\">\n" +
                "                <tr>\n" +
                "                    <td>基本給(月給)</td>\n" +
                "                    <td>167,256</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>非課税通勤費</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>住宅手当</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>普通残業手当</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>休日勤務手当</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>法休勤務手当</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>欠勤控除</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>遅刻早退控除</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>合計</td>\n" +
                "                    <td>167,256</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"col\" style=\"padding-right: 10px; padding-left: 10px;\">\n" +
                "            <!-- 控除 テーブル -->\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\" class=\"text-center bg-light\">控除</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>項目</th>\n" +
                "                    <th>合計</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody class=\"table-group-divider\">\n" +
                "                <tr>\n" +
                "                    <td>健康保険料</td>\n" +
                "                    <td>8,313</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>介護保険料</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>厚生年金保険</td>\n" +
                "                    <td>15,555</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>雇用保険料</td>\n" +
                "                    <td>1,004</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>所得税</td>\n" +
                "                    <td>2,740</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>住民税</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>社会保険料計</td>\n" +
                "                    <td>24,872</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td colspan=\"1\">合計</td>\n" +
                "                    <td colspan=\"1\">27,612</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"col\" style=\"padding-left: 10px;\">\n" +
                "            <!-- その他 テーブル -->\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\" class=\"text-center bg-light\">その他</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>項目</th>\n" +
                "                    <th>合計</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody class=\"table-group-divider\">\n" +
                "                <tr>\n" +
                "                    <td>合計</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        // Remove the PDF button (assuming it's identified by a specific class or ID)
        htmlContent = htmlContent.replaceAll("<button class=\"btn btn-primary\" id=\"pdfButton\">PDF 変換</button>", "");

        // Generate PDF
        generatePdfFromHtml(htmlContent, "output.pdf");
    }

    public static void generatePdfFromHtml(String htmlContent, String pdfFilePath) throws IOException {
        File pdfFile = new File(pdfFilePath);
        FileOutputStream outputStream = new FileOutputStream(pdfFile);
        PdfWriter writer = new PdfWriter(outputStream);
        HtmlConverter.convertToPdf(htmlContent, writer);
        outputStream.close();
        System.out.println("PDF 生成完了: " + pdfFilePath);
    }
}