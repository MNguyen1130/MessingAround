package com.mnguyen1130.messingaround;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        //String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        Human bob = (Human) activityThatCalled.getSerializableExtra("humanBob");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        //callingActivityMessage.append(" " + previousActivity);

        callingActivityMessage.append("Name: " + bob.getName() + " Height: " + bob.getHeight() + "ft Weight: " + bob.getWeight() + "lbs");
    }

    public void onSendUsersName(View view) {

        EditText userNameET = (EditText) findViewById(R.id.users_name_edit_text);

        String usersName = String.valueOf(userNameET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("UsersName", usersName);

        setResult(RESULT_OK, goingBack);

        finish();
    }
}
