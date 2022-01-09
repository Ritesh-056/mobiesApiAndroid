package np.com.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class FlimsViewHolder extends RecyclerView.ViewHolder {


    TextView textViewTitle,textViewDescription;
    ImageView imageView;

    public FlimsViewHolder(@NonNull View itemView) {
        super(itemView);


        textViewTitle=itemView.findViewById(R.id.textViewTitle);
        textViewDescription=itemView.findViewById(R.id.textViewDescription);
        imageView=itemView.findViewById(R.id.imageView);

    }




    public void setdata(Flims flims) {

       textViewTitle.setText(flims.getTile());
       textViewDescription.setText(flims.getDescription());

        Picasso
            .get()
            .load("http://image.tmdb.org/t/p/w500/"+flims.getImage())
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(imageView);


    }
}
