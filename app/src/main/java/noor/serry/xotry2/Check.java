package noor.serry.xotry2;

import android.content.Context;
import android.widget.Toast;

public class Check {
    int[][]cell;

    boolean playerWin=false;
    public  Check(int [][]cell){
        this.cell=cell;

    }
    public void checkRows(){
        for(int i=0;i<3;i++){
            if(cell[i][0]==cell[i][1]&&cell[i][0]==cell[i][2]){
                playerWin=true;

            }
        }}
    public void checkCoulms(){
        for(int i=0;i<3;i++){
            if(cell[0][i]==cell[1][i]&&cell[0][i]==cell[2][i]) {
                playerWin = true;
            } }}
    public void checkCenter(){
        if(cell[0][0]==cell[1][1]&&cell[0][0]==cell[2][2]){
            playerWin=true;
        }
        else if(cell[0][2]==cell[1][1]&&cell[0][2]==cell[2][0]){
            playerWin=true;
         }}
    public void selectedWin(){
        checkRows();
        checkCoulms();
        checkCenter();

    }
    public void showToastMessage(boolean player1,Context context){
        if(player1){ Toast.makeText(context, "Player1 is win", Toast.LENGTH_SHORT).show();
        }
        else{Toast.makeText(context, "Player1 is win", Toast.LENGTH_SHORT).show();}
    }
    public boolean isWin(){
selectedWin();

        return playerWin;
    }
}
