package cgx.framework.common.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class IdDTO implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Long id;
}
