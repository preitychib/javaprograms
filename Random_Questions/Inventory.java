package Simulation;

import java.util.Random;
import java.util.Scanner;

public class Inventory {

    static void cost(int reorderPoint, int quantity){
        int day=1, stock=115, dueDate=0;
        int estimatedStock, demand,unitDue=0;
        float cost=0;

        while(day<=180){
            if(dueDate==day){
                stock+=quantity;
                unitDue=0;
            }
            Random random = new Random();
            demand=random.nextInt(100);

            if(demand>stock){
                cost+= (demand - stock)* 18.00;
                stock=0;
            }else{
                stock-=demand;
                cost+= (stock*0.75);
            }

            estimatedStock = stock + unitDue;
            if(estimatedStock<=reorderPoint){
                unitDue=quantity;
                cost+= 75.00;
                dueDate= day+3;
            }

            day++;
        }
        // System.out.println("ReOder cost= "+reorderPoint);
        // System.out.println("Quantity "+ quantity);
        System.out.println("Cost "+cost);

    }
    public static void main(String[] args) {
        int reorderPoint,quantity;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println("Enter value of reorder point");
            reorderPoint= sc.nextInt();
            System.out.println("Enter value of quantity");
            quantity= sc.nextInt();
            cost(reorderPoint, quantity);
        }
    }
}
