package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mFirstAnswerButton;
    Button mSecondAnswerButton;
    int mCurrentStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentStory = 1;

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mFirstAnswerButton = findViewById(R.id.buttonTop);
        mSecondAnswerButton = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mFirstAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFirstAnswerButton.getText() == getResources().getString(R.string.T1_Ans1)){
                    mCurrentStory = 3;
                }
                else if(mFirstAnswerButton.getText() == getResources().getString(R.string.T2_Ans1)){
                    mCurrentStory = 3;
                }
                else if(mFirstAnswerButton.getText() == getResources().getString(R.string.T3_Ans1)){
                    mCurrentStory = 6;
                }
                updateView();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mSecondAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSecondAnswerButton.getText() == getResources().getString(R.string.T1_Ans2)){
                    mCurrentStory = 2;
                }
                else if(mSecondAnswerButton.getText() == getResources().getString(R.string.T2_Ans2)){
                    mCurrentStory = 4;
                }
                else if(mSecondAnswerButton.getText() == getResources().getString(R.string.T3_Ans2)){
                    mCurrentStory = 5;
                }
                updateView();
            }
        });

        if(savedInstanceState != null){
            mCurrentStory = savedInstanceState.getInt("StoryKey");
            updateView();
        }
        else{
            mCurrentStory = 1;
        }
    }

    private void updateView(){
        if(mCurrentStory == 1){
            mStoryTextView.setText(R.string.T1_Story);
            mFirstAnswerButton.setText(R.string.T1_Ans1);
            mSecondAnswerButton.setText(R.string.T1_Ans2);
        }else if(mCurrentStory == 2){
            mStoryTextView.setText(R.string.T2_Story);
            mFirstAnswerButton.setText(R.string.T2_Ans1);
            mSecondAnswerButton.setText(R.string.T2_Ans2);
        }
        else if(mCurrentStory == 3){
            mStoryTextView.setText(R.string.T3_Story);
            mFirstAnswerButton.setText(R.string.T3_Ans1);
            mSecondAnswerButton.setText(R.string.T3_Ans2);
        }
        else{
            mFirstAnswerButton.setVisibility(View.GONE);
            mSecondAnswerButton.setVisibility(View.GONE);

            if(mCurrentStory == 4){
                mStoryTextView.setText(R.string.T4_End);
            }
            else if(mCurrentStory == 5){
                mStoryTextView.setText(R.string.T5_End);
            }
            else if(mCurrentStory == 6){
                mStoryTextView.setText(R.string.T6_End);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("StoryKey",1);

    }
}
