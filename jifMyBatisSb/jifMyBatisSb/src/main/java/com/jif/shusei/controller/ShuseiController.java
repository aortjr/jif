//improt追加

@Controller
public class ShuseiController {

    @Autowired
    private ShuseiService shuseiService;

    // 編集画面を表示するGETリクエスト
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        // 新しい修正フォームを作成して、モデルに追加
        ShuseiForm form = new ShuseiForm();
        model.addAttribute("form", form);
        return "shusei/edit"; // 修正画面のテンプレートを返す
    }

    // 修正内容を保存するPOSTリクエスト
    @PostMapping("/save")
    public String saveShusei(@ModelAttribute("form") ShuseiForm form) {
        // サービスを介して修正内容を保存
        shuseiService.saveShuseiDetails(form);
        return "redirect:/ichiran"; // 一覧画面にリダイレクト
    }
}