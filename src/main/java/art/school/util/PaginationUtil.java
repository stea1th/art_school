package art.school.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

@Data
@NoArgsConstructor
public class PaginationUtil {

    private static String getItems(Page<?> page) {

        long max, min;
        if ((page.getNumber() + 1) * page.getSize() > page.getTotalElements()) {
            max = (int) page.getTotalElements();
            min =  max - (page.getSize() + (max - (page.getNumber() + 1) * page.getSize())) + 1;
        } else {
            max = (page.getNumber() + 1) * page.getSize();
            min = max - page.getSize() + 1;
        }
        return String.format("(%d-%d/%d)", min, max, page.getTotalElements());
    }

    public static void createTablePage(Model model, Page<?> page) {

        model.addAttribute("size", page.getSize());

        model.addAttribute("items", getItems(page));

        model.addAttribute("hasPrevious", page.hasPrevious());
        model.addAttribute("hasNext", page.hasNext());
        model.addAttribute("last", page.getTotalPages() - 1);

        model.addAttribute("previous", page.getNumber()-1);
        model.addAttribute("next", page.getNumber()+1);
    }
}
