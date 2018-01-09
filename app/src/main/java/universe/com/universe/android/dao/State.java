package universe.com.universe.android.dao;

/**
 * Created by gaurav.pandey on 09-01-2018.
 */

public class State {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;



    public State(String title) {
        this.title = title;

    }
}
