package org.example.maxpetapi.Response;

import lombok.Getter;
import lombok.Setter;
import org.example.maxpetapi.entity.SarcinaEntity;
import org.example.maxpetapi.entity.UsersEntity;

import java.util.List;

public class Response {
    @Getter
    @Setter
    private int StatusCode;
    @Getter
    @Setter
    private String StatusMessage;
    @Getter
    @Setter
    private UsersEntity user;
    @Getter
    @Setter
    private List<SarcinaEntity> listSarcina;

    public Response() {
    }

    public Response(int statusCode, String statusMessage) {
        StatusCode = statusCode;
        StatusMessage = statusMessage;
    }

    public Response(int statusCode, String statusMessage, UsersEntity user, List<SarcinaEntity> listSarcina) {
        StatusCode = statusCode;
        StatusMessage = statusMessage;
        this.user = user;
        this.listSarcina = listSarcina;
    }

    public Response(int statusCode, String statusMessage, UsersEntity user) {
        StatusCode = statusCode;
        StatusMessage = statusMessage;
        this.user = user;
    }

    public Response(int statusCode, String statusMessage, List<SarcinaEntity> listSarcina) {
        StatusCode = statusCode;
        StatusMessage = statusMessage;
        this.listSarcina = listSarcina;
    }
}
