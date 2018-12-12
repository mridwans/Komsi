package com.example.user.komsi.remote;

import com.example.user.komsi.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    @GET("users/")
    Call<List<User>> getUsers();

    @POST("register/")
    Call<User> addUser(@Body User user);

    @POST("login/")
    Call<User> loginUser(@Body User user);

    @PUT("updateUser/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("deleteUser/{id}")
    Call<User> deleteUser(@Path("id") int id, @Body User user);
}
