package art.school.util;

import art.school.entity.Nachricht;
import art.school.to.NachrichtTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class PaginationHelper {

    private int pageNumber;
    private String sorting;
    private boolean direction;
    private boolean step;
    private int sizing;
    private boolean select;
    private String link;


    public PaginationHelper(int pageNumber, String sorting, boolean direction, boolean step, int sizing, boolean select, String link) {
        this.pageNumber = pageNumber;
        this.sorting = sorting;
        this.direction = direction;
        this.step = step;
        this.sizing = sizing;
        this.select = select;
        this.link = link;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getSizing() {
        return sizing;
    }

    public Sort.Order getOrder() {
        Sort.Order order;
        if(!step && !select) {
            order = direction? Sort.Order.asc(sorting) : Sort.Order.desc(sorting);
            direction = !direction;
        } else {
            order = direction? Sort.Order.desc(sorting) : Sort.Order.asc(sorting);
        }
        return order;
    }

    private String getItems(int maxElements, int pageNumber, int sizing) {

        int max, min;
        if ((pageNumber + 1) * sizing > maxElements) {
            max = maxElements;
            min = max - (sizing + (max - (pageNumber + 1) * sizing)) + 1;
        } else {
            max = (pageNumber + 1) * sizing;
            min = max - sizing + 1;
        }
        return String.format("(%d-%d/%d)", min, max, maxElements);
    }

    public void createTablePage(Model model, Page<Nachricht> page, int maxElements) {
        model.addAttribute("direction", direction);
        model.addAttribute("sorting", sorting);
        model.addAttribute("sizing", sizing);
        model.addAttribute("link", link);
        model.addAttribute("items", getItems(maxElements, pageNumber, sizing));

        model.addAttribute("hasPrevious", page.hasPrevious());
        model.addAttribute("hasNext", page.hasNext());
        model.addAttribute("last", page.getTotalPages() - 1);

        model.addAttribute("list", page.stream()
                .sorted(Comparator.comparing(Nachricht::getDatum).thenComparing(Nachricht::getId))
                .map(NachrichtTo::new)
                .collect(Collectors.toCollection(LinkedList::new)));

        model.addAttribute("previous", pageNumber-1);
        model.addAttribute("next", pageNumber+1);
    }
}
