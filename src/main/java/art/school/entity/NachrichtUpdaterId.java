package art.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class NachrichtUpdaterId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nachricht_id")
    private Integer nachrichtId;
}
