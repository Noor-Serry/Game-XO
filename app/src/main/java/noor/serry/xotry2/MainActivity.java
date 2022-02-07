package noor.serry.xotry2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
int [][]cell;
static boolean player1, player2;
boolean randomPlay[],playFinsh=false;
TextView viewPlayer1,viewPlayer2;
Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       startGame();
    }
    Check check;
    public void startGame(){
        setContentView(R.layout.activity_main);
        viewPlayer1=findViewById(R.id.textViewpl1);
        viewPlayer2=findViewById(R.id.textViewpl2);
        viewPlayer1.setText("Player1:"+scorePlayer1);
        viewPlayer2.setText("player2:"+scorePlayer2);
        cell= new int[][]{{-1,-2,-3}, {-4,-5,-6}, {-7, -8,-9}};
      check  =new Check(cell);
        randomPlayFirst();
        setColorInViewPlayer();
    }

    public void randomPlayFirst(){
        randomPlay=new boolean[2];
        randomPlay[0]=true;
        randomPlay[1]=false;
        player1=randomPlay[new Random().nextInt(2)];
        if(player1){}
        else{player2=true;}
    }
    int id;

    public void actionFromPlayer(View v){
        if(!check.isWin()){
id=v.getId();
inFlateButton();
addLoctionButtonToArray((int)v.getRotationX(),(int)v.getRotationY());
setXorO();
setColorInViewPlayer();
disPlayButtonPlayed();
        if(check.isWin()){showToastMessage();
            incresScore();
          }}

    }
    public void inFlateButton(){
        button1  =findViewById(id);
    }
    public void addLoctionButtonToArray(int row,int cou){
        if(player1){
            cell[row][cou]=1;}
        else {cell[row][cou]=2;}
    }
    public void disPlayButtonPlayed(){
        button1.setEnabled(false);
    }
    public void setXorO(){
        if(player1){
        button1.setBackground(getDrawable(R.drawable.x));
        player1=false;
        player2=true;}
        else{ button1.setBackground(getDrawable(R.drawable.o));
        player2=false;
        player1=true;}
    }
    public void showToastMessage(){
        if(player1){ Toast.makeText(this, "Player2 is win", Toast.LENGTH_SHORT).show();
        }
        else{Toast.makeText(this, "Player1 is win", Toast.LENGTH_SHORT).show();}
    }


        public void setColorInViewPlayer(){
        if(player1){
            viewPlayer1.setBackgroundColor(Color.BLUE);
            viewPlayer2.setBackgroundColor(getColor(R.color.gray)); }
        else{ viewPlayer2.setBackgroundColor(Color.RED);
        viewPlayer1.setBackgroundColor(getColor(R.color.gray));
        }}
     int  scorePlayer1=0,scorePlayer2=0;
    public void incresScore(){
        playFinsh=true;
        if(player1){
            scorePlayer1++;
        }
        else{scorePlayer2++;}
        setNewScoreIntextView();
    }
        public void setNewScoreIntextView(){
            viewPlayer1.setText("player1:"+scorePlayer1);
            viewPlayer2.setText("player2:"+scorePlayer2);
        }


    public void restart(View v){
         startGame();
        playFinsh=false;
}
}








