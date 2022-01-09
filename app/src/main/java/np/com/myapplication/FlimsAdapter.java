package np.com.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FlimsAdapter extends RecyclerView.Adapter<FlimsViewHolder> {


    ArrayList<Flims>flims;

    public FlimsAdapter(ArrayList<Flims>flims){

        this.flims=flims;
    }


    @NonNull
    @Override
    public FlimsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new FlimsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlimsViewHolder holder, int position) {

        holder.setdata(flims.get(position));

    }



    @Override
    public int getItemCount() {
        return flims.size();
    }


}
