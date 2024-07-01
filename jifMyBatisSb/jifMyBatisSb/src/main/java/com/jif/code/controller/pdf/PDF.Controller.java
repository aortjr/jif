import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @GetMapping("/generate")
    @ResponseBody
    public String generatePdf() {
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
                "                <tr>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
                "                    <td class=\"invisible\">空白</td>\n" +
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
                "                    <td>控除その他</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>所得税</td>\n" +
                "                    <td>0</td>\n" +
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
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>厚生年金保険料</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>雇用保険料</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>源泉所得税額</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"col\" style=\"padding-right: 10px; padding-left: 10px;\">\n" +
                "            <!-- 合計 テーブル -->\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\" class=\"text-center bg-light\">合計</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>項目</th>\n" +
                "                    <th>合計</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody class=\"table-group-divider\">\n" +
                "                <tr>\n" +
                "                    <td>支給合計</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>控除合計</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>差引支給額</td>\n" +
                "                    <td>0</td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        try {
            // PDFファイルに変換
            File pdfFile = new File("salary_statement.pdf");
            FileOutputStream outputStream = new FileOutputStream(pdfFile);
            HtmlConverter.convertToPdf(htmlContent, outputStream);
            outputStream.close();

            return "PDF生成が完了しました。";
        } catch (IOException e) {
            e.printStackTrace();
            return "PDF作成中にエラーが発生しました。";
        }
    }
}
