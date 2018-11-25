package cremedelacreme.tickats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class TicketDetails extends AppCompatActivity {

    // Arrays to hold data in RecyclerViews (scroll boxes)
    public static ArrayList<String> mArr1 = new ArrayList<>();
    public static ArrayList<String> mArr2 = new ArrayList<>();
    public static ArrayList<String> mArr3 = new ArrayList<>(); //End Heavy Equipment arrays
    public static ArrayList<String> mArr4 = new ArrayList<>();
    public static ArrayList<String> mArr5 = new ArrayList<>();
    public static ArrayList<String> mArr6 = new ArrayList<>(); //End Tools (light equip) arrays
    public static ArrayList<String> mArr7 = new ArrayList<>();
    public static ArrayList<String> mArr8 = new ArrayList<>();
    public static ArrayList<String> mArr9 = new ArrayList<>(); //End Worker arrays


    @Override
    //onCreate:= main
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details);
                                /*Adds data to RecyclerView boxes and positions them using
                                RelativeAdapter 1= Heavy Equip view; 2= Tools view; 3=Workers view*/


        AddInfo1();
        RecycleView1();

        AddInfo2();
        RecycleView2();

        AddInfo3();
        RecycleView3();

        populateHeader();
    }

    private void RecycleView1(){                       //Formats Heavy Equipment info in its scroll box
        RecyclerView HeavyScroll = findViewById(R.id.HeavyScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr1, mArr2, mArr3);
        HeavyScroll.setAdapter(adapter);
        HeavyScroll.setLayoutManager(new LinearLayoutManager(this ));
        }
    private void AddInfo1 (){                          //Adds info to Heavy Equipment scroll box
        String TID = "17";
        BackGroundWorker thread = new BackGroundWorker(this);
        thread.execute("HeavyEquip", TID);
        //mArr1.add("5678");
        //mArr2.add("Excavator");
        //mArr3.add("Green");
    }
    private void RecycleView2(){                      //Formats Tools info in its scroll box
        RecyclerView ToolScroll = findViewById(R.id.ToolScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr4, mArr5, mArr6);
        ToolScroll.setAdapter(adapter);
        ToolScroll.setLayoutManager(new LinearLayoutManager(this ));
    }
    private void AddInfo2 (){                         //Adds info to Tools scroll box
        mArr4.add("567");
        mArr5.add("SkillSaw");
        mArr6.add("Red");
    }
    private void RecycleView3(){                      //Formats Workers info in its scroll box
        RecyclerView WorkerScroll = findViewById(R.id.WorkerScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr7, mArr8, mArr9);
        WorkerScroll.setAdapter(adapter);
        WorkerScroll.setLayoutManager(new LinearLayoutManager(this ));
    }
    private void AddInfo3 (){                          //Adds info to Workers scroll box
        mArr7.add("Dirty");
        mArr8.add("Bubble");
        mArr9.add("555-555-5555");
    }

    private void populateHeader(){                     //Populates Jobsite, Start, Status, & Priority fields at top of screen
        TextView JobAddy = findViewById(R.id.JobsiteBox);
        JobAddy.setText("Exxon Mobil");
        TextView StartDate = findViewById(R.id.StartBox);
        StartDate.setText("11/24/2018");
        TextView Status = findViewById(R.id.StatusBox);
        Status.setText("Open");
        TextView Priority = findViewById(R.id.PriorityBox);
        Priority.setText("4-Critical");
    }
}
