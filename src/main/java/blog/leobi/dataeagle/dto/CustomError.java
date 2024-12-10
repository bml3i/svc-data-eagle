package blog.leobi.dataeagle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {

    @JsonProperty("code")
    private String errorCode;

    @JsonProperty("message")
    private String errorMessage;

}
