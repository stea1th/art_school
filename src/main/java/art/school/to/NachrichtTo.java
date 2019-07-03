package art.school.to;


import art.school.entity.NachrichtUpdater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NachrichtTo {

    private Integer id;
    private String text;
    private DateTo datumTo;
    private String datum;
    private String name;
    private Integer userId;
    private Integer themaId;
    private NachrichtUpdater updater;
    private String updaterInfo;
    private Integer size;
    private List<String> lines;
    private List<String> parentMessages;
    private Integer page;
    private Boolean reload;
    private Integer roleSize;
    private String registriert;
    private Integer messages;
    private String banned;
    private String encodedImage;
    private Boolean active;

    public boolean isNew() {
        return (id == null || id.equals(themaId));
    }

}
