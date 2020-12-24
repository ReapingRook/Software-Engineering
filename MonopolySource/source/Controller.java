package source;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

import static source.Main.numplayers;
import static source.Main.numturns;

public class Controller {
    private InfoPop AlertBox;
    public int test123;
    public int playerId;
    private Space[] spaces;
    GameEngine twoPlay;


    public Controller (){
    }

    @FXML
    private void startGame(MouseEvent event){
    	twoPlay.startGame(); 
    }



    @FXML
    private void selectImage(MouseEvent event)
    {
        test123 = Integer.parseInt(((Pane)event.getSource()).getId());

        if(twoPlay.spaces[test123].type == SpaceType.PROPERTY) {
            ArrayList<Integer> results = new ArrayList<Integer>();
            for (int element: twoPlay.spaces[test123].property.deed.rent) {
                results.add(element);
            }
            InfoPopup.display("Monopoly Space " + (twoPlay.spaces[test123].spaceNumber), "This is the property: " + (twoPlay.spaces[test123].property.name)
                    + "\nIt is the color: " + (twoPlay.spaces[test123].property.group.name)
                    + "\nThis is the buy price: " + twoPlay.spaces[test123].property.deed.buyPrice
                    + "\nRent with 0 - 4 Houses then with hotel: " + results.toString()
                    + "\nMortgage value: " + twoPlay.spaces[test123].property.deed.buyPrice/2
                    + "\nHouse and Hotel value: " + twoPlay.spaces[test123].property.deed.housePrice);
        } else if (twoPlay.spaces[test123].type == SpaceType.RAILROAD ) {
            ArrayList<Integer> results = new ArrayList<Integer>();
            for (int element: twoPlay.spaces[test123].property.deed.rent) {
                results.add(element);
            }
            InfoPopup.display("Monopoly Space " + (twoPlay.spaces[test123].spaceNumber), "This is the property: " + (twoPlay.spaces[test123].property.name)
                    + "\nIt is the color: " + (twoPlay.spaces[test123].property.group.name)
                    + "\nThis is the buy price: " + twoPlay.spaces[test123].property.deed.buyPrice
                    + "\nRent with 0 - 3 Railroads owned: " + results.toString()
                    + "\nMortgage value: " + twoPlay.spaces[test123].property.deed.buyPrice/2);
        } else if (twoPlay.spaces[test123].type == SpaceType.UTILITY) {
            ArrayList<Integer> results = new ArrayList<Integer>();
            for (int element: twoPlay.spaces[test123].property.deed.rent) {
                results.add(element);
            }
            InfoPopup.display("Monopoly Space " + (twoPlay.spaces[test123].spaceNumber), "This is the property: " + (twoPlay.spaces[test123].property.name)
                    + "\nIt is the color: " + (twoPlay.spaces[test123].property.group.name)
                    + "\nThis is the buy price: " + twoPlay.spaces[test123].property.deed.buyPrice
                    + "\nIf ONE Utility is owned, rent is 4x the number on the dice which landed the player on the utility, but if BOTH Utilities are owned, rent is 10x the amount shown on the dice."
                    + "\nMortgage value: " + twoPlay.spaces[test123].property.deed.buyPrice/2);

        }

    }

    @FXML
    private void playerInfo(MouseEvent event) {
        playerId = Integer.parseInt(((Button)event.getSource()).getId());



        if(playerId <= numplayers - 1) {
            if(twoPlay.players[playerId].currentSpace.type == SpaceType.GO){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: GO");

            }else if (twoPlay.players[playerId].currentSpace.type == SpaceType.PARKING){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: Free Parking");

            }else if (twoPlay.players[playerId].currentSpace.type == SpaceType.LUXURY){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: Luxury Tax" + twoPlay.players[playerId].currentSpace.property.name);

            }else if (twoPlay.players[playerId].currentSpace.type == SpaceType.JAIL){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: Jail");

            }else if (twoPlay.players[playerId].currentSpace.type == SpaceType.GOTOJAIL){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: Go To Jail");

            } else if(twoPlay.players[playerId].currentSpace.type == SpaceType.INCOME){
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: Income Tax");

            }else{
                InfoPopup.display("Player " + (twoPlay.players[playerId].playerNum + 1) + " Info",
                        "\nPlayer Funds: " + (twoPlay.players[playerId].money)
                                + "\nNumber of property owned: " + twoPlay.players[playerId].numProperties
                                + "\nCurrent Location: " + twoPlay.players[playerId].currentSpace.property.name);
            }
        	
        } else {
        	
        	try{    
        		((Button)event.getSource()).setVisible(false);  
        		}catch(Exception ref){}
        }
        
        
        

 
    }

    @FXML
    private void position(MouseEvent e){
        double relativeX = e.getX();
        double relativeY = e.getY();
        System.out.println("x: " + relativeX + "y: " + relativeY);
    }


    
    public void initializeEngine(int numplayers, int numturns) {
    	twoPlay = new GameEngine(numplayers, numturns);
    }


}