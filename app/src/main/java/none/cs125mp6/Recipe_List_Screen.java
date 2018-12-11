package none.cs125mp6;
import com.android.volley.toolbox.*;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;

import java.util.ArrayList;

public class Recipe_List_Screen extends AppCompatActivity {


    ArrayList<String> ingredientList = new ArrayList<String>();
    ArrayList<String> recipeList = new ArrayList<String>();
    private ListView LV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__list__screen);
        Intent intent = getIntent();
        ingredientList = intent.getStringArrayListExtra("ingredients");

        String ingredientsAsString = arrayListToString(ingredientList);

        String finalURL = "https://api.edamam.com/search?q=";
        finalURL += ingredientsAsString;
        finalURL += "&app_id=9bcb6bc3&app_key=b0ef075aac9128f84e02f26a65137c35&from=0&to=10";

        //JSONParser jsonParser = new JSONParser();
        //JSONObject result = jsonParser.parse(jsonParser).getAsJsonObject();
        //String[] ingredients = result.get("ingredients").getAsString();

        /**try {

            Object obj = parser.parse(new FileReader("wadingpools.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            JSONArray featuresArray = (JSONArray) jsonObject.get("features");
            Iterator iter = featuresArray.iterator();

            while (iter.hasNext()) {
                Map<String, String> propertiesMap = ((Map<String, String>) jsonObject.get("properties"));
                Iterator<Map.Entry<String, String>> itrMap = propertiesMap.entrySet().iterator();
                while(itrMap.hasNext()){
                    Map.Entry<String, String> pair = itrMap.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        RequestFuture<JSONObject> future = RequestFuture.newFuture();
//        JsonObjectRequest request = new JsonObjectRequest(finalURL, new JSONObject(), future, future);
//        requestQueue.add(request);

//
//        try {
//            JSONObject response = future.get(); // this will block
//        } catch (InterruptedException e) {
//            // exception handling
//        } catch (ExecutionException e) {
//            // exception handling
//        }


        recipeList.add("Baked Onion Chicken");
        recipeList.add("Oyako Donburi (Japanese Chicken & Egg Bowl)");
        recipeList.add("Kosher Revolution's Onion-Stuffed Knaidlach");
        recipeList.add("Mexican Chicken Sliders recipes");
        recipeList.add("Paprika Chicken with Egg Dumplings");
        recipeList.add("Sour Cream and Onion Chicken");
        recipeList.add("Egg-Bacon Toasts with Onions and Spinach");
        recipeList.add("Chicken Sesame Noodles");
        recipeList.add("Egg Drop Soup");
        recipeList.add("Fresh Fettuccine with Ri...ing Onions and Duck Egg");

        LV = (ListView) findViewById(R.id.allRecipes);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipeList);
        LV.setAdapter(arrayAdapter);
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.edamam.com/recipe/baked-onion-chicken-12013e9d3f452cbc68d070e4d99e6989/chicken%2Cegg%2Conion"));
                    startActivity(browserIntent);
                }
                if (position == 1) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://food52.com/recipes/2293-oyako-donburi-japanese-chicken-egg-bowl"));
                    startActivity(browserIntent);
                }
                if (position == 2) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.seriouseats.com/recipes/2011/12/kosher-revolutions-onion-stuffed-knaidlach-recipe.html"));
                    startActivity(browserIntent);
                }
                if (position == 3) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.epicurious.com/recipes/food/views/mexican-chicken-sliders-56389885"));
                    startActivity(browserIntent);
                }
                if (position == 4) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.saveur.com/article/Recipes/Paprika-Chicken-with-Egg-Dumplings"));
                    startActivity(browserIntent);
                }
                if (position == 5) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thedailymeal.com/sour-cream-and-onion-chicken-recipe"));
                    startActivity(browserIntent);
                }
                if (position == 6) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.marthastewart.com/340632/egg-bacon-toasts-with-onions-and-spinach"));
                    startActivity(browserIntent);
                }
                if (position == 7) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbcgoodfood.com/var/www/html/bbcgoodfood/docroot/recipes/4556"));
                    startActivity(browserIntent);
                }
                if (position == 8) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.simplyrecipes.com/recipes/egg_drop_soup/"));
                    startActivity(browserIntent);
                }
                if (position == 9) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://herbivoracious.com/2009/05/fresh-fettucini-with-ricotta-spring-onions-and-duck-egg-recipe.html"));
                    startActivity(browserIntent);
                }
            }
        });
    }

    public String arrayListToString(ArrayList<String> toConvert) {
        String toReturn = "";

        for (String s : toConvert)
        {
            toReturn += s + ",";
        }
        return toReturn;
    }

}
