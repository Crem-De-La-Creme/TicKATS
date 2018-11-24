package cremedelacreme.tickats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class TicketDetails extends AppCompatActivity {

    // Arrays that hold the ticket data
    private ArrayList<String> mArr1 = new ArrayList<>();
    private ArrayList<String> mArr2 = new ArrayList<>();
    private ArrayList<String> mArr3 = new ArrayList<>();
    private ArrayList<String> mArr4 = new ArrayList<>();
    private ArrayList<String> mArr5 = new ArrayList<>();
    private ArrayList<String> mArr6 = new ArrayList<>();
    private ArrayList<String> mArr7 = new ArrayList<>();
    private ArrayList<String> mArr8 = new ArrayList<>();
    private ArrayList<String> mArr9 = new ArrayList<>();


    @Override
    //main
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details);
        
        AddInfo1();
        RecycleView1();
        AddInfo2();
        RecycleView2();
        AddInfo3();
        RecycleView3();
    }

    private void RecycleView1(){
        RecyclerView HeavyScroll = findViewById(R.id.HeavyScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr1, mArr2, mArr3);
        HeavyScroll.setAdapter(adapter);
        HeavyScroll.setLayoutManager(new LinearLayoutManager(this ));
        }
    private void AddInfo1 (){
        mArr1.add("1234");
        mArr2.add("Excavator");
        mArr3.add("Green");
    }
    private void RecycleView2(){
        RecyclerView ToolScroll = findViewById(R.id.ToolScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr4, mArr5, mArr6);
        ToolScroll.setAdapter(adapter);
        ToolScroll.setLayoutManager(new LinearLayoutManager(this ));
    }
    private void AddInfo2 (){
        mArr4.add("567");
        mArr5.add("SkillSaw");
        mArr6.add("Red");
    }
    private void RecycleView3(){
        RecyclerView WorkerScroll = findViewById(R.id.WorkerScroll);
        RelativeAdapter adapter = new RelativeAdapter(mArr7, mArr8, mArr9);
        WorkerScroll.setAdapter(adapter);
        WorkerScroll.setLayoutManager(new LinearLayoutManager(this ));
    }
    private void AddInfo3 (){

        mArr7.add("Dirty");
        mArr8.add("Bubble");
        mArr9.add("555-555-5555");
    }
}
