/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author extre
 */
public class Checkerboard {
    private double width;
    private double height;
    private int rows;
    private int columns;
    private double rectangleWidth;
    private double rectangleHeight;
    private AnchorPane anchorPane;
    
    private Color lightColor;
    private Color darkColor;
    
    public Checkerboard(int rows, int columns, double boardWidth, double boardHeight) {
        this.rows = rows;
        this.columns = columns;
       
        anchorPane = new AnchorPane();
        
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
    }
    public Checkerboard(int rows, int columns, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.rows = rows;
        this.columns = columns;
       
        anchorPane = new AnchorPane();
        
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
  
    
    
    public AnchorPane build(double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        rectangleWidth = Math.ceil(width / (double)columns);
        rectangleHeight = Math.ceil((height-55) / (double)rows);  
        //55 to account for menuBar
       
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
    
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight);
                
                rect.setFill(lightColor);
               
                if((row+col)%2 == 1){
                    rect.setFill(darkColor);
                }

                double xPosition = row*rectangleWidth;
                double yPosition = col*rectangleHeight;

                AnchorPane.setTopAnchor(rect, yPosition);
                AnchorPane.setLeftAnchor(rect, xPosition);
                
                anchorPane.getChildren().add(rect);
            }
        }
        
        return anchorPane;
    }
    
       public void clear() {
        anchorPane.getChildren().clear();
    }
    
    public AnchorPane getBoard() {
        if(anchorPane == null){
            return null;
        }
            
        return anchorPane;
    }
    
    public int getNumRows() {
        return rows;
    }
    
    public int getNumCols() {
        return columns;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
    
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    public void setLightColor(Color lightColor){
        this.lightColor = lightColor;
    }
    public void setDarkColor(Color darkColor){
        this.darkColor = darkColor;
    }
}
