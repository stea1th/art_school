package art.school.web.unterricht;


import art.school.entity.Unterricht;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "ajax/unterricht/")
public class UnterrichtRestController extends AbstractUnterrichtController {


    public List<Unterricht> getAll() {
        return super.getAll();
    }

//    public ResponseEntity<String> create(@Valid Unterricht unterricht, BindingResult result){
//        if(result.hasErrors()){
//            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//        super.create();
//    }
}
