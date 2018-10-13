package art.school.web.unterricht;


import art.school.entity.Unterricht;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnterrichtRestController extends AbstractUnterrichtController {


    public List<Unterricht> getAll() {
        return super.getAll();
    }
}
