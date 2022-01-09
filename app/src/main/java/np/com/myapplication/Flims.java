package np.com.myapplication;

import com.google.android.material.snackbar.Snackbar;

public class Flims  {


    String tile;
    String description;
    String image;


    public Flims(String tile, String description, String image) {
        this.tile = tile;
        this.description = description;
        this.image = image;
    }


    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
