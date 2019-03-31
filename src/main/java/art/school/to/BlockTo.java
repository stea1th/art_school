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
    private String date;
    private String blockedByName;

    public BlockTo(String reason, String date, String blockedByName) {
        this.reason = reason;
        this.date = date;
        this.blockedByName = blockedByName;
    }

    public BlockTo(Block block){
        this(block.getReason(),
                DateUtil.formatDateToString(block.getDatum()),
                block.getBlockedBy().getName());
    }

    public Block createBlock(Users u, Users adm){
        return new Block(reason, DateUtil.transformToDate(interval, timeUnit), u, adm);
    }


}
