package com.application.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdEmailUsuarioResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

}
