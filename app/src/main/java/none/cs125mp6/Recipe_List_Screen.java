package none.cs125mp6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Recipe_List_Screen extends AppCompatActivity {


    ArrayList<String> ingredientList = new ArrayList<String>();
    private ListView LV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__list__screen);


        ingredientList.add("chicken");
        ingredientList.add("dog");
        ingredientList.add("Lamb");
        ingredientList.add("French");
        LV = (ListView) findViewById(R.id.allRecipes);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientList);
        LV.setAdapter(arrayAdapter);
    }
}
