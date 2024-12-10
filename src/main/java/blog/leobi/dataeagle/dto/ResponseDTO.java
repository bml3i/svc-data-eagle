package blog.leobi.dataeagle.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseDTO {

    @JsonProperty("success")
    private boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("error")
    private CustomError error;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();


    public ResponseDTO buildErrorMessage(CustomError error) {
        this.setSuccess(false);

        if (error != null) {
            this.setError(error);
        }

        return this;
    }


    public ResponseDTO buildSuccessMessage() {
        return this.buildSuccessMessage(null);
    }

    public ResponseDTO buildSuccessMessage(Object data) {
        this.setSuccess(true);

        if (data != null) {
            this.setData(data);
        }

        return this;
    }

}
