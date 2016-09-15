package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton Power;
    private TextView Station;
    private TextView VolumeText;
    private RadioButton AM;
    private RadioButton FM;
    private Button TunerLeft;
    private Button TunerRight;
    private SeekBar VolumeBar;
    private boolean AMState = false;
    private int StationNumber = 1350;
    private Button button[]= new Button[6];
    private int AMPreset[] = {550,600,650,700,750,800};
    private int FMPreset[] = {909,929,949,969,989,1009};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Power = (ToggleButton)findViewById(R.id.Power);
        Station = (TextView)findViewById(R.id.Station);

        VolumeText = (TextView)findViewById(R.id.VolumeText);
        AM = (RadioButton)findViewById(R.id.AM);
        FM = (RadioButton)findViewById(R.id.FM);
        TunerLeft = (Button)findViewById(R.id.TunerLeft);
        TunerRight = (Button)findViewById(R.id.TunerRight);
        VolumeBar = (SeekBar)findViewById(R.id.VolumeBar);
        button[0] = (Button)findViewById(R.id.button1);
        button[1] = (Button)findViewById(R.id.button2);
        button[2] = (Button)findViewById(R.id.button3);
        button[3] = (Button)findViewById(R.id.button4);
        button[4] = (Button)findViewById(R.id.button5);
        button[5] = (Button)findViewById(R.id.button6);
        Power.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener(){
                    public void onCheckedChanged (CompoundButton buttonView, boolean isChecked){
                        if (isChecked)
                        {
                            Power.setBackgroundColor(Color.GREEN);
                            Station.setTextColor(Color.BLACK);
                            VolumeText.setTextColor(Color.BLACK);
                            AM.setEnabled(true);
                            FM.setEnabled(true);
                            TunerLeft.setEnabled(true);
                            TunerRight.setEnabled(true);
                            VolumeBar.setEnabled(true);
                            AMState = true;
                            AM.setChecked(true);
                            updateStationText();
                            for(int i = 0; i< button.length; i++)
                            {
                                button[i].setEnabled(true);
                            }


                        }
                        else
                        {
                            Power.setBackgroundColor(Color.RED);
                            Station.setTextColor(Color.GRAY);
                            VolumeText.setTextColor(Color.GRAY);
                            FM.setEnabled(false);
                            AM.setEnabled(false);
                            TunerLeft.setEnabled(false);
                            TunerRight.setEnabled(false);
                            VolumeBar.setEnabled(false);
                            for(int i = 0; i< button.length; i++)
                            {
                                button[i].setEnabled(false);
                            }

                        }
                    }
                }
        );
        Power.setChecked(false);

        AM.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        AMState = true;
                        StationNumber = 1350;
                        updateStationText();
                    }
                }
        );
        FM.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        AMState = false;
                        StationNumber = 997;
                        updateStationText();
                    }
                }
        );

        TunerLeft.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = (StationNumber -530 - 10 +1180)%1180 + 530;

                        }
                        else
                        {
                            StationNumber = ((StationNumber - 881 - 02 +200)%200 + 881);
                        }
                        updateStationText();
                    }
                }
        );

        TunerRight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = (StationNumber -530 + 10 +1180)%1180 + 530;

                        }
                        else
                        {
                            StationNumber = ((StationNumber - 881 + 02 +200)%200 + 881);
                        }
                        updateStationText();
                    }
                }
        );

        button[0].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[0];

                        }
                        else
                        {
                            StationNumber = FMPreset[0];
                        }
                        updateStationText();
                    }
                }
        );
        button[1].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[1];

                        }
                        else
                        {
                            StationNumber = FMPreset[1];
                        }
                        updateStationText();
                    }
                }
        );
        button[2].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[2];

                        }
                        else
                        {
                            StationNumber = FMPreset[2];
                        }
                        updateStationText();
                    }
                }
        );
        button[3].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[3];

                        }
                        else
                        {
                            StationNumber = FMPreset[3];
                        }
                        updateStationText();
                    }
                }
        );
        button[4].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[4];

                        }
                        else
                        {
                            StationNumber = FMPreset[4];
                        }
                        updateStationText();
                    }
                }
        );
        button[5].setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(AMState) {
                            StationNumber = AMPreset[5];

                        }
                        else
                        {
                            StationNumber = FMPreset[5];
                        }
                        updateStationText();
                    }
                }
        );
        button[0].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[0] = StationNumber;

                        }
                        else
                        {
                            FMPreset[0] = StationNumber;
                        }


                        return true;
                    }
                }
        );
        button[1].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[1] = StationNumber;

                        }
                        else
                        {
                            FMPreset[1] = StationNumber;
                        }


                        return true;
                    }
                }
        );
        button[2].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[2] = StationNumber;

                        }
                        else
                        {
                            FMPreset[2] = StationNumber;
                        }


                        return true;
                    }
                }
        );
        button[3].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[3] = StationNumber;

                        }
                        else
                        {
                            FMPreset[3] = StationNumber;
                        }


                        return true;
                    }
                }
        );
        button[4].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[4] = StationNumber;

                        }
                        else
                        {
                            FMPreset[4] = StationNumber;
                        }


                        return true;
                    }
                }
        );
        button[5].setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View v){
                        if(AMState){
                            AMPreset[5] = StationNumber;

                        }
                        else
                        {
                            FMPreset[5] = StationNumber;
                        }


                        return true;
                    }
                }
        );
    }


    public void updateStationText()
    {
        if(AMState){

            Station.setText("AM "+ StationNumber);
        }
        else
        {
            Station.setText("FM "+ StationNumber/10.0);
        }

    }
}
