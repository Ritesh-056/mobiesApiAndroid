package np.com.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.navigation_home) {

            Toast.makeText(this, "This is my home page", Toast.LENGTH_SHORT).show();

        }


        if(item.getItemId() == R.id.navigation_dashboard){

            Toast.makeText(this, "This is my dashboard", Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId() == R.id.navigation_notifications){

            Toast.makeText(this, "This is my notification", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      getSupportFragmentManager().beginTransaction().replace(R.id.main,new FlimsFragmentHolder()).commit();

    }
}
