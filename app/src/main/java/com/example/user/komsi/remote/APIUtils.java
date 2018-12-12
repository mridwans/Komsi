package com.example.user.komsi.remote;

public class APIUtils {

    private APIUtils() {

    };

    public static final String API_URL = "http://ridwan.rirfanddi.id/public/api/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }

}
