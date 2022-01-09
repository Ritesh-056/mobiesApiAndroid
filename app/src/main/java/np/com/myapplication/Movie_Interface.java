package np.com.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Movie_Interface {

    @GET("list/3?page=1&api_key=0dff39a6adee62271e8866bc16d09b8c")
    Call<ResponseBody> getmylist();

}
