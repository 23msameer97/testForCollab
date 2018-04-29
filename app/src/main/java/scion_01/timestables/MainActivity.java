package scion_01.timestables;
//this is my second commit, by scion01
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ListView listView;
    private TextView textView;
    private SeekBar seekBar;
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private  ArrayAdapter<Integer> arrayAdapter;
		
	private String secondCommit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        textView= (TextView) findViewById(R.id.currentTable);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView.setText("1");
        init1(1);
        seekBar.setMax(100);
        //seekBar.setMin(1);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(this);
        arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
    protected void init(int n){
        int i;
        Log.i("Tag: ","inside2");
        for(i=0;i<10;i++) {
            arrayList.remove( 0);
        }
        for(i=1;i<=10;i++) {
            arrayList.add(n* i);
        }

    }
    protected void init1(int n){
        int i;

        for(i=1;i<=10;i++) {
            arrayList.add(n* i);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress==0)
            progress=1;
        Log.i("Tag: ","inside");
            init(progress);
            textView.setText(Integer.toString(progress));
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
