package np.com.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class FlimsFragmentHolder extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);

    }


    RecyclerView recyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataset();

    }



    public void dataset() {


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/4/")
                .build();


        Movie_Interface movie_interface =retrofit.create(Movie_Interface.class);
        movie_interface.getmylist().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    JSONObject jsonObject=new JSONObject(response.body().string());
                    JSONArray result=jsonObject.getJSONArray("results");


                    ArrayList<Flims> mylist= new ArrayList<>();

                    for(int i=0;i<result.length();i++)
                    {

                        JSONObject movies =result.getJSONObject(i);

                        String title=movies.getString("title");
                        Log.d(TAG, "onResponse: " +title);
                        String overview=movies.getString("overview");
                        Log.d(TAG, "onResponse: "+overview);
                        String image=movies.getString("poster_path");



                        Flims flims= new Flims(title,overview,image);

                        flims.setTile(title);
                        flims.setDescription(overview);
                        flims.setImage(image);

                        mylist.add(flims);

                    }

                    FlimsAdapter flimsApiAdapter = new FlimsAdapter(mylist);
                    recyclerView.setAdapter(flimsApiAdapter);
                    flimsApiAdapter.notifyDataSetChanged();






                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                 t.printStackTrace();
            }
        });


    }
}
