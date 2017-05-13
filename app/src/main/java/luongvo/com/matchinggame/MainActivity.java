package luongvo.com.matchinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView currView = null;
    private int countPair = 0;
    final int[] drawable = new int[] {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7
    };
    int[] pos = {0,1,2,3,4,5,6,7};
    int currPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageAdapter imageAdapter = new ImageAdapter(this);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currPosition < 0 ) {
                    currPosition = position;
                    currView = (ImageView) view;
                    ((ImageView) view).setImageResource(drawable[pos[position]]);
                }
                else if (currPosition == position) {
                    currPosition = -1;
                    ((ImageView) view).setImageResource(R.drawable.hidden);
                }
                else if (pos[currPosition] != pos[position]) {
                    currView.setImageResource(R.drawable.hidden);
                    Toast.makeText(MainActivity.this, "Not Match!", Toast.LENGTH_LONG).show();
                }
                else {
                    ((ImageView) view).setImageResource(drawable[pos[position]]);
                    countPair++;
                    if (countPair == 8) {
                        Toast.makeText(MainActivity.this, "You Win!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
