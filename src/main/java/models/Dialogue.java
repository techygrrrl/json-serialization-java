package models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Dialogue {
    @SerializedName("id") Integer id;
    @SerializedName("next") Integer next;
    @SerializedName("dialogue") String dialogue;
    @SerializedName("responseOptions") ArrayList<Dialogue> responseOptions;

    public Integer getId() {
        return this.id;
    }

    public Integer getNext() {
        return this.next;
    }

    public String getDialogueText() {
        return this.dialogue;
    }

    public ArrayList<Dialogue> getResponseOptions() {
        return this.responseOptions;
    }

    @Override
    public String toString() {
        return String.format(
                "id = %s , next = %s , text = %s",
                getId(),
                getNext(),
                getDialogueText()
        );
    }
}
