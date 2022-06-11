
package models;

import java.io.Serializable;


public class note implements Serializable{
    private  String title;
    private String contents;
    
   
    public note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public note() {
        this.title = "";
        this.contents = "";
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
