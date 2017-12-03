package ${package}.${artifactId}.web.dto;

import java.util.Map;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


/**
 * Created by id961900 on 09/08/2017.
 */

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntry {
    @ApiModelProperty(notes = "the key value alert content for application item description required to be entered by user into REST API ", required = true)
    private Map<String, String> applicationContent;
    @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ", required = true)
    private String applicationCode;

}
