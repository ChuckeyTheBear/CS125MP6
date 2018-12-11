package none.cs125mp6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "none.cs125mp6.MESSAGE";
    ArrayList<String> ingredientList = new ArrayList<String>();
    private ListView LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LV = (ListView) findViewById(R.id.Ingredient);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientList);
        LV.setAdapter(arrayAdapter);
    }

    public void delFromList(View view) {
        if (ingredientList.size() > 0) {
            ingredientList.remove(ingredientList.size() - 1);
        } else {
            return;
        }
        LV = (ListView) findViewById(R.id.Ingredient);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientList);
        LV.setAdapter(arrayAdapter);
    }

    public void addToList(View view) {
        EditText currentHold = (EditText)findViewById(R.id.editText);
        String nextIngredient = currentHold.getText().toString();
        if (nextIngredient.length() == 0) {
            return;
        }
        ingredientList.add(nextIngredient);
        currentHold.setText("");

        LV = (ListView) findViewById(R.id.Ingredient);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientList);
        LV.setAdapter(arrayAdapter);
    }
    public void nextScreen(View view) {
        Intent intent = new Intent(this, Recipe_List_Screen.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
