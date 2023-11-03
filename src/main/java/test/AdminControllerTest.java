package test;

import Entity.AdminEntity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import controller.AdminController;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminControllerTest {
    AdminController adminCenterController = new AdminController();
    Gson gson = new Gson();

    @Test
    void getAdminCentreByPersonne() {
        String expectedJson = "{\"id\": 3," +
                " \"email\": \"fadwa\", " +
                "\"password\": \"fadwa\"," +
                " \"fullname\": \"fadwa\"," +
                " \"ville\": \"agadir\"}";

        ResponseEntity<AdminEntity> responseEntity = adminCenterController.get(3);
        AdminEntity actualEntity = responseEntity.getBody();

        JsonParser parser = new JsonParser();
        JsonObject expectedJsonObj = parser.parse(expectedJson).getAsJsonObject();
        JsonObject actualJsonObj = parser.parse(gson.toJson(actualEntity)).getAsJsonObject();

        assertEquals(expectedJsonObj, actualJsonObj);
}}


