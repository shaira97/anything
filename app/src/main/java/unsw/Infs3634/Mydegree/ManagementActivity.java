package unsw.Infs3634.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagementActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage1page);
        appBarTxt.setText("Manage");

        Button buttonY1 = findViewById(R.id.button);
        Button buttonY2 = findViewById(R.id.button2);
        Button buttonY3 = findViewById(R.id.button3);


        buttonY1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this, year1_mgmtActivity.class);
                startActivity(intent);
            }
        });

//        buttonVideos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override public void onBackPressed() {
        startActivity(new Intent(ManagementActivity.this, HomepageActivity.class));
        finish();
    }
}
