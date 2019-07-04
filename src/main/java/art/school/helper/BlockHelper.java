package art.school.helper;

import art.school.entity.Block;
import art.school.entity.Users;
import art.school.to.BlockTo;
import art.school.util.DateUtil;
import org.springframework.stereotype.Component;

import static art.school.util.TextFormatUtil.escapeText;

@Component
public class BlockHelper {

    public BlockTo createTo(Block b) {

        BlockTo to = new BlockTo();
        to.setReason(escapeText(b.getReason()));
        to.setDate(DateUtil.formatDateTimeToString(b.getDatum()));
        to.setBlockedByName(b.getBlockedBy().getName());

        return to;
    }

    public Block createBlock(Users u, Users adm, BlockTo to) {
        Block b = new Block();
        b.setReason(to.getReason());
        b.setDatum(DateUtil.transformToDate(to.getInterval(), to.getTimeUnit()));
        b.setUser(u);
        b.setBlockedBy(adm);
        return b;
    }
}
