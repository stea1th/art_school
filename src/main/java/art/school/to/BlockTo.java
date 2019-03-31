package art.school.to;

import art.school.entity.Block;
import art.school.entity.Users;
import art.school.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockTo {

    private Integer interval;
    private String timeUnit;
    private String reason;

    public Block createBlock(Users u){
        return new Block(reason, DateUtil.transformToDate(interval, timeUnit), u);
    }
}
