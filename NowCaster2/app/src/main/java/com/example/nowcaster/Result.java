package com.example.nowcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_result2);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        Log.d("message",message);
        switch(message) {
            case "Cirrus":
                ImageView imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.sunny);
                ImageView imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.windy);
                TextView tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cirrus clouds are the most common of the high clouds. They are composed of ice and are thin, wispy clouds blown in high winds into long streamers. Cirrus clouds are usually white and predict fair to pleasant weather. By watching the movement of cirrus clouds you can tell from which direction weather is approaching. When you see cirrus clouds, it usually indicates that a change in the weather will occur within 24 hours.");
                break;
            case "Cirrostratus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.verycloudy);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.heavyrainfall);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cirrostratus clouds are thin, sheetlike high clouds that often cover the entire sky. They are so thin that the sun and moon can be seen through them. Cirrostratus clouds usually come 12-24 hours before a rain or snow storm.");
                break;
            case "Cirrocumulus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.cold);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.windyrainfall);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cirrocumulus clouds appear as small, rounded white puffs that appear in long rows. The small ripples in the cirrocumulus clouds sometime resemble the scales of a fish. Cirrocumulus clouds are usually seen in the winter and indicate fair, but cold weather. In tropical regions, they may indicate an approaching hurricane.");
                break;
            case "Altostratus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.cold);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.heavyrainfall);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Altostratus clouds are gray or blue-gray mid level clouds composed of ice crystals and water droplets. The clouds usually cover the entire sky. In the thinner areas of the clouds, the sun may be dimly visible as a round disk. Altostratus clouds often form ahead of storms with continuous rain or snow.");
                break;
            case "Altocumulus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.sunny);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.heavyrainfall);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Altocumulus clouds are mid level clouds that are made of water droplets and appear as gray puffy masses. They usually form in groups. If you see altocumulus clouds on a warm, sticky morning, be prepared to see thunderstorms late in the afternoon.");
                break;
            case "Stratus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.fog);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.cold);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Stratus clouds are uniform grayish clouds that often cover the entire sky. They resemble fog that doesn't reach the ground. Light mist or drizzle sometimes falls out of these clouds.");
                break;
            case "Stratocumulus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.precipitation);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.normalrain);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Stratocumulus clouds are low, puffy and gray. Most form in rows with blue sky visible in between them. Rain rarely occurs with stratocumulus clouds, however, they can turn into nimbostratus clouds.");
                break;
            case "Clear Sky":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.sunny);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.sunny);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Its a clear Sky, enjoy the weather");
                break;
            case "Nimbostratus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.precipitation);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.verycloudy);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Nimbostratus clouds form a dark gray, wet looking cloudy layer associated with continuously falling rain or snow. They often produce precipitation that is usually light to moderate.");
                break;
            case "Cumulus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.sunny);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.thunder);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cumulus clouds are white, puffy clouds that look like pieces of floating cotton. Cumulus clouds are often called \"fair-weather clouds\". The base of each cloud is flat and the top of each cloud has rounded towers. When the top of the cumulus clouds resemble the head of a cauliflower, it is called cumulus congestus or towering cumulus. These clouds grow upward and they can develop into giant cumulonimbus clouds, which are thunderstorm clouds");
                break;
            case "Cumulonimbus":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.thunder);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.windyrainfall);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cumulonimbus clouds are thunderstorm clouds. High winds can flatten the top of the cloud into an anvil-like shape. Cumulonimbus clouds are associated with heavy rain, snow, hail, lightning and even tornadoes. The anvil usually points in the direction the storm is moving.");
                break;
            case "Contrails":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.sunny);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.cloudy);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Contrails are condensation trails left behind jet aircrafts. Contrails form when hot humid air from jet exhaust mixes with environmental air of low vapor pressure and low temperature. The mixing is a result of turbulence generated by the engine exhaust.");
                break;
            case "Night Sky":
                imview1= (ImageView)findViewById(R.id.iv);
                imview1.setImageResource(R.drawable.nighttime);
                imview2= (ImageView)findViewById(R.id.iv1);
                imview2.setImageResource(R.drawable.verycloudy);
                tev=(TextView)findViewById(R.id.tv);
                tev.setText("Cant see the clouds clearly, its nighttime");
                break;
            default:
                // code block
        }
    }
}