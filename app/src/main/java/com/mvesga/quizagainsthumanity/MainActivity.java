package com.mvesga.quizagainsthumanity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//import static com.mvesga.quizagainsthumanity.R.id.opt1a;

public class MainActivity extends AppCompatActivity {

    /**
     * variable declaration
     */

    int sarcasmIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();
        initView();

    }

    /**
     * Init state
     */

    public void initView(){

        EditText nameField = (EditText)findViewById(R.id.player);
        TextView txtView = (TextView)findViewById(R.id.player);

        //Hide Retry Layout
        LinearLayout aLayout=(LinearLayout) this.findViewById(R.id.answerLayout);
        aLayout.setVisibility(LinearLayout.GONE);

        // Ui is back
            nameField.setText("");
            txtView.setVisibility(View.VISIBLE);
    }

    /**
     * SUBMIT ANSWERS button
     */

    public void submitAnswers(View view) {

        // Get results
        sarcasmIndexCalculation();

        //Hide Question Ui
        LinearLayout qLayout=(LinearLayout)this.findViewById(R.id.questionLayout);
        qLayout.setVisibility(LinearLayout.GONE);

        //Show Retry Layout
        LinearLayout aLayout=(LinearLayout) this.findViewById(R.id.answerLayout);
        aLayout.setVisibility(LinearLayout.VISIBLE);

        // Give result to user
        presentResults();
    }

    /**
     *  Send button RETRY behavior
     */

    public void submitRetry(View view) {

        //Show Question Ui
        LinearLayout qLayout=(LinearLayout)this.findViewById(R.id.questionLayout);
        qLayout.setVisibility(LinearLayout.VISIBLE);

        //hide Retry Ui
        LinearLayout aLayout=(LinearLayout) this.findViewById(R.id.answerLayout);
        aLayout.setVisibility(LinearLayout.GONE);

        // Clear RadioGroups

        RadioGroup rGrp = (RadioGroup) findViewById(R.id.radioGroup1);
        rGrp.clearCheck();
        rGrp = (RadioGroup) findViewById(R.id.radioGroup2);
        rGrp.clearCheck();
        rGrp = (RadioGroup) findViewById(R.id.radioGroup3);
        rGrp.clearCheck();
        rGrp = (RadioGroup) findViewById(R.id.radioGroup4);
        rGrp.clearCheck();
        rGrp = (RadioGroup) findViewById(R.id.radioGroup5);
        rGrp.clearCheck();
        rGrp = (RadioGroup) findViewById(R.id.radioGroup6);
        rGrp.clearCheck();

    }

    /**
     * Present results
     */
    
    public void presentResults() {

        // Catch player name

        EditText txtnameField = (EditText) findViewById(R.id.player);
        String name = txtnameField.getText().toString();

        TextView textName = (TextView) findViewById(R.id.nameResult);
        textName.setText(name);


        // Write sarcasmIndex Evaluation

        String sarcasmIndexResult = "";


        if (sarcasmIndex <= 6) {

            sarcasmIndexResult = "Your Sarcasm Index: 0 - 6\n\nYour status:\nSarcasm? What's Sarcasm?\n" +
                    "\nCongratulations, you are as sarcastic as Mother Theresa could ever had been. We suspect that neither The church lady or Barack Obama would approve of your humour. Cards Against Humanity people aren't bad people, they simply see the world a little more cynically and it shows in their sense of humor.\n" +
                    "\nCards Against Humanity is so wrong, it's right.";

        } else if (sarcasmIndex <= 12) {

            sarcasmIndexResult = "Your Sarcasm Index: 7 - 12\n\nYour status: Politically incorrect\n" +
                    "\n1 of 4 words or phrases you use to complete a statement or phrase, or answer a question include some dark, deviant political humour. You hang out with a group of friends that will say anything to get a laugh.\n" +
                    "\nno doubt you get a gut roll going when you play this game." +
                    "\n";
        } else {

            sarcasmIndexResult = "Your Sarcasm index is off the charts!\n 13 - 18\n\nYour status: Bigot Alert!\n" +
                    "\nWords, questions and phrases you use are slanted in such a way that almost every combination will give answers that most people would find offensive and hopefully also a humorous response. (Well, it's funny to some of us). What's the big deal then?\n" +
                    "\nWell, you have an Avantgarde sense of humour.";
        }

        TextView textResult = (TextView) findViewById(R.id.diags);
        textResult.setText(sarcasmIndexResult);

    }


    /**
     * Calculate sarcasmIndex from radio buttons
     */

    public int sarcasmIndexCalculation() {

        sarcasmIndex = 0;

        // Question 1
        // Radio Group
        RadioButton checkQ1 = (RadioButton) findViewById(R.id.opt1a);
        if (checkQ1.isChecked()) {
            sarcasmIndex += 1;
        }
        checkQ1 = (RadioButton) findViewById(R.id.opt1b);
        if (checkQ1.isChecked()) {
            sarcasmIndex += 2;
        }
        checkQ1 = (RadioButton) findViewById(R.id.opt1c);
        if (checkQ1.isChecked()) {
            sarcasmIndex += 3;
        }

        // Question 2
        // Radio Group
        RadioButton checkQ2 = (RadioButton) findViewById(R.id.opt2a);
        if (checkQ2.isChecked()) {
            sarcasmIndex += 3;
        }
        checkQ2 = (RadioButton) findViewById(R.id.opt2b);
        if (checkQ2.isChecked()) {
            sarcasmIndex += 2;
        }
        checkQ2 = (RadioButton) findViewById(R.id.opt2c);
        if (checkQ2.isChecked()) {
            sarcasmIndex += 1;
        }

        // Question 3
        // Radio Group
        RadioButton checkQ3 = (RadioButton) findViewById(R.id.opt3a);
        if (checkQ3.isChecked()) {
            sarcasmIndex += 3;
        }
        checkQ3 = (RadioButton) findViewById(R.id.opt3b);
        if (checkQ3.isChecked()) {
            sarcasmIndex += 1;
        }
        checkQ3 = (RadioButton) findViewById(R.id.opt3c);
        if (checkQ3.isChecked()) {
            sarcasmIndex += 2;
        }

        // Question 4
        // Radio Group
        RadioButton checkQ4 = (RadioButton) findViewById(R.id.opt4a);
        if (checkQ4.isChecked()) {
            sarcasmIndex += 1;
        }
        checkQ4 = (RadioButton) findViewById(R.id.opt4b);
        if (checkQ4.isChecked()) {
            sarcasmIndex += 2;
        }
        checkQ4 = (RadioButton) findViewById(R.id.opt4c);
        if (checkQ4.isChecked()) {
            sarcasmIndex += 3;
        }

        // Question 5
        // Radio Group
        RadioButton checkQ5 = (RadioButton) findViewById(R.id.opt5a);
        if (checkQ5.isChecked()) {
            sarcasmIndex += 1;
        }
        checkQ5 = (RadioButton) findViewById(R.id.opt5b);
        if (checkQ5.isChecked()) {
            sarcasmIndex += 2;
        }
        checkQ5 = (RadioButton) findViewById(R.id.opt5c);
        if (checkQ5.isChecked()) {
            sarcasmIndex += 3;
        }

        // Question 6
        // Radio Group
        RadioButton checkQ6 = (RadioButton) findViewById(R.id.opt6a);
        if (checkQ6.isChecked()) {
            sarcasmIndex += 1;
        }
        checkQ6 = (RadioButton) findViewById(R.id.opt6b);
        if (checkQ6.isChecked()) {
            sarcasmIndex += 2;
        }
        checkQ6 = (RadioButton) findViewById(R.id.opt6c);
        if (checkQ6.isChecked()) {
            sarcasmIndex += 3;
        }

        return sarcasmIndex;


    }

}
