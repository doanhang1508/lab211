/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaipt;

/**
 *
 * @author Thanh Hang
 */
public class Equatation {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaipt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh Hang
 */
public class Equatation {
    public List<Float> superlative(float a, float b){
        List<Float> result = new ArrayList<>();
        
        if(a==0&&b==0) return result;
        if(a==0) return null;
        
        float x = -b/a;
        result.add(x);
        return result;
    }
    public List<Float> quadratic(float a, float b, float c){
        List<Float> result = new ArrayList<>();
        if(a==0){
            return superlative(b,c);
        }
        float delta = b*b-4*a*c;
        if(delta<0) return null;
        else if(delta==0){
            float x=-b/(2*a);
            result.add(x);
        }
        else{
            float x1 = (float) ((-b+Math.sqrt(delta))/(2*a));
            float x2 = (float) ((-b-Math.sqrt(delta))/(2*a));
            result.add(x1);
            result.add(x2);
        }
        return result;
    }
    
}

}

